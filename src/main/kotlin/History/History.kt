package History

import Api.ZabbixApiException
import Api.ZabbixApiMethod


class History(apiUrl: String?, auth: String?) : ZabbixApiMethod(apiUrl, auth) {

    @Throws(ZabbixApiException::class)
    fun get(requestHistory: RequestHistory): ResponseHistory {

        val resp = ResponseHistory()

        requestHistory.auth = auth
        requestHistory.method = "history.get"

        val requestJson = serialize(requestHistory)

        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                val data = jsonNode1.toString()

                resp.result = deserializeToList(data, ResponseHistory.Result()) as MutableList<ResponseHistory.Result>

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp
    }

}