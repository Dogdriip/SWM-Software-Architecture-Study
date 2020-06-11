import java.io.IOException
import java.io.OutputStream
import java.net.Socket
import java.net.UnknownHostException

fun main() {
    println("Client ON")

    try {
        var message: String

        val socket = Socket("127.0.0.1", 5000)
        val out: OutputStream = socket.getOutputStream()
        message = "0x5001|홍길동|22"
        out.write(message.toByteArray())
        socket.close()

        val socket2 = Socket("127.0.0.1", 5000)
        val out2: OutputStream = socket2.getOutputStream()
        message = "0x6001|hong|1234|홍길동|22|남성"
        out2.write(message.toByteArray())
        socket2.close()

    } catch (e: UnknownHostException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}