import java.io.IOException
import java.net.ServerSocket

class Reactor {
    private lateinit var serverSocket: ServerSocket
    private lateinit var handleMap: HandleMap

    constructor(port: Int) {
        handleMap = HandleMap()
        try {
            serverSocket = ServerSocket(port)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun startServer() {
        val dispatcher = Dispatcher()

        while (true) {
            dispatcher.dispatch(serverSocket, handleMap)
        }
    }

    // Overloading: xml에서 헤더명을 가져와서 등록
    fun registerHandler(header: String, handler: EventHandler) {
        handleMap.put(header, handler)
    }

    // handleMap에 EventHandler를 등록
    fun registerHandler(handler: EventHandler) {
        handleMap.put(handler.getHandler(), handler)  // 핸들러의 헤더 (ex: 0x5001), 핸들러 쌍 등록
    }

    fun removeHandler(handler: EventHandler) {
        handleMap.remove(handler.getHandler())
    }

}