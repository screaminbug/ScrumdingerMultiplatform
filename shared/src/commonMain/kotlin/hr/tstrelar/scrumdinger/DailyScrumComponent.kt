package hr.tstrelar.scrumdinger

import hr.tstrelar.scrumdinger.model.DailyScrum
import hr.tstrelar.scrumdinger.model.DailyScrum.Companion.toAttendees
import hr.tstrelar.scrumdinger.model.Theme
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json

class DailyScrumComponent : Closable {
//    private val httpClient = HttpClient {
//        Napier.d("Opening http client...")
//        install(ContentNegotiation) {
//            json(Json {
//                prettyPrint = true
//                isLenient = true
//                ignoreUnknownKeys = true
//            })
//        }
//    }

    // For now it's not suspending but it will be when we will be fetching from the web service
    suspend fun getCurrentScrums() = listOf(
        DailyScrum(
            title = "Design",
            attendees = listOf("Cathy", "Daisy", "Simon", "Jonathan").toAttendees(),
            lengthInMinutes = 10,
            theme = Theme.yellow
        ),
        DailyScrum(
            title = "App Dev",
            attendees = listOf("Katie", "Gray", "Euna", "Luis", "Darla").toAttendees(),
            lengthInMinutes = 5,
            theme = Theme.orange
        ),
        DailyScrum(
            title = "Web Dev",
            attendees = listOf("Chella", "Chris", "Christina", "Eden", "Karla", "Lindsey", "Aga", "Chad", "Jenn", "Sarah").toAttendees(),
            lengthInMinutes = 5,
            theme = Theme.poppy
        )
    )

    override fun closeResources() {
//        Napier.d("Closing http client...")
//        httpClient.close()
    }

}