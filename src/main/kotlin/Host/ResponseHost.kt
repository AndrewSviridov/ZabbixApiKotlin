package Host

import Api.ZabbixApiResponse


class ResponseHost() : ZabbixApiResponse() {
    var result: MutableList<Result> = ArrayList()

    class Result : HostObject() {
        var templateid: Int? = null
        var proxy_address: String? = null
        var auto_compress: Int? = null
        var discover: Int? = null
        var lastaccess: Int? = null



    }

}