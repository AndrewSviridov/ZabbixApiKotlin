package Item

import Api.ZabbixApiException
import Api.ZabbixApiMethod


class Item(apiUrl: String?, auth: String?) : ZabbixApiMethod(apiUrl, auth) {
    @Throws(ZabbixApiException::class)
    fun get(requestItem: RequestItem): ResponseItem {

        val resp = ResponseItem()

        requestItem.auth = auth
        requestItem.method = "item.get"

        val requestJson = serialize(requestItem)


        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                val data = jsonNode1.toString()


// Deserialization

// Deserialization
                //val one = gson.fromJson(data,ResponseItem.Result())
                /*      val gson = Gson()
                      val test=gson.fromJson(data,ResponseItem.Result()::class.java)
      */
                resp.result = deserializeToList(data, ResponseItem.Result()) as MutableList<ResponseItem.Result>

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}