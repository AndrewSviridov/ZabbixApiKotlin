package Item

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import Api.ZbxListUtils
import com.fasterxml.jackson.annotation.JsonInclude

// todo сделать чтобы и поля с значениями по умолчанию не попадали, как например proxy_host
@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestItem() : ZabbixApiRequest() {

    val params = Params()
    class Params : GetRequestCommonParams() {
        var itemids: ArrayList<String?>? = null
        var groupids: ArrayList<String?>? = null
        var templateids: ArrayList<String?>? = null
        var hostids: ArrayList<String?>? = null
        var proxyids: ArrayList<String?>? = null
        var interfaceids: ArrayList<String?>? = null
        var graphids: ArrayList<String?>? = null
        var triggerids: ArrayList<String?>? = null
        var applicationids: ArrayList<String?>? = null
        var webitems: Boolean? = null
        var inherited: Boolean? = null
        var templated: Boolean? = null
        var monitored: Boolean? = null
        var group: String? = null
        var host: String? = null
        var application: String? = null
        var with_triggers: Boolean? = null

        /*
        Не описал эти поля, так как под них нужно сделать свои объекты
        * selectHosts
        selectInterfaces
        selectTriggers
        selectGraphs
        selectApplications
        selectDiscoveryRule
        selectItemDiscovery
        selectPreprocessing
        *
        * */

        var limitSelects: Int? = null

        fun addItemId(id: String?) {
            itemids = ZbxListUtils.add(itemids, id)
        }

        fun addGroupId(id: String?) {
            groupids = ZbxListUtils.add(groupids, id)
        }


        fun addTemplateId(id: String?) {
            templateids = ZbxListUtils.add(templateids, id)
        }

        fun addHostId(id: String?) {
            hostids = ZbxListUtils.add(hostids, id)
        }

        fun addProxyId(id: String?) {
            proxyids = ZbxListUtils.add(proxyids, id)
        }

        fun addInterfaceId(id: String?) {
            interfaceids = ZbxListUtils.add(interfaceids, id)
        }

        fun addGraphId(id: String?) {
            graphids = ZbxListUtils.add(graphids, id)
        }

        fun addTriggerId(id: String?) {
            triggerids = ZbxListUtils.add(triggerids, id)
        }

        fun addApplicationId(id: String?) {
            applicationids = ZbxListUtils.add(applicationids, id)
        }

    }


}
