package Api

import Event.Event
import History.History
import Host.Host
import Item.Item
import User.User

import org.slf4j.LoggerFactory

class ZabbixApi() {

    private val LOGGER = LoggerFactory.getLogger(ZabbixApi::class.java)
    private var apiUrl: String? = null
    private var auth: String? = null

    var user: User? = null
    fun init(apiUrl: String, login: String, password: String) {
        this.apiUrl = apiUrl
        // todo подумать над 2 конструктором , который чисто пароль и логин принимает
        user = User(apiUrl, auth)
        this.auth = user?.login(login, password)
    }

    fun finish() {
        logout()
    }

    fun getAuth(): String? {
        return auth
    }

    @Throws(ZabbixApiException::class)
    fun login(username: String, password: String) {

        //todo добавить передачу параметра userData как надо
        auth = user?.login(username, password)

    }

    fun checkAuthentication() {
        auth?.let {
            val result = user?.checkAuthentication(it)
            // todo сделать адекватный ответ на действия
            LOGGER.info(result.toString())
        }
    }

    fun logout() {

        auth?.let {
            val result = user?.logout(it)
            // todo сделать адекватный ответ на действия
            auth = null
            LOGGER.info(result.toString())
        }

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