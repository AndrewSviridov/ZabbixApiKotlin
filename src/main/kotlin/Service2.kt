import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import com.zabbix4j.ZabbixApi
import com.zabbix4j.ZabbixApiRequest
import com.zabbix4j.host.HostGetRequest
import java.util.*


object Service2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val properties = PropertiesClassK()


// login to zabbix

        val zabbixApi = ZabbixApi(properties.url)
        zabbixApi.login(properties.user, properties.password)

        val host = zabbixApi.host()


        val getRequest = HostGetRequest()

        val resp = host.get(getRequest)

        val result = resp.result

        for (h in result) {
            println(h.host.toString())
            //result.get(0).host.toString()
        }


        val tet = ZabbixApiRequest()
        tet.method = "user.logout"
        val testObj = JSONObject()
        testObj.set("jsonrpc", "2.0")
        testObj.set("method", "user.logout")
        testObj.set("method", JSONArray())
        testObj.set("id", Random().ints(6))

        val jsonObject = JSONObject()
        jsonObject.set("jsonrpc", "2.0")
        jsonObject.set("method", "user.checkAuthentication")
        jsonObject.set("params", JSONObject().set("sessionid", "8C8447FF6F61D134CEAC740CCA1BC90D"))
        jsonObject.set("id", Random().ints(6))

        // val zabbixMethod=ZabbixApiMethod(zabbixApi.)

        /*
              //testObj.set("id",Random().ints(6))
              println("logout")
              val getRequestLogOut: Request = RequestBuilder.newBuilder()
                  .method("user.logout")
                  .build()
              val getResponse2: JSONObject = zabbixApi.call(getRequestLogOut)
              println(getResponse2)
      */
        //println(result[0].toString())
        // val response: HostCreateResponse = zabbixApi.host().create(request)

        //val hostId = response.result.hostids[0]


    }
}