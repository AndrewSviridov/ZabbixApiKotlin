package User

import com.fasterxml.jackson.annotation.JsonProperty


open class UserObject {

    @JsonProperty("userid")
    var userid: Int? = null
    @JsonProperty("alias")
    var alias: String? = null
    @JsonProperty("attempt_clock")
    var attempt_clock: Long? = null
    @JsonProperty("attempt_failed")
    var attempt_failed: Int? = null
    @JsonProperty("autologin")
    var autologin: Int? = null
    @JsonProperty("autologout")
    var autologout: Int? = null
    @JsonProperty("lang")
    var lang: String? = null
    @JsonProperty("name")
    var name: String? = null
    @JsonProperty("refresh")
    var refresh: String? = null
    @JsonProperty("rows_per_page")
    var rows_per_page: Int? = null
    @JsonProperty("surname")
    var surname: String? = null
    @JsonProperty("theme")
    var theme: String? = null
    @JsonProperty("type")
    var type: Int? = null
    @JsonProperty("url")
    var url: String? = null

    @JsonProperty("attempt_ip")
    var attempt_ip: String? = null

    enum class AUTO_LOGIN(var value: Int) {
        DISABLED(0), ENABLED(1);

    }

    enum class USER_TYPE(var value: Int) {
        ZABBIX_USER(1), ZABBIX_ADMIN(2), ZABBIX_SUPER_ADMIN(3);

    }
}