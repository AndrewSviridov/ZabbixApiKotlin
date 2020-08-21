import java.util.*

//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "test3")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
open class test3() {
    // @JsonProperty("address")
    open var id = Random().nextInt(Int.MAX_VALUE)


    open var jsonrpc = "2.0"


    open lateinit var method: String


    open var auth: String? = null

}