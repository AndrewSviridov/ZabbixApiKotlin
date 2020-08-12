package Api

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*


open class ZabbixApiRequest {
    @JsonProperty("id")
    open var id = Random().nextInt(Int.MAX_VALUE)

    @JsonProperty("jsonrpc")
    open var jsonrpc = "2.0"

    @JsonProperty("method")
    open lateinit var method: String

    @JsonProperty("auth")
    open var auth: String? = null

}