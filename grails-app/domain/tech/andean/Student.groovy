package tech.andean

class Student extends User{
    String studentId


    static constraints = {
        studentId unique:true
    }
}
