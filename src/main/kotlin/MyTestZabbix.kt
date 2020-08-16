import com.alibaba.fastjson.JSONObject
import io.github.hengyunabc.zabbix.api.DefaultZabbixApi
import io.github.hengyunabc.zabbix.api.Request
import io.github.hengyunabc.zabbix.api.RequestBuilder

object MyTestZabbix {
    @JvmStatic
    fun main(args: Array<String>) {
        val properties = PropertiesClassK()

        val zabbixApi = DefaultZabbixApi("http://192.168.99.100:80/api_jsonrpc.php")
        zabbixApi.init()

        val login: Boolean = zabbixApi.login("admin", "zabbix")
        println("login:$login")


        println("------------------- item.get -------------------------")
        val getRequestItem: Request = RequestBuilder.newBuilder()
            .method("item.get").paramEntry("output", "extend")
            //.paramEntry("hostids","10084")
            //.paramEntry("itemids", "31398")
            //.paramEntry("selectGraphs","extend")
            .build()
        val getResponseItem: JSONObject = zabbixApi.call(getRequestItem)
        println(org.json.JSONObject(getRequestItem.toString()).toString(2));
        println(org.json.JSONObject(getResponseItem.toString()).toString(2));


        println("logout")
        val getRequestLogOut: Request = RequestBuilder.newBuilder()
            .method("user.logout")
            .build()
        val getResponse2: JSONObject = zabbixApi.call(getRequestLogOut)
        println(getResponse2)

    }
}