import java.io.IOException
import java.net.ServerSocket

fun main() {
    val port: Int = 5000
    println("Server ON: $port")

    // Reactor 생성
    val reactor = Reactor(port)
    // EventHandler 등록
    reactor.registerHandler(StreamSayHelloEventHandler())
    reactor.registerHandler(StreamUpdateProfileEventHandler())
    // 실행
    reactor.startServer()
}