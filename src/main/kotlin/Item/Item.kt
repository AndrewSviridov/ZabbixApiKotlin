package Item

import Api.ZabbixApiException
import Api.ZabbixApiMethod


class Item(apiUrl: String?, auth: String?, private val login: String? = null, private val password: String? = null) :
    ZabbixApiMethod(apiUrl, auth) {
    @Throws(ZabbixApiException::class)
    fun get(requestItem: RequestItem): ResponseItem {

        var resp = ResponseItem()

        requestItem.auth = auth
        requestItem.method = "item.get"

        val requestJson = serialize(requestItem)


        try {
            checkSession(login, password)
            val responseJson = sendRequest(requestJson)
            responseJson?.let {

                /*      val gson = Gson()
                      val test=gson.fromJson(responseJson,ResponseItem::class.java)
      */

                resp = deserialize(responseJson, resp) as ResponseItem

                /*        val actualObj = mapper.readTree(responseJson)
                        val jsonNode1 = actualObj["result"]
                        val data = jsonNode1.toString()
        */

// Deserialization

// Deserialization
                //val one = gson.fromJson(data,ResponseItem.Result())


                //   resp.result = deserializeToList(data, ResponseItem.Result()) as MutableList<ResponseItem.Result>

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}