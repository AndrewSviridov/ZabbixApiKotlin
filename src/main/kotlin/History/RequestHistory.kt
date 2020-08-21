package History

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import Api.ZbxListUtils
import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestHistory() : ZabbixApiRequest() {

    val params = Params()


    class Params : GetRequestCommonParams() {
        var history: Int? = null
        var hostids: ArrayList<String>? = null
        var itemids: ArrayList<String>? = null
        var time_from: Long? = null
        var time_till: Long? = null

        // из за ошибки в Api приходиться так сделать с параметром output
  /*      @JsonIgnore
        override var output: ArrayList<String>? = null

        @JsonProperty("output")
        var output1: String? = null
*/
        fun addHostId(id: String) {
            hostids = ZbxListUtils.add(hostids, id)
        }

        fun addItemId(id: String) {
            itemids = ZbxListUtils.add(hostids, id)
        }


    }
}