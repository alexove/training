package tech.andean

import tech.andean.Student
import tech.andean.Course
import tech.andean.Enrollment
import tech.andean.Certificate

class BootStrap {

    def init = { servletContext ->
        def student01 = new Student(dni:'43061569',name:'Alex Irmel',lastName:'Oviedo Solis',
                                    phone:'930328402',email:'alexove@alexove.me',studentId:'st01').save(flush:true)
        def course=new Course(title:'curso linux',resume:'mi super curso',duration:10,academicHours:120).save(flush:true)


        def enrollment=new Enrollment(beginDate:new Date(),endDate:new Date(),active:true,student:student01,course:course).save(flush:true)
        def certificate=new Certificate(serialNumber:'123-123',expiryDate:new Date(),enrollment:enrollment).save(flush:true)
    }
    def destroy = {
    }
}
