package Host

import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestHost : ZabbixApiRequest() {
    @JsonIgnore
    val HostObject = HostObject()


    @JsonProperty("params")
    private val params: HashMap<String, Any> = HashMap()

    class Builder {
        private val newRequestHost: RequestHost = RequestHost()
        fun setMethod(method: String): RequestHost.Builder {
            newRequestHost.method = method
            return this
        }


        fun setExtend(extend: Boolean): RequestHost.Builder {
            newRequestHost.params.put("extend", extend)
            return this
        }

        fun setAuth(auth: String): RequestHost.Builder {
            newRequestHost.auth = auth
            return this
        }

        fun setSessionId(sessionid: String): RequestHost.Builder {
            newRequestHost.params.put("sessionid", sessionid)
            return this
        }

        fun setPassword(password: String): RequestHost.Builder {
            newRequestHost.params.put("password", password)
            return this
        }

        fun setUser(user: String): RequestHost.Builder {
            newRequestHost.params.put("user", user)
            return this
        }

        fun setUserData(userData: Boolean): RequestHost.Builder {
            newRequestHost.params.put("userData", userData)
            return this
        }

        fun build(): RequestHost {
            return newRequestHost
        }
    }
}