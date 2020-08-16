package Host

import Api.ZabbixApiException
import Api.ZabbixApiMethod


class Host(apiUrl: String?, auth: String?) : ZabbixApiMethod(apiUrl, auth) {


    @Throws(ZabbixApiException::class)
    fun get(requestHost: RequestHost): Any? {

        // todo переделать в метод setAuth?
        requestHost.auth = auth
        requestHost.method = "host.get"

        val requestJson = serialize(requestHost)

        var response: Any? = null
        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                response = ResponseHost(it).getResult()
            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return response

    }

}