package model

import model.data.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        Database.connect(
            url = "jdbc:sqlite:database.db",
            driver = "org.sqlite.JDBC")
    transaction {
        SchemaUtils.create(Workspaces)
        SchemaUtils.create(Users)
        SchemaUtils.create(Requests)
        SchemaUtils.create(Collections)
        SchemaUtils.create(Environments)
        SchemaUtils.create(Tests)
        }
    }
}