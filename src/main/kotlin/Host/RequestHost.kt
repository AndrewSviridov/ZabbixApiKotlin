package Host

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import Api.ZbxListUtils
import com.fasterxml.jackson.annotation.JsonInclude


// todo сделать чтобы и поля с значениями по умолчанию не попадали, как например proxy_host
@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestHost() : ZabbixApiRequest() {
    val params = Params()

    class Params : GetRequestCommonParams() {
        override var output: ArrayList<String>? = null
        var groupids: ArrayList<Int?>? = null
        var applicationids: ArrayList<Int>? = null
        var dserviceids: ArrayList<Int?>? = null
        var graphids: ArrayList<Int?>? = null
        var hostids: ArrayList<Int?>? = null
        var httptestids: ArrayList<Int?>? = null
        var interfaceids: ArrayList<Int?>? = null
        var itemids: ArrayList<Int?>? = null
        var maintenanceids: ArrayList<Int?>? = null
        var monitored_hosts: Boolean? = null
        var proxy_hosts: Boolean? = null
        var proxyids: ArrayList<Int?>? = null
        var templated_hosts: Boolean? = null
        var templateids: ArrayList<Int?>? = null
        var triggerids: ArrayList<Int?>? = null
        var selectGroups: String? = null
        var selectApplications: String? = null
        var selectDiscoveries: String? = null
        var selectDiscoveryRule: String? = null
        var selectGraphs: String? = null
        var selectHostDiscovery: String? = null
        var selectHttpTests: String? = null
        var selectInterfaces: String? = null
        var selectInventory: String? = null
        var selectItems: String? = null
        var selectMacros: String? = null
        var selectParentTemplates: String? = null
        var selectScreens: String? = null
        var selectTriggers: String? = null

        fun addApplicationId(id: Int) {
            applicationids = ZbxListUtils.add(applicationids, id)
        }

        fun addDserviceId(id: Int) {
            dserviceids = ZbxListUtils.add(dserviceids, id)
        }

        fun addGraphId(id: Int) {
            graphids = ZbxListUtils.add(graphids, id)
        }

    }


}
