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


class User(
    apiUrl: String?,
    auth: String? = null,
    private val login: String? = null,
    private val password: String? = null
) : ZabbixApiMethod(apiUrl, auth) {


    @Throws(ZabbixApiException::class)
    fun login(requestUser: RequestUser): ResponseUser {

        val resp = ResponseUser()

        requestUser.method = "user.login"

        val requestJson = serialize(requestUser)

        try {
            val responseJson = sendRequest(requestJson)
            responseJson?.let {
                val actualObj = mapper.readTree(responseJson)
                val jsonNode1 = actualObj["result"]
                val data = jsonNode1.asText().toString()
                if (requestUser.params.userData == null || requestUser.params.userData == false) {
                    val res = ResponseUser.Result()
                    res.sessionid = data
                    resp.result.add(res)
                } else {
                    resp.result.add(deserialize(data, ResponseUser.Result()) as ResponseUser.Result)
                }

            }
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp
    }

    fun logout(): Boolean {

        var resp: Boolean = false
        val requestUser = RequestUser()
        requestUser.auth = this.auth
        requestUser.method = "user.logout"

        val requestJson = serialize(requestUser)

        try {
            val responseJson = sendRequest(requestJson)
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

    fun checkAuthentication(requestUser: RequestUser): ResponseUser {

        val resp = ResponseUser()

        requestUser.method = "user.checkAuthentication"

        val requestJson = serialize(requestUser)

        try {
            val responseJson = sendRequest(requestJson)
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

}