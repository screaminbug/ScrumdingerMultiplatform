package hr.tstrelar.scrumdinger

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun generateUUID(): String