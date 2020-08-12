package User

import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

import java.util.*


@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "jsonrpc", "method","params" })
class RequestUser : ZabbixApiRequest() {
    @JsonIgnore
    val userObject = UserObject()


    @JsonProperty("params")
    private val params: HashMap<String, Any> = HashMap()

    class Builder {
        private val newRequestUser: RequestUser = RequestUser()
        fun setMethod(method: String): Builder {
            newRequestUser.method = method
            return this
        }


        fun setExtend(extend: Boolean): Builder {
            newRequestUser.params.put("extend", extend)
            return this
        }

        fun setAuth(auth: String): Builder {
            newRequestUser.auth = auth
            return this
        }

        fun setSessionId(sessionid: String): Builder {
            newRequestUser.params.put("sessionid", sessionid)
            return this
        }

        fun setPassword(password: String): Builder {
            newRequestUser.params.put("password", password)
            return this
        }

        fun setUser(user: String): Builder {
            newRequestUser.params.put("user", user)
            return this
        }

        fun setUserData(userData: Boolean): Builder {
            newRequestUser.params.put("userData", userData)
            return this
        }

        fun build(): RequestUser {
            return newRequestUser
        }

    }

}