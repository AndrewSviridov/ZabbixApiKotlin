package Event

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonInclude
import com.zabbix4j.utils.ZbxListUtils

// todo сделать чтобы и поля с значениями по умолчанию не попадали, как например proxy_host
@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestEvent() : ZabbixApiRequest() {
    val params = Params()

    class Params : GetRequestCommonParams() {
        var time_from: Long? = null
        var time_till: Long? = null
        private var itemids: List<Int>? = null
        private var groupids: List<Int>? = null
        private var templateids: List<Int?>? = null
        private var hostids: List<Int?>? = null
        private var proxyids: List<Int?>? = null
        private var interfaceids: List<Int?>? = null
        private var graphids: List<Int?>? = null
        private var triggerids: List<Int?>? = null
        private var applicationids: List<Int?>? = null
        private var webitems: Boolean? = null
        private var inherited: Boolean? = null
        private var templated: Boolean? = null
        private var monitored: Boolean? = null
        private var group: String? = null
        private var host: String? = null
        private var application: String? = null
        private var with_triggers: Boolean? = null


        fun addItemId(id: Int) {
            itemids = ZbxListUtils.add(itemids, id)
        }

        fun addGroupId(id: Int) {
            groupids = ZbxListUtils.add(groupids, id)
        }

        fun getItemids(): List<Int>? {
            return itemids
        }

        fun setItemids(itemids: List<Int>?) {
            this.itemids = itemids
        }

        fun getGroupids(): List<Int>? {
            return groupids
        }

        fun setGroupids(groupids: List<Int>?) {
            this.groupids = groupids
        }

        fun getTemplateids(): List<Int?>? {
            return templateids
        }

        fun setTemplateids(templateids: List<Int?>?) {
            this.templateids = templateids
        }

        fun getHostids(): List<Int?>? {
            return hostids
        }

        fun setHostids(hostids: List<Int?>?) {
            this.hostids = hostids
        }

        fun getProxyids(): List<Int?>? {
            return proxyids
        }

        fun setProxyids(proxyids: List<Int?>?) {
            this.proxyids = proxyids
        }

        fun getInterfaceids(): List<Int?>? {
            return interfaceids
        }

        fun setInterfaceids(interfaceids: List<Int?>?) {
            this.interfaceids = interfaceids
        }

        fun getGraphids(): List<Int?>? {
            return graphids
        }

        fun setGraphids(graphids: List<Int?>?) {
            this.graphids = graphids
        }

        fun getTriggerids(): List<Int?>? {
            return triggerids
        }

        fun setTriggerids(triggerids: List<Int?>?) {
            this.triggerids = triggerids
        }

        fun getApplicationids(): List<Int?>? {
            return applicationids
        }

        fun setApplicationids(applicationids: List<Int?>?) {
            this.applicationids = applicationids
        }

        fun getWebitems(): Boolean? {
            return webitems
        }

        fun setWebitems(webitems: Boolean?) {
            this.webitems = webitems
        }

        fun getInherited(): Boolean? {
            return inherited
        }

        fun setInherited(inherited: Boolean?) {
            this.inherited = inherited
        }

        fun getTemplated(): Boolean? {
            return templated
        }

        fun setTemplated(templated: Boolean?) {
            this.templated = templated
        }

        fun getMonitored(): Boolean? {
            return monitored
        }

        fun setMonitored(monitored: Boolean?) {
            this.monitored = monitored
        }

        fun getGroup(): String? {
            return group
        }

        fun setGroup(group: String?) {
            this.group = group
        }

        fun getHost(): String? {
            return host
        }

        fun setHost(host: String?) {
            this.host = host
        }

        fun getApplication(): String? {
            return application
        }

        fun setApplication(application: String?) {
            this.application = application
        }

        fun getWith_triggers(): Boolean? {
            return with_triggers
        }

        fun setWith_triggers(with_triggers: Boolean?) {
            this.with_triggers = with_triggers
        }

        fun addTemplateId(id: Int?) {
            templateids = ZbxListUtils.add(templateids, id)
        }

        fun addHostId(id: Int?) {
            hostids = ZbxListUtils.add(hostids, id)
        }

        fun addProxyId(id: Int?) {
            proxyids = ZbxListUtils.add(proxyids, id)
        }

        fun addInterfaceId(id: Int?) {
            interfaceids = ZbxListUtils.add(interfaceids, id)
        }

        fun addGraphId(id: Int?) {
            graphids = ZbxListUtils.add(graphids, id)
        }

        fun addTriggerId(id: Int?) {
            triggerids = ZbxListUtils.add(triggerids, id)
        }

        fun addApplicationId(id: Int?) {
            applicationids = ZbxListUtils.add(applicationids, id)
        }
    }
}