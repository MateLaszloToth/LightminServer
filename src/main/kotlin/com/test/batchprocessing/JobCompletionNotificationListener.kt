package com.test.batchprocessing

import com.test.batchprocessing.model.Person
import org.slf4j.LoggerFactory
import org.springframework.batch.core.*
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.function.Consumer


@Component
class JobCompletionNotificationListener @Autowired constructor(private val jdbcTemplate: JdbcTemplate) : JobExecutionListenerSupport() {
    override fun afterJob(jobExecution: JobExecution) {
        if (jobExecution.status == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results")
            jdbcTemplate.query("SELECT first_name, last_name FROM people"
            ) { rs: ResultSet, row: Int ->
                Person(
                        rs.getString(1),
                        rs.getString(2))
            }.forEach(Consumer { person: Person -> log.info("Found <$person> in the database.") })
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(JobCompletionNotificationListener::class.java)
    }

}


class XXXStepListener() : StepExecutionListener {

    override fun beforeStep(stepExecution: StepExecution) {
        println("Before step")
    }
    override fun afterStep(stepExecution: StepExecution): ExitStatus? {
        println("Step finished")
        return stepExecution.exitStatus
    }
}