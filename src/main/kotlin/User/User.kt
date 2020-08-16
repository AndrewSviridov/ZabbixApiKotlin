/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Suguru Yajima
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package User

import Api.ZabbixApiException
import Api.ZabbixApiMethod

// todo проверить задумку код сессии в конструкторе
class User(apiUrl: String?, auth: String?) : ZabbixApiMethod(apiUrl, auth) {

    @Throws(ZabbixApiException::class)
    fun login(user: String, password: String, userData: Boolean): String? {

        val requestUser: RequestUser = RequestUser.Builder()
            .setMethod("user.login")
            .setUser(user)
            .setPassword(password)
            .setUserData(userData)
            .build()

        val requestJson = serialize(requestUser)

        var responseUser: String = ""
        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                responseUser = ResponseUser(it).getResultLoginWithoutUserData()
            }
            println()

        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        // todo сделать возвращение объекта objectUser +-
        return null
    }

    @Throws(ZabbixApiException::class)
    fun login(user: String, password: String): String? {
        val requestUser: RequestUser = RequestUser.Builder()
            .setMethod("user.login")
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

    fun logout(auth: String): Boolean? {
        val requestUser: RequestUser = RequestUser.Builder()
            .setMethod("user.logout")
            .setAuth(auth)
            .build()
        val requestJson = serialize(requestUser)

        var responseUser: Boolean? = null
        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                responseUser = ResponseUser(it).getResultLogout()
            }

        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        return responseUser
    }

    fun checkAuthentication(sessionid: String, extend: Boolean = true): ResponseUser.Result? {
        val requestUser: RequestUser

        if (extend) {
            requestUser = RequestUser.Builder()
                .setMethod("user.checkAuthentication")
                .setExtend(extend)
                .setSessionId(sessionid)
                .build()
            println("продлена сессия")
        } else {
            requestUser = RequestUser.Builder()
                .setMethod("user.checkAuthentication")
                .setExtend(extend)
                .setSessionId(sessionid)
                .build()
            println("проверка сессии")
        }

        val requestJson = serialize(requestUser)

        var responseUser: ResponseUser.Result? = null
        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                responseUser = ResponseUser(it).getResultcheckAuthentication()
            }

        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        return responseUser
    }

/*
    fun get(params: Map<String, Any>?): UserObject? {
        var method = "user.get"
        return null
    }


    fun create(params:Map<String,Object>?):Sting?{
        var method="user.create"
        return null
    }

    fun delete(params:Map<String,Object>?):Sting?{
        var method="user.delete"
        return null
    }


    fun update(params:Map<String,Object>?){
        var method="user.update"

    }
*/

}