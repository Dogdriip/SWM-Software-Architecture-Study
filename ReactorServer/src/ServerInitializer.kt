import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.net.ServerSocket

fun main() {
    val port: Int = 5000
    println("Server ON: $port")

    // Reactor 생성
    val reactor = Reactor(port)

    try {
        val serializer: Serializer = Persister()
        val source = File("HandlerList.xml")

        // xml파일을 객체로 변환
        val serverList: ServerListData = serializer.read(ServerListData::class.java, source)


        for (handlerListData: HandlerListData in serverList.getServer()) {

            if (handlerListData.getName() == "server1") {
                val handlerList: List<HandlerData> = handlerListData.getHandler()
                for (handler: HandlerData in handlerList) {
                    try {
                        reactor.registerHandler(handler.getHeader(), Class.forName(handler.getHandler()).kotlin.objectInstance as EventHandler)
                    } catch (e: InstantiationError) {
                        e.printStackTrace()
                    } catch (e: IllegalAccessException) {
                        e.printStackTrace()
                    } catch (e: ClassNotFoundException) {
                        e.printStackTrace()
                    }
                }
                break
            }

        }


    } catch (e: Exception) {
        e.printStackTrace()
    }

    /* 기존에 일일이 registerHandler를 호출해서 핸들러를 등록했던 코드
    // EventHandler 등록
    reactor.registerHandler(StreamSayHelloEventHandler())
    reactor.registerHandler(StreamUpdateProfileEventHandler())
    */

    // 실행
    reactor.startServer()
}