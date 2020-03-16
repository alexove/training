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
                render "SI EXISTE => ${c.get(0).enrollment.student.name}"
            }else{
                render "NO EXISTE"
            }
        }
    }
}
