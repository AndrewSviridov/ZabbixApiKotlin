package WebScenario

import AnotherStaff.HTTPField


open class WebScenarioObject {
    val httptestid: String? = null
    val hostid: String? = null
    val name: String? = null
    val agent: String? = null

    var applicationid: String? = null

    val authentication: Int? = null
    val delay: String? = null
    val headers: ArrayList<HTTPField>? = null
    val http_password: String? = null
    val http_proxy: String? = null
    val http_user: String? = null
    val nextcheck: Long? = null
    val retries: Int? = null

    val ssl_cert_file: String? = null
    val ssl_key_file: String? = null
    val ssl_key_password: String? = null

    val status: Int? = null
    val templateid: String? = null
    val variables: ArrayList<HTTPField>? = null

    val verify_host: Int? = null
    val verify_peer: Int? = null
}