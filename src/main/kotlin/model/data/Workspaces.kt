package model.data

import org.jetbrains.exposed.dao.id.IntIdTable

object Workspaces : IntIdTable() {
    val name = varchar("name", 50)
    val description = varchar("description", 255)
}