package Item

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import Api.ZbxListUtils
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestItem : ZabbixApiRequest() {

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

        var selectHosts: ArrayList<String>? = null

        @JsonGetter("selectHosts")
        fun anotherGetSelectHosts(): Any? {
            selectHosts?.let {
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


        var selectItemDiscovery: ArrayList<String>? = null

        @JsonGetter("selectItemDiscovery")
        fun anotherGetSelectItemDiscovery(): Any? {
            selectItemDiscovery?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectPreprocessing: ArrayList<String>? = null

        @JsonGetter("selectPreprocessing")
        fun anotherGetSelectPreprocessing(): Any? {
            selectItemDiscovery?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }


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
