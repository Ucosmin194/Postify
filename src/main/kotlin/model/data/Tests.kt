package model.data

import model.data.Requests
import org.jetbrains.exposed.dao.id.IntIdTable

object Tests : IntIdTable() {
    val request = reference("request", Requests)
    val script = text("script")
}