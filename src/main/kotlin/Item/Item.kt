package Item

import Api.ZabbixApiException
import Api.ZabbixApiMethod
import User.User


class Item(var user: User) :
    ZabbixApiMethod() {

    @Throws(ZabbixApiException::class)
    fun get(requestItem: RequestItem): ResponseItem {

        var resp = ResponseItem()

        requestItem.method = "item.get"

        try {
            user.hold()
            requestItem.auth = user.auth
            val requestJson = serialize(requestItem)
            val responseJson = sendRequest(requestJson, user.url)
            responseJson?.let {

                resp = deserialize(responseJson, resp) as ResponseItem
            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}