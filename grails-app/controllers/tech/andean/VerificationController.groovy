package tech.andean

class VerificationController {

    static allowedMethods=[index:['GET','POST']]

    def index(String lastName,String serialNumber) {

        def c = Certificate.withCriteria{
            eq("serialNumber",serialNumber,[ignoreCase: true])
            and {
                enrollment {
                    student {
                            eq("lastName",lastName,[ignoreCase: true])
                    }
                }
            }
        }

        render "===> ${c}"

        def certificate = Certificate.findBySerialNumber(serialNumber)
        if(certificate!=null){
            render "====> Certificado encontrado"
            // if((student=certificate.enrollment.student)!=null){
            //     if(student.lastName.equals(lastName)){
            //         // TODO: Sent to information view
            //         println "Certificate information CORRECT"
            //     }
            // }// ELSE show a error message
        }else{
            // TODO: Show certificate information error
            render "=====> Certificate information ERROR"
        }
    }
}
