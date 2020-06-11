import java.io.InputStream

interface EventHandler {

    // Handler마다 가지고 있는 고유 키값을 반환 (HandlerMap에 키값으로 등록하기 위함)
    fun getHandler(): String
    // 데이터를 받아서 처리
    fun handleEvent(inputStream: InputStream)


}