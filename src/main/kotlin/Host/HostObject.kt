package Host


open class HostObject {
    var hostid: Int? = null
    var host: String? = null
    var available: Int? = null
    var description: String? = null
    var disable_until: Long? = null
    var error: String? = null
    var errors_from: Long? = null
    var flags: Int? = null
    var inventory_mode: Int? = null
    var ipmi_authtype: Int? = null
    var ipmi_available: Int? = null
    var ipmi_disable_until: Long? = null
    var ipmi_error: String? = null
    var ipmi_errors_from: Long? = null
    var ipmi_password: String? = null
    var ipmi_privilege: Int? = null
    var ipmi_username: String? = null
    var jmx_available: Int? = null
    var jmx_disable_until: Long? = null
    var jmx_error: String? = null
    var jmx_errors_from: Long? = null
    var maintenance_from: Long? = null
    var maintenance_status: Int? = null
    var maintenance_type: Int? = null
    var maintenanceid: String? = null
    var name: String? = null
    var proxy_hostid: String? = null
    var snmp_available: String? = null
    var snmp_disable_until: Long? = null
    var snmp_error: String? = null
    var snmp_errors_from: Long? = null
    var status: Int? = null
    var tls_connect: Int? = null
    var tls_accept: Int? = null
    var tls_issuer: String? = null
    var tls_subject: String? = null
    var tls_psk_identity: String? = null
    var tls_psk: String? = null

}