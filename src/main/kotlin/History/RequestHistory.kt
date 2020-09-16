package History

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import Api.ZbxListUtils
import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestHistory : ZabbixApiRequest() {

    val params = Params()


    class Params : GetRequestCommonParams() {
        var history: Int? = null
        var hostids: ArrayList<String>? = null
        var itemids: ArrayList<String>? = null
        var time_from: Long? = null
        var time_till: Long? = null


        fun addHostId(item: String) {
            hostids = ZbxListUtils.add(hostids, item)
        }

        fun addItemId(item: String) {
            itemids = ZbxListUtils.add(hostids, item)
        }


    }
}