package Host

import Api.ZabbixApiException
import Api.ZabbixApiMethod


class Host(apiUrl: String?, auth: String?, private val login: String? = null, private val password: String? = null) :
    ZabbixApiMethod(apiUrl, auth) {

    @Throws(ZabbixApiException::class)
    fun get(requestHost: RequestHost): ResponseHost {

        var resp = ResponseHost()

        requestHost.auth = auth
        requestHost.method = "host.get"

        val requestJson = serialize(requestHost)


        try {
            checkSession(login, password)
            val responseJson = sendRequest(requestJson)
            responseJson?.let {

                //  var resp2=ResponseHost()
                resp = deserialize(responseJson, resp) as ResponseHost

                //   val gson = Gson()
                // val json = gson.toJson(responseBody)
                // val obj2 = gson.fromJson(responseJson, ResponseHost::class.java) as ResponseHost

                /*        val actualObj = mapper.readTree(responseJson)
                        val jsonNode1 = actualObj["result"]
                        val data = jsonNode1.toString()
        */
                //          val gson = Gson()
                //        val obj2: BagOfPrimitives = gson.fromJson(json, BagOfPrimitives::class.java)
                //   resp.result = deserializeToList(data, ResponseHost.Result()) as MutableList<ResponseHost.Result>
            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp

    }

}