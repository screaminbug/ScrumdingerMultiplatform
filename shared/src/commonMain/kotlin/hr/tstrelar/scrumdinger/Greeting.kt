package hr.tstrelar.scrumdinger

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

class Greeting : ClosableFlow<String> {
    private val platform: Platform = getPlatform()
    private val rocketComponent = RocketComponent()

    init {
        Napier.base(DebugAntilog())
    }

    @NativeCoroutines
    override fun getFlow() = flow {
        emit(if (Random.nextBoolean()) "Hoya!" else "Ahoy!")
        delay(1.seconds)
        emit("Guess what this is! > ${platform.name.reversed()}")
        delay(1.seconds)
        emit(daysPhrase())
        emit(rocketComponent.launchPhrase())
    }.also {
        Napier.d("Initializing greeting...")
    }

    override fun closeResources() {
        Napier.d("Closing resources")
        rocketComponent.closeResources()
    }
}