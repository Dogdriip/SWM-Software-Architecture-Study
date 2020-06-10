import java.io.IOException
import java.io.InputStream
import java.net.ServerSocket
import java.net.Socket

class Dispatcher {
    val HEADER_SIZE: Int = 6

    // main으로부터 ServerSocket을 받아와서 accept()해서 Socket을 생성
    fun dispatch(serverSocket: ServerSocket) {
        try {
            val socket: Socket = serverSocket.accept()
            demultiplex(socket)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // demultiplex : 받은 데이터를 분배
    fun demultiplex(socket: Socket) {
        try {
            val inputStream: InputStream = socket.getInputStream()

            val buffer = ByteArray(HEADER_SIZE) // size?
            inputStream.read(buffer)
            val header: String = String(buffer)

            when (header) {
                "0x5001" -> {
                    val sayHelloProtocol = StreamSayHelloProtocol()
                    sayHelloProtocol.handleEvent(inputStream)
                }
                "0x6001" -> {
                    val updateProfileProtocol = StreamUpdateProfileProtocol()
                    updateProfileProtocol.handleEvent(inputStream)
                }
                else -> { }
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}