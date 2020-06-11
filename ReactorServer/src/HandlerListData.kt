import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

class HandlerListData {
    @ElementList(entry = "handler", inline = true)
    val handler: List<HandlerData>? = null

    @Attribute
    val name: String? = null

}