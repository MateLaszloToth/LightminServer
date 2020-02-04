package com.test.batchprocessing.model

class Person {
    private var lastName: String? = null
    private var firstName: String? = null

    constructor() {}
    constructor(firstName: String?, lastName: String?) {
        this.firstName = firstName
        this.lastName = lastName
    }

    fun setFirstName(firstName: String){
        this.firstName = firstName
    }
    fun getFirstName(): String? {
        return this.firstName
    }
    fun setLastName(lastName: String?) {
        this.lastName = lastName
    }
    fun getLastName(): String? {
        return this.lastName
    }

    override fun toString(): String {
        return "firstName: $firstName, lastName: $lastName"
    }
}