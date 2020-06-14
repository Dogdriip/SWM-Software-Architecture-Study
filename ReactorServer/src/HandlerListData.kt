import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

data class HandlerListData(
        @field:ElementList(entry = "handler", inline = true)
        var handler: List<HandlerData>?,
        @field:Attribute
        var name: String?
) {
    constructor() : this(null, null) {}
}