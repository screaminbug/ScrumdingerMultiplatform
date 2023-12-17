package hr.tstrelar.scrumdinger

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.flow.Flow

interface NativeCoroutineFlowable<T> {
    @NativeCoroutines
    fun getFlow(): Flow<T>
}