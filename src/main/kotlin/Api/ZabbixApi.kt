package Api

import Event.Event
import History.History
import Host.Host
import Item.Item
import User.RequestUser
import User.ResponseUser
import User.User

import org.slf4j.LoggerFactory

class ZabbixApi() {

    private val LOGGER = LoggerFactory.getLogger(ZabbixApi::class.java)
    var apiUrl: String? = null
    var auth: String? = null

    var user: User? = null
    fun init(apiUrl: String, login: String, password: String) {
        this.apiUrl = apiUrl

        user = User(apiUrl)
        val requestUser = RequestUser()
        var responseUser: ResponseUser? = null
        requestUser.params.user = login
        requestUser.params.password = password
        requestUser.params.userData = null
        responseUser = user?.login(requestUser)
        this.auth = responseUser?.result?.first()?.sessionid
        user?.auth = this.auth
        println()
    }


    fun checkAuthentication(): ResponseUser? {
        var result: ResponseUser? = null
        auth?.let {
            val requestUser = RequestUser()
            requestUser.params.sessionid = auth
            result = user?.checkAuthentication(requestUser)
        }
        return result
    }

    fun close(): Boolean? {
        var result: Boolean? = false
        auth?.let {
            result = user?.logout()

            auth = null
            user = null
        }
        return result
    }


    fun host(): Host {
        return Host(apiUrl, auth)
    }

    fun item(): Item {
        return Item(apiUrl, auth)
    }

    fun history(): History {
        return History(apiUrl, auth)
    }

    fun event(): Event {
        return Event(apiUrl, auth)
    }

}