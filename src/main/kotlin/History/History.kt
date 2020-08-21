package History

import Api.ZabbixApiException
import Api.ZabbixApiMethod
import User.User


class History(var user: User) :
    ZabbixApiMethod() {

    @Throws(ZabbixApiException::class)
    fun get(requestHistory: RequestHistory): ResponseHistory {

        var resp = ResponseHistory()

        requestHistory.method = "history.get"

        try {
            user.hold()
            requestHistory.auth = user.auth
            val requestJson = serialize(requestHistory)
            val responseJson = sendRequest(requestJson, user.url)
            responseJson?.let {
                resp = deserialize(responseJson, resp) as ResponseHistory

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp
    }

}