import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

class HandlerData {
    @Attribute(required = false)
    val header: String? = null

    @Text
    val handler: String? = null

}