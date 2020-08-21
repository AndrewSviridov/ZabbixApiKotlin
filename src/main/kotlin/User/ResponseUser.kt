package User

import Api.ZabbixApiResponse
import com.fasterxml.jackson.annotation.JsonProperty

class ResponseUser() : ZabbixApiResponse() {
    @JsonProperty("result")
    var result: MutableList<Result> = ArrayList()

    class Result : UserObject() {

        @JsonProperty("sessionid")
        var sessionid: String? = null

        @JsonProperty("debug_mode")
        var debug_mode: Boolean? = null

        @JsonProperty("userip")
        var userip: String? = null

        @JsonProperty("gui_access")
        var gui_access: String? = null


    }

}