package model.data

import org.jetbrains.exposed.dao.id.IntIdTable

object Users : IntIdTable() {
    val name = varchar("username", 50).uniqueIndex()
    val email = varchar("email", 50)
}