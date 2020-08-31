package Host

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import Api.ZbxListUtils
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestHost : ZabbixApiRequest() {
    val params = Params()

    class Params : GetRequestCommonParams() {

        var groupids: ArrayList<String?>? = null
        fun addGroupids(id: String) {
            groupids = ZbxListUtils.add(groupids, id)
        }

        var applicationids: ArrayList<String>? = null
        fun addApplicationId(id: String) {
            applicationids = ZbxListUtils.add(applicationids, id)
        }

        var dserviceids: ArrayList<String?>? = null
        fun addDserviceId(id: String) {
            dserviceids = ZbxListUtils.add(dserviceids, id)
        }

        var graphids: ArrayList<String?>? = null
        fun addGraphId(id: String) {
            graphids = ZbxListUtils.add(graphids, id)
        }

        var hostids: ArrayList<String?>? = null
        fun addHostids(id: String) {
            hostids = ZbxListUtils.add(hostids, id)
        }


        var httptestids: ArrayList<String?>? = null
        fun addhttptestids(id: String) {
            httptestids = ZbxListUtils.add(httptestids, id)
        }

        var interfaceids: ArrayList<String?>? = null
        fun addInterfaceids(id: String) {
            interfaceids = ZbxListUtils.add(interfaceids, id)
        }

        var itemids: ArrayList<String?>? = null
        fun addItemids(id: String) {
            itemids = ZbxListUtils.add(itemids, id)
        }

        var maintenanceids: ArrayList<String?>? = null
        fun addMaintenanceids(id: String) {
            maintenanceids = ZbxListUtils.add(maintenanceids, id)
        }

        var monitored_hosts: Boolean? = null
        var proxy_hosts: Boolean? = null

        var proxyids: ArrayList<String?>? = null
        fun addProxyids(id: String) {
            proxyids = ZbxListUtils.add(proxyids, id)
        }

        var templated_hosts: Boolean? = null
        var templateids: ArrayList<String?>? = null
        fun addTemplateids(id: String) {
            templateids = ZbxListUtils.add(templateids, id)
        }

        var triggerids: ArrayList<String?>? = null
        fun addTriggerids(id: String) {
            triggerids = ZbxListUtils.add(triggerids, id)
        }

        var selectGroups: ArrayList<String>? = null
        fun addSelectGroups(id: String) {
            selectGroups = ZbxListUtils.add(selectGroups, id)
        }

        @JsonGetter("selectGroups")
        fun anotherGetselectGroups(): Any? {
            selectGroups?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }


        var selectApplications: ArrayList<String>? = null
        fun addSelectApplications(id: String) {
            selectApplications = ZbxListUtils.add(selectApplications, id)
        }

        @JsonGetter("selectApplications")
        fun anotherGetSelectApplications(): Any? {
            selectApplications?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectDiscoveries: ArrayList<String>? = null
        fun addSelectDiscoveries(id: String) {
            selectDiscoveries = ZbxListUtils.add(selectDiscoveries, id)
        }

        @JsonGetter("selectDiscoveries")
        fun anotherGetSelectDiscoveries(): Any? {
            selectDiscoveries?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectDiscoveryRule: ArrayList<String>? = null
        fun addSelectDiscoveryRule(id: String) {
            selectDiscoveryRule = ZbxListUtils.add(selectDiscoveryRule, id)
        }

        @JsonGetter("selectDiscoveryRule")
        fun anotherGetSelectDiscoveryRule(): Any? {
            selectDiscoveryRule?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectGraphs: ArrayList<String>? = null
        fun addSelectGraphs(id: String) {
            selectGraphs = ZbxListUtils.add(selectGraphs, id)
        }

        @JsonGetter("selectGraphs")
        fun anotherGetSelectGraphs(): Any? {
            selectGraphs?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectHostDiscovery: ArrayList<String>? = null
        fun addSelectHostDiscovery(id: String) {
            selectHostDiscovery = ZbxListUtils.add(selectHostDiscovery, id)
        }

        @JsonGetter("selectHostDiscovery")
        fun anotherGetSelectHostDiscovery(): Any? {
            selectHostDiscovery?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectHttpTests: ArrayList<String>? = null
        fun addSelectHttpTests(id: String) {
            selectHttpTests = ZbxListUtils.add(selectHttpTests, id)
        }

        @JsonGetter("selectHttpTests")
        fun anotherGetSelectHttpTests(): Any? {
            selectHttpTests?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectInterfaces: ArrayList<String>? = null
        fun addSelectInterfaces(id: String) {
            selectInterfaces = ZbxListUtils.add(selectInterfaces, id)
        }

        @JsonGetter("selectInterfaces")
        fun anotherGetSelectInterfaces(): Any? {
            selectInterfaces?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectInventory: ArrayList<String>? = null
        fun addSelectInventory(id: String) {
            selectInventory = ZbxListUtils.add(selectInventory, id)
        }

        @JsonGetter("selectInventory")
        fun anotherGetSelectInventory(): Any? {
            selectInventory?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectItems: ArrayList<String>? = null
        fun addSelectItems(id: String) {
            selectItems = ZbxListUtils.add(selectItems, id)
        }

        @JsonGetter("selectItems")
        fun anotherGetSelectItems(): Any? {
            selectItems?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectMacros: ArrayList<String>? = null
        fun addSelectMacros(id: String) {
            selectMacros = ZbxListUtils.add(selectMacros, id)
        }

        @JsonGetter("selectMacros")
        fun anotherGetSelectMacros(): Any? {
            selectMacros?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectParentTemplates: ArrayList<String>? = null
        fun addSelectParentTemplates(id: String) {
            selectParentTemplates = ZbxListUtils.add(selectParentTemplates, id)
        }

        @JsonGetter("selectParentTemplates")
        fun anotherGetSelectParentTemplates(): Any? {
            selectParentTemplates?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectScreens: ArrayList<String>? = null
        fun addSelectScreens(id: String) {
            selectScreens = ZbxListUtils.add(selectScreens, id)
        }

        @JsonGetter("selectScreens")
        fun anotherGetSelectScreens(): Any? {
            selectScreens?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectTriggers: ArrayList<String>? = null
        fun addSelectTriggers(id: String) {
            selectTriggers = ZbxListUtils.add(selectTriggers, id)
        }

        @JsonGetter("selectTriggers")
        fun anotherGetSelectTriggers(): Any? {
            selectTriggers?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }


    }


}
