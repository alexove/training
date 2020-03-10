package tech.andean

class Course {
    String title
    String resume
    int duration
    int academicHours

    static constraints = {
        title unique:true
    }
}
