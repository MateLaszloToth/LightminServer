package com.test.batchprocessing.processor

import com.test.batchprocessing.model.Person
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor


class PersonItemProcessor: ItemProcessor<Person?, Person> {

    private val log = LoggerFactory.getLogger(PersonItemProcessor::class.java)

    override fun process(person: Person): Person? {
        val firstName = person.getFirstName()?.toUpperCase() ?: throw IllegalArgumentException("name expected")
        val lastName = person.getLastName()?.toUpperCase() ?: throw IllegalArgumentException("name expected")
        val transformedPerson = Person(firstName, lastName)
        log.info("Converting ($person) into ($transformedPerson)")
        return transformedPerson
    }


}