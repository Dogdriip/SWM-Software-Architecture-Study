import java.io.IOException
import java.io.InputStream
import java.util.*

class StreamSayHelloProtocol {
    // 0x5001이 헤더로 들어왔을 때 처리

    val DATA_SIZE: Int = 512  // 데이터 최대 길이
    val TOKEN_NUM: Int = 2  // 데이터 종류 : 2개

    fun handleEvent(inputStream: InputStream) = try {
        val buffer = ByteArray(DATA_SIZE)
        inputStream.read(buffer)
        val data: String = String(buffer)

        val params: Array<String?> = arrayOfNulls(DATA_SIZE)
        val token = StringTokenizer(data, "|")

        var i: Int = 0
        while (token.hasMoreTokens()) {
            params[i] = token.nextToken()
            i++
        }

        sayHello(params)

    } catch (e: IOException) {
        e.printStackTrace()
    }

    private fun sayHello(params: Array<String?>) {
        println("SayHello -> name : ${params[0]}, age : ${params[1]}")
    }

}