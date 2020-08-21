package Host

import Api.ZabbixApiException
import Api.ZabbixApiMethod
import User.User


class Host(var user: User) : ZabbixApiMethod() {

    @Throws(ZabbixApiException::class)
    fun get(requestHost: RequestHost): ResponseHost {

        var resp = ResponseHost()

        requestHost.method = "host.get"

        try {
            user.hold()
            requestHost.auth = user.auth
            val requestJson = serialize(requestHost)
            val responseJson = sendRequest(requestJson, user.url)
            responseJson?.let {

                resp = deserialize(responseJson, resp) as ResponseHost

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}