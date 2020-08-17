package Host

import Api.ZabbixApiException
import Api.ZabbixApiMethod


class Host(apiUrl: String?, auth: String?) : ZabbixApiMethod(apiUrl, auth) {

    @Throws(ZabbixApiException::class)
    fun get(requestHost: RequestHost): Any? {

        val resp = ResponseHost()

        requestHost.auth = auth
        requestHost.method = "host.get"

        val requestJson = serialize(requestHost)


        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                val data = jsonNode1.toString()

                resp.result = deserializeToList(data, ResponseHost.Result()) as MutableList<ResponseHost.Result>
            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}