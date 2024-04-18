package model.dao

import model.data.Collections
import model.data.Requests
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class CollectionsDAO {
    fun addCollection(name: String, workspaceId: Int, userId: Int) = transaction {
        Collections.insert {
            it[Collections.name] = name
            it[Collections.workspaceId] = workspaceId
            it[Collections.userId] = userId
        }
    }

    fun updateCollection(collectionId: Int, name: String) = transaction {
        Collections.update({ Collections.id eq collectionId }) {
            it[Collections.name] = name
        }
    }

    fun deleteCollection(collectionId: Int) = transaction {
        Collections.deleteWhere { Collections.id eq collectionId }
    }

    fun getAllCollections() = transaction {
        Collections.selectAll().map {
            it[Collections.name]
        }
    }
    fun addRequest(request: Requests) = transaction {
        Requests.insert {
            it[Requests.collectionId] = collectionId
            it[Requests.method] = request.method
            it[Requests.url] = request.url
            it[Requests.headers] = request.headers
            it[Requests.body] = request.body
        }
    }
    fun removeRequest(requestId: Int) = transaction {
        Requests.deleteWhere { Requests.id eq requestId }
    }
    fun listRequests(collectionId: Int) = transaction {
        Requests.selectAll().where { Requests.collectionId eq collectionId }
    }
}