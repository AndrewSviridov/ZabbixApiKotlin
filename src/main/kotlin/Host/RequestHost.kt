package Host

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonInclude
import com.zabbix4j.utils.ZbxListUtils

// todo сделать чтобы и поля с значениями по умолчанию не попадали, как например proxy_host
@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestHost() : ZabbixApiRequest() {
    // @JsonIgnore val HostObject = HostObject()

    // @JsonProperty("params2")
    val params = Params()

    //override var method: String="host.get"
    //override var auth: String?=auth


    // private val params: HashMap<String, Any> = HashMap()
    // @JsonTypeName("params")
    class Params : GetRequestCommonParams() {
        //    @JsonProperty("groupids")
        private var groupids: List<Int?>? = null

        //    @JsonProperty("applicationids")
        private var applicationids: List<Int>? = null
        private var dserviceids: List<Int?>? = null
        private var graphids: List<Int?>? = null
        private var hostids: List<Int?>? = null
        private var httptestids: List<Int?>? = null
        private var interfaceids: List<Int?>? = null
        private var itemids: List<Int?>? = null
        private var maintenanceids: List<Int?>? = null
        private var monitored_hosts: Boolean? = null
        private var proxy_hosts: Boolean? = null
        private var proxyids: List<Int?>? = null
        private var templated_hosts: Boolean? = null
        private var templateids: List<Int?>? = null
        private var triggerids: List<Int?>? = null
        private var selectGroups: String? = null
        private var selectApplications: String? = null
        private var selectDiscoveries: String? = null
        private var selectDiscoveryRule: String? = null
        private var selectGraphs: String? = null
        private var selectHostDiscovery: String? = null
        private var selectHttpTests: String? = null
        private var selectInterfaces: String? = null
        private var selectInventory: String? = null
        private var selectItems: String? = null
        private var selectMacros: String? = null
        private var selectParentTemplates: String? = null
        private var selectScreens: String? = null
        private var selectTriggers: String? = null


        fun getSelectGroups(): String? {
            return selectGroups
        }

        fun setSelectGroups(selectGroups: String?) {
            this.selectGroups = selectGroups
        }

        fun getSelectApplications(): String? {
            return selectApplications
        }

        fun setSelectApplications(selectApplications: String?) {
            this.selectApplications = selectApplications
        }

        fun getSelectDiscoveries(): String? {
            return selectDiscoveries
        }

        fun setSelectDiscoveries(selectDiscoveries: String?) {
            this.selectDiscoveries = selectDiscoveries
        }

        fun getSelectDiscoveryRule(): String? {
            return selectDiscoveryRule
        }

        fun setSelectDiscoveryRule(selectDiscoveryRule: String?) {
            this.selectDiscoveryRule = selectDiscoveryRule
        }

        fun getSelectGraphs(): String? {
            return selectGraphs
        }

        fun setSelectGraphs(selectGraphs: String?) {
            this.selectGraphs = selectGraphs
        }

        fun getSelectHostDiscovery(): String? {
            return selectHostDiscovery
        }

        fun setSelectHostDiscovery(selectHostDiscovery: String?) {
            this.selectHostDiscovery = selectHostDiscovery
        }

        fun getSelectHttpTests(): String? {
            return selectHttpTests
        }

        fun setSelectHttpTests(selectHttpTests: String?) {
            this.selectHttpTests = selectHttpTests
        }

        fun getSelectInterfaces(): String? {
            return selectInterfaces
        }

        fun setSelectInterfaces(selectInterfaces: String?) {
            this.selectInterfaces = selectInterfaces
        }

        fun getSelectInventory(): String? {
            return selectInventory
        }

        fun setSelectInventory(selectInventory: String?) {
            this.selectInventory = selectInventory
        }

        fun getSelectItems(): String? {
            return selectItems
        }

        fun setSelectItems(selectItems: String?) {
            this.selectItems = selectItems
        }

        fun getSelectMacros(): String? {
            return selectMacros
        }

        fun setSelectMacros(selectMacros: String?) {
            this.selectMacros = selectMacros
        }

        fun getSelectParentTemplates(): String? {
            return selectParentTemplates
        }

        fun setSelectParentTemplates(selectParentTemplates: String?) {
            this.selectParentTemplates = selectParentTemplates
        }

        fun getSelectScreens(): String? {
            return selectScreens
        }

        fun setSelectScreens(selectScreens: String?) {
            this.selectScreens = selectScreens
        }

        fun getSelectTriggers(): String? {
            return selectTriggers
        }

        fun setSelectTriggers(selectTriggers: String?) {
            this.selectTriggers = selectTriggers
        }

        fun setApplicationId(id: Int) {
            applicationids = ZbxListUtils.add(applicationids, id)
        }

        fun getGroupids(): List<Int?>? {
            return groupids
        }

        fun setGroupids(groupids: List<Int?>?) {
            this.groupids = groupids
        }

        fun getApplicationids(): List<Int>? {
            return applicationids
        }

        fun setApplicationids(applicationids: List<Int>?) {
            this.applicationids = applicationids
        }

        fun getDserviceids(): List<Int?>? {
            return dserviceids
        }

        fun setDserviceids(dserviceids: List<Int?>?) {
            this.dserviceids = dserviceids
        }

        fun getGraphids(): List<Int?>? {
            return graphids
        }

        fun setGraphids(graphids: List<Int?>?) {
            this.graphids = graphids
        }

        fun getHostids(): List<Int?>? {
            return hostids
        }

        fun setHostids(hostids: List<Int?>?) {
            this.hostids = hostids
        }

        fun getHttptestids(): List<Int?>? {
            return httptestids
        }

        fun setHttptestids(httptestids: List<Int?>?) {
            this.httptestids = httptestids
        }

        fun getInterfaceids(): List<Int?>? {
            return interfaceids
        }

        fun setInterfaceids(interfaceids: List<Int?>?) {
            this.interfaceids = interfaceids
        }

        fun getItemids(): List<Int?>? {
            return itemids
        }

        fun setItemids(itemids: List<Int?>?) {
            this.itemids = itemids
        }

        fun getMaintenanceids(): List<Int?>? {
            return maintenanceids
        }

        fun setMaintenanceids(maintenanceids: List<Int?>?) {
            this.maintenanceids = maintenanceids
        }

        fun getProxyids(): List<Int?>? {
            return proxyids
        }

        fun setProxyids(proxyids: List<Int?>?) {
            this.proxyids = proxyids
        }

        fun getTemplateids(): List<Int?>? {
            return templateids
        }

        fun setTemplateids(templateids: List<Int?>?) {
            this.templateids = templateids
        }

        fun getTriggerids(): List<Int?>? {
            return triggerids
        }

        fun setTriggerids(triggerids: List<Int?>?) {
            this.triggerids = triggerids
        }

        fun isProxy_hosts(): Boolean? {
            return proxy_hosts
        }

        fun setProxy_hosts(proxy_hosts: Boolean) {
            this.proxy_hosts = proxy_hosts
        }

        fun isMonitored_hosts(): Boolean? {
            return monitored_hosts
        }

        fun setMonitored_hosts(monitored_hosts: Boolean?) {
            this.monitored_hosts = monitored_hosts
        }

        fun isTemplated_hosts(): Boolean? {
            return templated_hosts
        }

        fun setTemplated_hosts(templated_hosts: Boolean?) {
            this.templated_hosts = templated_hosts
        }

        fun setDserviceId(id: Int) {
            dserviceids = ZbxListUtils.add(dserviceids, id)
        }

        fun setGraphId(id: Int) {
            graphids = ZbxListUtils.add(graphids, id)
        }

    }


/*
    class Builder {
        private val newRequestHost: RequestHost = RequestHost()
        fun setMethod(method: String): RequestHost.Builder {
            newRequestHost.method = method
            return this
        }


        fun setExtend(extend: Boolean): RequestHost.Builder {
            newRequestHost.params.put("extend", extend)
            return this
        }

        fun setAuth(auth: String): RequestHost.Builder {
            newRequestHost.auth = auth
            return this
        }

        fun setSessionId(sessionid: String): RequestHost.Builder {
            newRequestHost.params.put("sessionid", sessionid)
            return this
        }

        fun setPassword(password: String): RequestHost.Builder {
            newRequestHost.params.put("password", password)
            return this
        }

        fun setUser(user: String): RequestHost.Builder {
            newRequestHost.params.put("user", user)
            return this
        }

        fun setUserData(userData: Boolean): RequestHost.Builder {
            newRequestHost.params.put("userData", userData)
            return this
        }

        fun build(): RequestHost {
            return newRequestHost
        }
    }
*/
}
