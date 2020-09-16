package problem

import Api.ZabbixApiException
import Api.ZabbixApiMethod
import User.User


class Problem(var user: User) :
    ZabbixApiMethod() {

    @Throws(ZabbixApiException::class)
    fun get(requestProblem: RequestProblem): ResponseProblem {

        var resp = ResponseProblem()

        requestProblem.method = "problem.get"

        try {
            user.hold()
            requestProblem.auth = user.auth
            val requestJson = serialize(requestProblem)
            val responseJson = sendRequest(requestJson, user.url)
            responseJson?.let {
                resp = deserialize(responseJson, resp) as ResponseProblem

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}