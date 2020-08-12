import Api.ZabbixApi

object myServise3 {
    @JvmStatic
    fun main(args: Array<String>) {
        val properties = PropertiesClassK()
        // login to zabbix

        val zabbixApi = ZabbixApi(properties.url)
        zabbixApi.login(properties.user, properties.password)
        zabbixApi.checkAuthentication()
        zabbixApi.logout()


    }
}