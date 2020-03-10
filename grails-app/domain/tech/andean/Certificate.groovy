package tech.andean

class Certificate {
    String serialNumber
    Date expiryDate

    static belongsTo = [enrollment:Enrollment]

    static constraints = {
        serialNumber unique:true
    }
}
