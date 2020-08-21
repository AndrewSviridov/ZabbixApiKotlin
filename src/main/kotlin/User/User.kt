
package User

import Api.ZabbixApiException
import Api.ZabbixApiExceptionReLogin
import Api.ZabbixApiMethod


class User(
    var url: String,
    var login: String,
    var password: String,
    var auth: String? = null
) : ZabbixApiMethod() {
    companion object {
        private val reqLogin = RequestUser()
        private val reqCheck = RequestUser()
    }

    init {
        reqLogin.params.password = password
        reqLogin.params.user = login
        reqLogin.params.userData = false

        reqCheck.params.extend = true
    }

    @Throws(ZabbixApiException::class)
    fun login(requestUser: RequestUser = reqLogin): ResponseUser {

        var resp = ResponseUser()

        requestUser.method = "user.login"

        val requestJson = serialize(requestUser)

        try {
            val responseJson = sendRequest(requestJson, url)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                val data = jsonNode1.asText().toString()
                if (requestUser.params.userData == null || requestUser.params.userData == false) {
                    val res = ResponseUser.Result()
                    res.sessionid = data
                    resp.result.add(res)
                } else {
                    resp = deserialize(responseJson, resp) as ResponseUser
                }

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp
    }

    @Throws(ZabbixApiException::class)
    fun logout(): Boolean {

        var resp = false
        val requestUser = RequestUser()

        requestUser.method = "user.logout"



        try {
            hold()
            requestUser.auth = this.auth
            val requestJson = serialize(requestUser)
            val responseJson = sendRequest(requestJson, url)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                resp = jsonNode1.asBoolean()

                auth = null
            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        return resp
    }

    @Throws(ZabbixApiException::class)
    fun checkAuthentication(requestUser: RequestUser): ResponseUser {

        var resp = ResponseUser()

        requestUser.method = "user.checkAuthentication"

        val requestJson = serialize(requestUser)

        try {
            val responseJson = sendRequest(requestJson, url)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                val data = jsonNode1.toString()

                resp.result.add(deserialize(data, ResponseUser.Result()) as ResponseUser.Result)
            }

        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        return resp
    }

    fun hold() {
        try {

            reqCheck.params.sessionid = auth ?: ""
            auth = checkAuthentication(reqCheck).result[0].sessionid
        } catch (e: ZabbixApiExceptionReLogin) {

            auth = login().result[0].sessionid

        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
    }

}