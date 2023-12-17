package hr.tstrelar.scrumdinger
import java.util.UUID
class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()
actual fun generateUUID() = UUID.randomUUID().toString()