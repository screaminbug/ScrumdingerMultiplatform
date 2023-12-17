package hr.tstrelar.scrumdinger.model

import hr.tstrelar.scrumdinger.generateUUID

data class DailyScrum(
    val id: String,
    val title: String,
    val attendees: List<Attendee>,
    val lengthInMinutes: Int,
    val theme: Theme
) {
    constructor(title: String, attendees: List<Attendee>, lengthInMinutes: Int, theme: Theme) :
            this(
                id = generateUUID(),
                title = title,
                attendees = attendees,
                lengthInMinutes = lengthInMinutes,
                theme = theme
            )
    companion object {
        data class Attendee(
            val id: String = generateUUID(),
            val name: String
        )

        fun List<String>.toAttendees() = map { Attendee(name = it) }.toList()
    }
}


