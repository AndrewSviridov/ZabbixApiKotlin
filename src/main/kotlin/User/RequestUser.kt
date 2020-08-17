package User

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestUser : ZabbixApiRequest() {

    val params = Params()

    class Params : GetRequestCommonParams() {
        var password: String? = null
        var user: String? = null
        var userData: Boolean? = null

        var extend: Boolean? = null
        var sessionid: String? = null
    }


}