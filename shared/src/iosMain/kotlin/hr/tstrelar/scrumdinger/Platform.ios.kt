package hr.tstrelar.scrumdinger

import platform.Foundation.NSUUID
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()
actual fun generateUUID() = NSUUID.UUID().UUIDString