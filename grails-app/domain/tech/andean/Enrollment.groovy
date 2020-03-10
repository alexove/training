package tech.andean

class Enrollment {
    Date beginDate
    Date endDate
    boolean active

    static belongsTo=[student:Student,course:Course]

    static constraints = {
    }
}
