import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import io.github.hengyunabc.zabbix.api.DefaultZabbixApi
import io.github.hengyunabc.zabbix.api.Request
import io.github.hengyunabc.zabbix.api.RequestBuilder
import java.sql.Timestamp
import java.text.DateFormat
import java.text.SimpleDateFormat

object ServiceCurentProblem {
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
        /*
        * http://192.168.1.13/zabbix/
sviridov
1q2w3e
        * */
        val login: Boolean = zabbixApi.login(properties.user, properties.password)
        println("login:$login")

        println("------------------- event.get -------------------------")
        println("------------------- " + Timestamp(date1.time) + " по " + Timestamp(date2.time) + " -------------------------")
        val arr = JSONArray()
        arr[0] = "clock"
        arr[1] = "eventid"
        val getRequestEvent: Request = RequestBuilder.newBuilder()
            .method("event.get")
            // .paramEntry("output", "extend")
            //     .paramEntry("time_from", (date1.time / 1000).toString())
            //   .paramEntry("time_till", (date2.time / 1000).toString())
            // .paramEntry("sortfield", arr)
            //.paramEntry("sortorder", "desc")
            .paramEntry("value", "1")
            .build()
        val getResponseEvent: JSONObject = zabbixApi.call(getRequestEvent)
        println(org.json.JSONObject(getRequestEvent.toString()).toString(2))
        println(org.json.JSONObject(getResponseEvent.toString()).toString(2))
    }
}