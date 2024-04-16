package model.data

import org.jetbrains.exposed.dao.id.IntIdTable

object Requests : IntIdTable() {
    val collectionId = reference("collectionId", Collections)
    val method = varchar("method", 10)
    val url = varchar("url", 255)
    val headers = varchar("headers", 255)
    val body = varchar("body", 255)
}