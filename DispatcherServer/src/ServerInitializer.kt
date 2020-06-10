import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket

fun main() {
    val port: Int = 5000
    println("Server ON: $port")

    try {
        val serverSocket: ServerSocket = ServerSocket(port)
        var connection: Socket


        while (true) {
            connection = serverSocket.accept()
            val inputStreamReader = InputStreamReader(connection.getInputStream())
            val bufferedReader = BufferedReader(inputStreamReader)
            val line: String = bufferedReader.readLine()

            println("READ: $line")
        }

    } catch (e: IOException) {
        e.printStackTrace()
    }
}