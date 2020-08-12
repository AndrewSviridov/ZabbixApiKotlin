package Api

import User.User

import org.slf4j.LoggerFactory

class ZabbixApi(private val apiUrl: String) {

    private val LOGGER = LoggerFactory.getLogger(ZabbixApi::class.java)

    private var auth: String? = null
    val user = User(apiUrl)

    @Throws(ZabbixApiException::class)
    fun login(username: String, password: String) {

        //todo добавить передачу параметра userData как надо
        auth = user.login(username, password)

    }

    fun checkAuthentication() {
        auth?.let {
            val result = user.checkAuthentication(it)
            // todo сделать адекватный ответ на действия
            LOGGER.info(result.toString())
        }
    }

    fun logout() {

        auth?.let {
            val result = user.logout(it)
            // todo сделать адекватный ответ на действия
            auth = null
            LOGGER.info(result.toString())
        }

    }

/*
    fun host(): Host {
        return Host(apiUrl, auth)
    }

    fun item(): Item {
        return Item(apiUrl, auth)
    }

    fun event(): Event {
        return Event(apiUrl, auth)
    }

    fun graph(): Graph {
        return Graph(apiUrl, auth)
    }

    fun graphItem(): GraphItem {
        return GraphItem(apiUrl, auth)
    }

    fun history(): History {
        return History(apiUrl, auth)
    }
*/
}