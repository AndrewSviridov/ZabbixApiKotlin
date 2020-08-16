package Event

import Api.ZabbixApiException
import Api.ZabbixApiMethod

class Event(apiUrl: String?, auth: String?) : ZabbixApiMethod(apiUrl, auth) {
    @Throws(ZabbixApiException::class)
    fun get(requestEvent: RequestEvent): ResponseEvent {

        val resp = ResponseEvent()
        // todo переделать в метод setAuth?
        requestEvent.auth = auth
        requestEvent.method = "event.get"

        val requestJson = serialize(requestEvent)

        // var response:Any?=null
        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                val data = jsonNode1.toString()
                // todo может сделать как список и его брать всегда
                resp.result = deserializeToList(data, ResponseEvent.Result()) as MutableList<ResponseEvent.Result>
                //   response = ResponseEvent(it).getResult()
            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}