package hr.tstrelar.scrumdinger

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json

class RocketComponent {

    suspend fun launchPhrase() = try {
        "The last successful launch was on ${getDateOfLastSuccessfulLaunch()}"
    } catch (e: Exception) {
        println("Exception during getting the date of last successful launch!")
        "Error occurred"
    }

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
    private suspend fun getDateOfLastSuccessfulLaunch(): String {
        val rockets: List<RocketLaunch> = httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }
        val date = Instant.parse(lastSuccessLaunch.launchDateUtc)
            .toLocalDateTime(TimeZone.currentSystemDefault())
        return "${date.month} ${date.dayOfMonth}, ${date.year}"
    }

}