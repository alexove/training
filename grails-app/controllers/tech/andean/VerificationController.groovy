package tech.andean

class VerificationController {

    static allowedMethods=[index:['GET','POST']]

    def index(String lastName,String serialNumber) {
        if(lastName!=null && serialNumber!=null){

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
            if(c.size()==1){
                [existe:true,serialNumber:serialNumber,student:c.get(0).enrollment.student,
                enrollment:c.get(0).enrollment,course:c.get(0).enrollment.course]
            }else{
                [existe:false]
            }
        }
    }
}
