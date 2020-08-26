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
        var selectApplications: ArrayList<String>? = null

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
