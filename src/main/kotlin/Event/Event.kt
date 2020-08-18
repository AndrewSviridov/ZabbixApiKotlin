package Event

import Api.ZabbixApiException
import Api.ZabbixApiMethod

class Event(apiUrl: String?, auth: String?, private val login: String? = null, private val password: String? = null) :
    ZabbixApiMethod(apiUrl, auth) {
    @Throws(ZabbixApiException::class)
    fun get(requestEvent: RequestEvent): ResponseEvent {

        var resp = ResponseEvent()

        requestEvent.auth = auth
        requestEvent.method = "event.get"

        val requestJson = serialize(requestEvent)

        try {
            checkSession(login, password)
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                resp = deserialize(responseJson, resp) as ResponseEvent
                /*     val actualObj = mapper.readTree(responseJson)
                     val jsonNode1 = actualObj["result"]
                     val data = jsonNode1.toString()

                     resp.result = deserializeToList(data, ResponseEvent.Result()) as MutableList<ResponseEvent.Result>
     */
            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}