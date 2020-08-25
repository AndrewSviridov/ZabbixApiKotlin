import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import io.github.hengyunabc.zabbix.api.DefaultZabbixApi
import io.github.hengyunabc.zabbix.api.Request
import io.github.hengyunabc.zabbix.api.RequestBuilder
import java.sql.Timestamp
import java.text.DateFormat
import java.text.SimpleDateFormat


object Service {

    val format: String = "y-M-d H:m:s"
    val formatter: DateFormat = SimpleDateFormat(format)

    //  val yy=formatter.parse("2020-08-5 00:00:00").time/1000
    //format timestamp
    //val sdf = SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    val date1 = formatter.parse("2010-08-05 01:52:00")
    val date2 = formatter.parse("2020-08-08 00:01:05")

    @JvmStatic
    fun main(args: Array<String>) {
        val properties = PropertiesClassK()

        val zabbixApi = DefaultZabbixApi(properties.url)
        zabbixApi.init()
/*
        println("logout")
        val getRequestLogOut2: Request = RequestBuilder.newBuilder()
            .method("user.logout")
            .build()
        val getResponse22: JSONObject = zabbixApi.call(getRequestLogOut2)
        println(getResponse22)
*/
        val login: Boolean = zabbixApi.login(properties.user, properties.password)
        println("login:$login")

        val arr2 = JSONArray()
        arr2[0] = "10084"
        //arr2[1] = "10333"
        val arrFields = JSONArray()
        arrFields[0] = "extend"
        println("------------------- host.get -------------------------")
        val getRequestHost: Request = RequestBuilder.newBuilder()
            .method("host.get")//.paramEntry("output", "extend")
            .paramEntry("selectGraphs", "count")
            // .paramEntry("selectHttpTests","extend")
            //.paramEntry("hostids",arr2)
            .build()
        val getResponseHost: JSONObject = zabbixApi.call(getRequestHost)
        println(org.json.JSONObject(getRequestHost.toString()).toString(2))
        println(org.json.JSONObject(getResponseHost.toString()).toString(2))

/*
        val host = "Zabbix server"
        val filter = JSONObject()


        filter.put("host", arrayOf(host))
        val getRequest: Request = RequestBuilder.newBuilder()
            .method("host.get").paramEntry("filter", filter)
            .build()
        val getResponse: JSONObject = zabbixApi.call(getRequest)
        println(getResponse)
        val hostid: String = getResponse.getJSONArray("result")
            .getJSONObject(0).getString("hostid")
        println(hostid)
*/
        println("------------------- graph.get -------------------------")
        val getRequestGraph: Request = RequestBuilder.newBuilder()
            .method("graph.get").paramEntry("output", "extend").paramEntry("hostids", "10084")
            //.paramEntry("graphids","1247")
            .build()
        val getResponseGraph: JSONObject = zabbixApi.call(getRequestGraph)
        println(org.json.JSONObject(getRequestGraph.toString()).toString(2))
        println(org.json.JSONObject(getResponseGraph.toString()).toString(2))

        println("------------------- graphitem.get -------------------------")
        val getRequestGraphItem: Request = RequestBuilder.newBuilder()
            .method("graphitem.get").paramEntry("output", "extend").paramEntry("graphids", "1247")
            .paramEntry("selectGraphs", "count")
            .build()
        val getResponseGraphItem: JSONObject = zabbixApi.call(getRequestGraphItem)
        println(org.json.JSONObject(getRequestGraphItem.toString()).toString(2))
        println(org.json.JSONObject(getResponseGraphItem.toString()).toString(2))

//item.get

        println("------------------- item.get -------------------------")
        val getRequestItem: Request = RequestBuilder.newBuilder()
            .method("item.get").paramEntry("output", "extend")
            .paramEntry("hostids", "10084")
            //.paramEntry("itemids", "31398")
            //.paramEntry("selectGraphs","extend")
            .build()
        val getResponseItem: JSONObject = zabbixApi.call(getRequestItem)
        println(org.json.JSONObject(getRequestItem.toString()).toString(2))
        println(org.json.JSONObject(getResponseItem.toString()).toString(2))

        println("------------------- history.get Item 31398 Graph 1247-------------------------")
        val getRequestItemGraphHistory: Request = RequestBuilder.newBuilder()
            .method("history.get")
            .paramEntry("output", "extend")
            .paramEntry("history", 0)
            .paramEntry("itemids", "31398") // id item
            .paramEntry("time_from", (date1.time / 1000).toString())
            .paramEntry("time_till", (date2.time / 1000).toString())
            .paramEntry("sortfield", "clock")
            .paramEntry("sortorder", "DESC")
            .build()
        val getResponseItemGraphHistory: JSONObject = zabbixApi.call(getRequestItemGraphHistory)
        println(org.json.JSONObject(getRequestItemGraphHistory.toString()).toString(2))
        println(org.json.JSONObject(getResponseItemGraphHistory.toString()).toString(2))


        //method 1

        //   val timestamp = Timestamp(System.currentTimeMillis())
        // println(timestamp)
        //method 2 - via Date
        //val date = Date()
        //println(Timestamp(date.getTime()))

        //return number of milliseconds since January 1, 1970, 00:00:00 GMT
        //println(timestamp.time)

        //  val date1 = MessageK.formatter.parse(message.sheduleDeliveryTime)

        //     val timestamp1 = Timestamp(date1.time)

        //   val ts3 = System.currentTimeMillis()/1000


        //    val dateFormat = SimpleDateFormat("YYYY-MM-dd HH:mm:ss")
        //  val ts = dateFormat.parse("2020-08-5 00:00:00").time/1000
        //format timestamp
        // val date = Date()
        println(Timestamp(date1.time))
        println(Timestamp(date2.time))

        //println(Timestamp(1596427974))

        println(date1.time / 1000)
        println(date2.time / 1000)

        //println(sdf.format(timestamp))

        println("------------------- event.get -------------------------")
        println("------------------- " + Timestamp(date1.time) + " по " + Timestamp(date2.time) + " -------------------------")
        val arr = JSONArray()
        arr[0] = "clock"
        arr[1] = "eventid"
        val getRequestEvent: Request = RequestBuilder.newBuilder()
            .method("event.get")
            .paramEntry("output", "extend")
            //     .paramEntry("time_from", (date1.time / 1000).toString())
            //   .paramEntry("time_till", (date2.time / 1000).toString())
            // .paramEntry("sortfield", arr)
            //.paramEntry("sortorder", "desc")
            .build()
        val getResponseEvent: JSONObject = zabbixApi.call(getRequestEvent)
        println(org.json.JSONObject(getRequestEvent.toString()).toString(2))
        println(org.json.JSONObject(getResponseEvent.toString()).toString(2))

        println("------------------- history.get -------------------------")
        val arr3 = JSONArray()
        arr[0] = "clock"
        arr[1] = "value"
        val getRequestItemHistory: Request = RequestBuilder.newBuilder()
            .method("history.get")
            .paramEntry("output", "extend")
            .paramEntry("history", 3)
            .paramEntry("itemids", "31414") // id item
            .paramEntry("time_from", (date1.time / 1000).toString())
            .paramEntry("time_till", (date2.time / 1000).toString())
            .paramEntry("sortfield", "clock")
            .paramEntry("sortorder", "DESC")
            .build()
        val getResponseItemHistory: JSONObject = zabbixApi.call(getRequestItemHistory)
        println(org.json.JSONObject(getRequestItemHistory.toString()).toString(2))
        println(org.json.JSONObject(getResponseItemHistory.toString()).toString(2))


        // fraph id 1247 вроде

        println("------------------- event.get /events triggered by a trigger/ -------------------------")
        val getRequestEventFromTrigger: Request = RequestBuilder.newBuilder()
            .method("event.get")
            .paramEntry("output", "extend")
            .paramEntry("selectTags", "extend")
            .paramEntry("select_acknowledges", "extend")
            .paramEntry("selectSuppressionData", "extend")
            .paramEntry("objectids", "17028") // id trigger
            .paramEntry("sortfield", arr)
            .paramEntry("sortorder", "desc")
            .build()
        val getResponseEventFromTrigger: JSONObject = zabbixApi.call(getRequestEventFromTrigger)
        println(org.json.JSONObject(getRequestEventFromTrigger.toString()).toString(2))
        println(org.json.JSONObject(getResponseEventFromTrigger.toString()).toString(2))


        //println(getResponse)
        /* val interfaceid: String = getResponse.getJSONArray("result")
             .getJSONObject(0).getString("interfaceid")
         println(interfaceid)
 */
/*
        val param= JSONArray()
        param.set(0,1344)
        val getRequest3: Request = RequestBuilder.newBuilder()
            .method("item.create")
            .paramEntry("name", "Free disk space on \$1")
            .paramEntry("key_","vfs.fs.size[/home/joe/,free]")
            .paramEntry("hostid","10084")
            .paramEntry("type",0)
            .paramEntry("value_type",3)
            .paramEntry("interfaceid",interfaceid)
            .paramEntry("applications",param)
            .paramEntry("delay",30)
            .build()

        val getResponse3: JSONObject = zabbixApi.call(getRequest3)
        println(getResponse3)
*/
        println("logout")
        val getRequestLogOut: Request = RequestBuilder.newBuilder()
            .method("user.logout")
            .build()
        val getResponse2: JSONObject = zabbixApi.call(getRequestLogOut)
        println(getResponse2)

    }
}