import java.io.IOException
import java.net.ServerSocket

fun main() {
    val port: Int = 5000
    println("Server ON: $port")

    try {
        val serverSocket: ServerSocket = ServerSocket(port)
        val dispatcher = Dispatcher()

        while (true) {
            dispatcher.dispatch(serverSocket)
        }

    } catch (e: IOException) {
        e.printStackTrace()
    }
}