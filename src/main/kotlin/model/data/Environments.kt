package model.data

import org.jetbrains.exposed.dao.id.IntIdTable

object Environments : IntIdTable() {
    val name = varchar("name", 255)
    val workspaceId = reference("workspaceId", Workspaces)
    val variables = varchar("variables", 255)

}