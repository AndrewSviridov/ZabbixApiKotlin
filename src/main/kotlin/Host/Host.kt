package Host

import Api.ZabbixApiException
import Api.ZabbixApiMethod
import User.RequestUser
import User.ResponseUser

class Host(apiUrl: String?) : ZabbixApiMethod(apiUrl, null) {


    @Throws(ZabbixApiException::class)
    fun get(user: String, password: String): String? {
        val requestUser: RequestUser = RequestUser.Builder()
            .setMethod("host.get")
            .setUser(user)
            .setPassword(password)
            .build()

        val requestJson = serialize(requestUser)

        var responseUser: String = ""
        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                responseUser = ResponseUser(it).getResultLoginWithoutUserData()
            }

        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        return responseUser
    }

}