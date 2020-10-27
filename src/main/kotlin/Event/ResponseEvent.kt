package Event

import Api.ZabbixApiResponse
import Host.ResponseHost
import java.util.*


class ResponseEvent : ZabbixApiResponse() {
    var result: MutableList<Result> = ArrayList()

    class Result : EventObject() {
        //---------------
        val hosts: ArrayList<ResponseHost.Result?>? = null
    }

}