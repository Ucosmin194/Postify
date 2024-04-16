package model.data

import org.jetbrains.exposed.dao.id.IntIdTable

object Collections : IntIdTable() {
    val name = varchar("name", 50)
    val workspaceId = reference("workspaceId", Workspaces)
    val userId = reference("userId", Users)
}