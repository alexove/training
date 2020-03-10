package tech.andean

class Teacher extends User{
    String resume
     static hasMany = [courses:Course]
    static constraints = {
    }
}
