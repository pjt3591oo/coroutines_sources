package f_203_job.s_10

import kotlinx.coroutines.*

//sampleStart
suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) { // the new job replaces one from parent
        delay(1000)
        println("Text 1")
    }
    launch(job) { // the new job replaces one from parent
        delay(2000)
        println("Text 2")
    }
    job.join() // Here we will await forever
    println("Will not be printed")
}
// (1 sec)
// Text 1
// (1 sec)
// Text 2
// (runs forever)
//sampleEnd
