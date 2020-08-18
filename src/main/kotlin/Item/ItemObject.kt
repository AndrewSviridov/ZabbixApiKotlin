package Item


open class ItemObject {
    var itemid: Int? = null
    var delay: String? = null
    var hostid: String? = null
    var interfaceid: String? = null
    var key_: String? = null
    var name: String? = null
    var type: Int? = null // enum value/
    var url: String? = null
    var value_type: Int? = null
    var allow_traps: Int? = null
    var authtype: Int? = null
    var description: String? = null
    var error: String? = null
    var flags: Int? = null
    var follow_redirects: Int? = null


    var headers: ArrayList<Map<String, String>>? = null
    var history: String? = null
    var http_proxy: String? = null
    var inventory_link: String? = null
    var ipmi_sensor: String? = null
    var jmx_endpoint: String? = null
    var lastclock: Long? = null
    var lastns: Int? = null
    var lastvalue: String? = null
    var logtimefmt: String? = null
    var master_itemid: Int? = null
    var output_format: Int? = null
    var params: String? = null
    var password: String? = null
    var post_type: Int? = null
    var posts: String? = null
    var prevvalue: String? = null
    var privatekey: String? = null
    var publickey: String? = null


    var query_fields: ArrayList<Map<String, String>>? = null
    var request_method: Int? = null
    var retrieve_mode: Int? = null
    var snmp_oid: String? = null
    var ssl_cert_file: String? = null
    var ssl_key_file: String? = null
    var ssl_key_password: String? = null
    var state: Int? = null
    var status: Int? = null
    var status_codes: String? = null
    var templateid: String? = null
    var timeout: String? = null
    var trapper_hosts: String? = null
    var trends: String? = null
    var units: String? = null
    var username: String? = null
    var valuemapid: String? = null
    var verify_host: Int? = null
    var verify_peer: Int? = null


}