package tech.andean

class User {
    String dni
    String name
    String lastName
    String phone
    String email

    static constraints = {
        dni unique:true
    }
}
