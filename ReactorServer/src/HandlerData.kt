import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

data class HandlerData(
        @field:Attribute(required=false)
        var header: String?,
        @field:Text
        var text: String?
) {
    constructor() : this(null, null) {}
}