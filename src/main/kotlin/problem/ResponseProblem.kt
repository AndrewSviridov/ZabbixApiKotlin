package problem

import Api.ZabbixApiResponse
import Host.ResponseHost
import java.util.*


class ResponseProblem : ZabbixApiResponse() {
    var result: MutableList<Result> = ArrayList()

    class Result : ProblemObject() {
        //---------------
        var hosts: ArrayList<ResponseHost.Result>? = null
    }
}