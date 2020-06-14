import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

data class ServerListData(
        @field:ElementList(entry="server", inline=true)
        var server: List<HandlerListData>?
) {
    constructor() : this(null) {}
}