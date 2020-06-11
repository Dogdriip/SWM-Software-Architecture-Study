import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

class ServerListData {
    @ElementList(entry = "server", inline = true)
    val server: List<HandlerListData>? = null
}
