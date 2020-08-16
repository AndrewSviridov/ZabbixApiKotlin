package Item


open class ItemObject {
    var itemid: Int? = null
    var delay: String? = null
    var hostid: Int? = null
    var interfaceid: Int? = null
    var key_: String? = null
    var name: String? = null
    var type: Int? = null
    var value_type: Int? = null
    var authtype: Int? = null
    var data_type: Int? = null
    var delay_flex: String? = null
    var delta: Int? = null
    var description: String? = null
    var error: String? = null
    var flags: Int? = null
    var formula: Float? = null
    var history: String? = null
    var inventory_link: Int? = null
    var ipmi_sensor: String? = null
    var lastclock: Long? = null
    var lastns: Int? = null
    var lastvalue: String? = null
    var logtimefmt: String? = null
    /**
     * Gets mtime.
     *
     * @return Value of mtime.
     */
    /**
     * Sets new mtime.
     *
     * @param mtime New value of mtime.
     */
    var mtime: Long? = null
    var multiplier: Int? = null
    var params: String? = null
    var password: String? = null
    var port: String? = null
    var prevorgvalue: String? = null
    var prevvalue: String? = null
    var privatekey: String? = null
    var publickey: String? = null
    var snmp_community: String? = null
    var snmp_oid: String? = null
    var snmpv3_authpassphrase: String? = null
    var snmpv3_privpassphrase: String? = null
    var snmpv3_securitylevel: String? = null
    var snmpv3_securityname: String? = null
    var status: Int? = null
    var templateid: String? = null
    var trapper_hosts: String? = null

    // todo числа с d в конце, по документации числа, храню как строка
    var trends: String? = null
    var units: String? = null
    var username: String? = null
    var valuemapid: String? = null
    /**
     * Gets lifetime.
     *
     * @return Value of lifetime.
     */
    /**
     * Sets new lifetime.
     *
     * @param lifetime New value of lifetime.
     */
    //число с буквой
    var lifetime: String? = null

    var jmx_endpoint: String? = null
    var master_itemid: Int? = null
    var timeout: String? = null
    var url: String? = null

    // todo проверить
    var query_fields: ArrayList<Map<String, String>>? = null
    var posts: String? = null
    var status_codes: String? = null
    var follow_redirects: Int? = null
    var post_type: Int? = null
    var http_proxy: String? = null

    // todo проверить
    // var headers:ArrayList<object: test() {Map<Any,Any>}>?=null
    var retrieve_mode: Int? = null
    var request_method: Int? = null
    var output_format: Int? = null

    var ssl_cert_file: String? = null
    var ssl_key_file: String? = null
    var ssl_key_password: String? = null
    var verify_peer: Int? = null
    var allow_traps: Int? = null
    var verify_host: Int? = null
    var state: Int? = null

    class headersClass {
        val mapHeaders: Map<String, String>? = null
    }


}