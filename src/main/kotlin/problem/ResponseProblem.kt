package problem

import Api.ZabbixApiResponse
import java.util.*


class ResponseProblem : ZabbixApiResponse() {
    var result: MutableList<Result> = ArrayList()

    class Result : ProblemObject()

}