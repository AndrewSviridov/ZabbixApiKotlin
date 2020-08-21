package Event

import Api.ZabbixApiException
import Api.ZabbixApiMethod
import User.User


class Event(var user: User) :
    ZabbixApiMethod() {

    @Throws(ZabbixApiException::class)
    fun get(requestEvent: RequestEvent): ResponseEvent {

        var resp = ResponseEvent()

        requestEvent.method = "event.get"

        try {
            user.hold()
            requestEvent.auth = user.auth
            val requestJson = serialize(requestEvent)
            val responseJson = sendRequest(requestJson, user.url)
            responseJson?.let {
                resp = deserialize(responseJson, resp) as ResponseEvent

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}