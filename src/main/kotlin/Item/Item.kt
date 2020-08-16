package Item

import Api.ZabbixApiException
import Api.ZabbixApiMethod


class Item(apiUrl: String?, auth: String?) : ZabbixApiMethod(apiUrl, auth) {
    @Throws(ZabbixApiException::class)
    fun get(requestItem: RequestItem): ResponseItem {

        val resp = ResponseItem()

        // todo переделать в метод setAuth?
        requestItem.auth = auth
        requestItem.method = "item.get"

        val requestJson = serialize(requestItem)

        //var response:MutableList<ResponseItem.Result>?=null
        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                val data = jsonNode1.toString()
                // todo может сделать как список и его брать всегда
                resp.result = deserializeToList(data, ResponseItem.Result()) as MutableList<ResponseItem.Result>
                // response as MutableList<ResponseItem.Result>
            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }
/*
    // todo может сделать как список и его брать всегда
    fun getResult(): MutableList<ResponseItem.Result> {
        val actualObj = mapper.readTree(responseItem)

        val jsonNode1 = actualObj["result"]
        val data = jsonNode1.toString()
        //val tr=Result()
        //val tht=serialize(tr)
        val result = deserializeToList(data, ResponseItem.Result())as  MutableList<ResponseItem.Result>
        result2=result as  MutableList<ResponseItem.Result>
        return result
    }
  */


}