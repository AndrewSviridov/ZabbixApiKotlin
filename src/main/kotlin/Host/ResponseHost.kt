package Host

import Api.ZabbixApiResponse
import Aplication.AplicationObject
import Graph.GraphObject
import HostGroup.HostGroupObject
import HostInterface.HostInterfaceObject
import WebScenario.WebScenarioObject


class ResponseHost : ZabbixApiResponse() {
    var result: MutableList<Result> = ArrayList()

    class Result : HostObject() {
        var templateid: Int? = null
        var proxy_address: String? = null
        var auto_compress: Int? = null
        var discover: Int? = null
        var lastaccess: Int? = null

        var groups: ArrayList<HostGroupObject>? = null
        var applications: ArrayList<AplicationObject>? = null
        var graphs: ArrayList<GraphObject>? = null
        var interfaces: ArrayList<HostInterfaceObject>? = null

        // todo проверить на созданных объектах в заббиксе
        var httpTests: ArrayList<WebScenarioObject>? = null
    }

}