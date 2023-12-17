package hr.tstrelar.scrumdinger

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import hr.tstrelar.scrumdinger.model.DailyScrum
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.flow

class DailyScrums : ClosableFlow<DailyScrum> {
    private val dailyScrumComponent = DailyScrumComponent()
    init {
        Napier.base(DebugAntilog())
    }

    @NativeCoroutines
    override fun getFlow() = flow {
        dailyScrumComponent.getCurrentScrums().forEach {
            emit(it)
        }
    }.also {
        Napier.d("Initializing Scrums...")
    }

    override fun closeResources() {
        Napier.d("Closing resources")
        dailyScrumComponent.closeResources()
    }
}