package hr.tstrelar.scrumdinger
interface ClosableFlow<T> : Closable, NativeCoroutineFlowable<T>
