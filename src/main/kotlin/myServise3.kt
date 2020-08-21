import Api.ZabbixApi
import Api.ZabbixApiMethod
import Event.RequestEvent
import History.RequestHistory
import Host.RequestHost
import Item.RequestItem
import com.google.gson.GsonBuilder
import java.text.DateFormat
import java.text.SimpleDateFormat


object myServise3 {

    val format: String = "y-M-d H:m:s"
    val formatter: DateFormat = SimpleDateFormat(format)

    //  val yy=formatter.parse("2020-08-5 00:00:00").time/1000
    //format timestamp
    //val sdf = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    val date1 = formatter.parse("2010-08-05 01:52:00")
    val date2 = formatter.parse("2020-08-08 00:01:05")


    //  val mapper = ObjectMapper().registerModule(KotlinModule())

    @JvmStatic
    fun main(args: Array<String>) {
        val properties = PropertiesClassK()
        // login to zabbix

        val zabbixApi = ZabbixApi(properties.url, properties.user, properties.password)
        // zabbixApi.checkAuthentication()
        val tt = zabbixApi.user.auth
        //   val test1 = zabbixApi.checkAuthentication()
        // val test2= zabbixApi.logout()

        val host = zabbixApi.host()
        val rer = zabbixApi.getAllHosts()
        val tt1 = zabbixApi.getHostIdsAndNames()
        val trt = zabbixApi.getAllItem("10084")
        val gg = zabbixApi.getHistoryItem("31414", (date1.time / 1000), (date2.time / 1000))
        val rre = zabbixApi.getEventsForPeriod("10084", (date1.time / 1000), (date2.time / 1000))

        //val requestHost= zabbixApi.getAuth()?.let { RequestHost() }
        val requestHost = RequestHost()
        requestHost.params.editable = true
        //  requestHost.params.output= arrayListOf("extend")
        //  requestHost.params.output = arrayListOf("extend")
        // requestHost.params.setHostids(listOf(10084))


        // val test = serialize(test("555"))
        // val result = mapper.canSerialize(RequestHost::class.java)


        //println(test2)
        //println(test)
        //val gson = Gson()

        // val js =gson.toJson(test("ttt"))

        val tet = ZabbixApiMethod()
        val getHosts = host.get(requestHost)
        val pr = zabbixApi.user.auth

        val gson = GsonBuilder().setPrettyPrinting().create() // pretty print

        val prettyJson = gson.toJson(tet.serialize(requestHost))
        println(prettyJson)
        println("//////////////////////////////")
        val prettyJson2 = gson.toJson(getHosts)
        println(prettyJson2)
        for (it in getHosts.result) {
            println("name " + it.name.toString() + " lastCheck " + it.discover + " lastvalue " + it.hostid)
        }
        val item = zabbixApi.item()

        val requestItem = RequestItem()
        //  requestItem.params.output = arrayListOf("extend")
        requestItem.params.addHostId("10084")
        val getItems = item.get(requestItem)
        println("name " + getItems.result[0].name.toString() + " lastCheck " + getItems.result[0].lastclock.toString() + " lastvalue " + getItems.result[0].lastvalue.toString())

        for (it in getItems.result) {
            println("name " + it.name.toString() + " lastCheck " + it.lastclock.toString() + " lastvalue " + it.lastvalue.toString())
        }
        println("name " + getItems.result[0].name.toString() + " lastCheck " + getItems.result[0].lastclock.toString() + " lastvalue " + getItems.result[0].lastvalue.toString())


        val history = zabbixApi.history()

        val requestHistory = RequestHistory()
        //   requestHistory.params.output = arrayListOf("extend")
        requestHistory.params.history = 3
        requestHistory.params.itemids = arrayListOf("31414")
        requestHistory.params.time_from = (date1.time / 1000)
        requestHistory.params.time_till = (date2.time / 1000)
        requestHistory.params.addSortField("clock")


        val getHistorys = history.get(requestHistory)
        for (it in getHistorys.result) {
            println("itemid " + it.itemid.toString() + " clock " + it.clock.toString() + " value " + it.value.toString() + " ns " + it.ns.toString())
        }


        val event = zabbixApi.event()

        val requestEvent = RequestEvent()
        //  requestEvent.params.output = arrayListOf("extend")
        requestEvent.params.time_from = (date1.time / 1000)
        requestEvent.params.time_till = (date2.time / 1000)
        //todo для всех методов где массивы сделат мметоды добавления по одному
        requestEvent.params.sortfield = arrayListOf("clock", "eventid")


        val getEvents = event.get(requestEvent)
        for (it in getEvents.result) {

            //   println(" "+it.)
            println("itemid " + it.name.toString() + " clock " + it.objectid.toString())
        }

        val prettyJson3 = gson.toJson(tet.serialize(requestEvent))
        println(prettyJson3)

        zabbixApi.logout()


    }
/*
    fun serialize(obj: Any): String {
        var result = ""
        try {
            result = mapper.writeValueAsString(obj)

        } catch (e: JsonGenerationException) {
            e.printStackTrace();
        } catch (e: JsonMappingException) {
            e.printStackTrace();
        }

        return result

    }

 */
}