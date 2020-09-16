package Api

import Event.Event
import Event.RequestEvent
import Event.ResponseEvent
import History.History
import History.RequestHistory
import History.ResponseHistory
import Host.Host
import Host.RequestHost
import Host.ResponseHost
import Item.Item
import Item.RequestItem
import Item.ResponseItem
import User.User
import org.slf4j.LoggerFactory
import problem.Problem
import problem.RequestProblem
import problem.ResponseProblem

class ZabbixApi(private var apiUrl: String, login: String, password: String) {

    private val LOGGER = LoggerFactory.getLogger(ZabbixApi::class.java)

    var user: User
    init {
        user = User(apiUrl, login, password)
        user.auth = user.login().result[0].sessionid
    }

    fun login(login: String, password: String): String? {
        var result: String? = null
        user.login = login
        user.password = password

        result = user.login().result[0].sessionid

        return result
    }

    fun logout(): Boolean? {
        var result: Boolean? = false
        user.auth?.let {
            result = user.logout()

        }
        return result
    }

    @Throws(ZabbixApiException::class)
    fun getHostIdsAndNames(): ArrayList<Pair<String, String>> {
        val requestHost = RequestHost()
        val resp: ResponseHost
        requestHost.params.output = arrayListOf("hostid", "name")
        try {
            resp = host().get(requestHost)
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        val result = ArrayList<Pair<String, String>>()
        for (t in resp.result) {
            if (t.name != null && t.hostid != null) {
                result.add(Pair(t.name, t.hostid) as Pair<String, String>)
            }
        }
        return result
    }

    @Throws(ZabbixApiException::class)
    fun getAllHosts(): MutableList<ResponseHost.Result> {
        val requestHost = RequestHost()
        val resp: ResponseHost
        try {
            resp = host().get(requestHost)
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        return resp.result
    }

    @Throws(ZabbixApiException::class)
    fun getProblems(): MutableList<ResponseProblem.Result> {
        val requestProblem = RequestProblem()
        val resp: ResponseProblem
        try {
            resp = problem().get(requestProblem)
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        return resp.result
    }


    @Throws(ZabbixApiException::class)
    fun getEventsForPeriod(hostid: String, time_from: Long, time_till: Long): MutableList<ResponseEvent.Result> {
        val requestEvent = RequestEvent()
        val resp: ResponseEvent
        requestEvent.params.time_from = time_from
        requestEvent.params.time_till = time_till
        requestEvent.params.hostids = arrayListOf(hostid)
        //  requestEvent.params.output= arrayListOf("name","acknowledged","clock","ns","severity","source")

        try {
            resp = event().get(requestEvent)
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp.result
    }

    @Throws(ZabbixApiException::class)
    fun getAllItem(hostid: String): MutableList<ResponseItem.Result> {
        val requestItem = RequestItem()
        val resp: ResponseItem
        requestItem.params.hostids = arrayListOf(hostid)
        //  requestItem.params.output= arrayListOf("itemid","name","lastclock","lastvalue","prevvalue")

        try {
            resp = item().get(requestItem)
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp.result
    }

    @Throws(ZabbixApiException::class)
    fun getHistoryItem(itemid: String, timeFrom: Long, timeTile: Long): MutableList<ResponseHistory.Result> {
        val requestHistory = RequestHistory()
        val resp: ResponseHistory
        requestHistory.params.itemids = arrayListOf(itemid)
        requestHistory.params.time_from = timeFrom
        requestHistory.params.time_till = timeTile

        try {
            resp = history().get(requestHistory)
        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }
        return resp.result

    }


    fun host(): Host {
        return Host(user)
    }

    fun item(): Item {
        return Item(user)
    }

    fun history(): History {
        return History(user)
    }

    fun event(): Event {
        return Event(user)
    }

    fun user(): User {
        return user
    }

    fun problem(): Problem {
        return Problem(user)
    }

}