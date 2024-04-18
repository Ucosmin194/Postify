import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*
import model.DatabaseFactory
import ui.CollectionTab
import ui.HomeTab


@Composable
fun App() {
    MaterialTheme {
        val client = HttpClient(Apache) {
            install(ContentNegotiation) {
                gson()
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
        MainScreen(client)
    }
}

@Composable
fun MainScreen(client: HttpClient) {
    val selectedTab by remember { mutableStateOf(0) }

    DatabaseFactory.init()


    Row{
        LeftMenuColumn(Modifier.weight(1f))
        RightMenuColumn(Modifier.weight(2f))
    }

    when (selectedTab) {
        0 -> HomeTab(client)
        1 -> CollectionTab(client)
    }

}

@Composable
fun LeftMenuColumn(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button(onClick = { /*TODO*/ }) {
            Text("Home")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Collections")
        }
    }
}

@Composable
fun RightMenuColumn(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button(onClick = { /*TODO*/ }) {
            Text("Profile")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Logout")
        }
    }
}

fun main() = application {
    Window(
        title = "Postify",
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}