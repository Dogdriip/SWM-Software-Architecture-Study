import java.io.IOException
import java.io.InputStream
import java.util.*

class StreamUpdateProfileEventHandler : EventHandler {
    // 0x6001이 헤더로 들어왔을 때 처리

    val DATA_SIZE: Int = 1024  // 데이터 최대 길이
    val TOKEN_NUM: Int = 5  // 데이터 종류 : 5개

    override fun getHandler(): String = "0x6001"

    override fun handleEvent(inputStream: InputStream) = try {
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

        updateProfile(params)

    } catch (e: IOException) {
        e.printStackTrace()
    }

    private fun updateProfile(params: Array<String?>) {
        println("updateProfile -> " +
                " id : ${params[0]}" +
                " password : ${params[1]}" +
                " name : ${params[2]}" +
                " age : ${params[3]}" +
                " gender : ${params[4]}")
    }

}