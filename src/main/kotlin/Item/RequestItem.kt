package Item

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonInclude

// todo сделать чтобы и поля с значениями по умолчанию не попадали, как например proxy_host
@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestItem() : ZabbixApiRequest() {
    // @JsonIgnore val HostObject = HostObject()

    // @JsonProperty("params2")
    val params = Params()

    //override var method: String="host.get"
    //override var auth: String?=auth


    // private val params: HashMap<String, Any> = HashMap()
    // @JsonTypeName("params")
    class Params : GetRequestCommonParams() {


    }


}
