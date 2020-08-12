package User

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*


open class UserObject {
    /**
     * Gets userid.
     *
     * @return Value of userid.
     */
    /**
     * Sets new userid.
     *
     * @param userid New value of userid.
     */
    @JsonProperty("userid")
    var userid: Int? = null
    /**
     * Gets alias.
     *
     * @return Value of alias.
     */
    /**
     * Sets new alias.
     *
     * @param alias New value of alias.
     */
    @JsonProperty("alias")
    var alias: String? = null
    /**
     * Gets attempt_clock.
     *
     * @return Value of attempt_clock.
     */
    /**
     * Sets new attempt_clock.
     *
     * @param attempt_clock New value of attempt_clock.
     */
    @JsonProperty("attempt_clock")
    var attempt_clock: Long? = null
    /**
     * Gets attempt_failed.
     *
     * @return Value of attempt_failed.
     */
    /**
     * Sets new attempt_failed.
     *
     * @param attempt_failed New value of attempt_failed.
     */
    @JsonProperty("attempt_failed")
    var attempt_failed: Int? = null
    /**
     * Gets autologin.
     *
     * @return Value of autologin.
     */
    /**
     * Sets new autologin.
     *
     * @param autologin New value of autologin.
     */
    @JsonProperty("autologin")
    var autologin: Int? = null
    /**
     * Gets autologout.
     *
     * @return Value of autologout.
     */
    /**
     * Sets new autologout.
     *
     * @param autologout New value of autologout.
     */
    @JsonProperty("autologout")
    var autologout: Int? = null
    /**
     * Gets lang.
     *
     * @return Value of lang.
     */
    /**
     * Sets new lang.
     *
     * @param lang New value of lang.
     */
    @JsonProperty("lang")
    var lang: String? = null
    /**
     * Gets name.
     *
     * @return Value of name.
     */
    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    @JsonProperty("name")
    var name: String? = null
    /**
     * Gets refresh.
     *
     * @return Value of refresh.
     */
    /**
     * Sets new refresh.
     *
     * @param refresh New value of refresh.
     */
    @JsonProperty("refresh")
    var refresh: String? = null
    /**
     * Gets rows_per_page.
     *
     * @return Value of rows_per_page.
     */
    /**
     * Sets new rows_per_page.
     *
     * @param rows_per_page New value of rows_per_page.
     */
    @JsonProperty("rows_per_page")
    var rows_per_page: Int? = null
    /**
     * Gets surname.
     *
     * @return Value of surname.
     */
    /**
     * Sets new surname.
     *
     * @param surname New value of surname.
     */
    @JsonProperty("surname")
    var surname: String? = null
    /**
     * Gets theme.
     *
     * @return Value of theme.
     */
    /**
     * Sets new theme.
     *
     * @param theme New value of theme.
     */
    @JsonProperty("theme")
    var theme: String? = null
    /**
     * Gets type.
     *
     * @return Value of type.
     */
    /**
     * Sets new type.
     *
     * @param type New value of type.
     */
    @JsonProperty("type")
    var type: Int? = null
    /**
     * Gets url.
     *
     * @return Value of url.
     */
    /**
     * Sets new url.
     *
     * @param url New value of url.
     */
    @JsonProperty("url")
    var url: String? = null

    @JsonProperty("attempt_ip")
    var attempt_ip: String? = null

    val attemptClock: Date?
        get() = if (attempt_clock != null && attempt_clock != 0L) {
            Date(attempt_clock!!)
        } else null

    enum class AUTO_LOGIN(var value: Int) {
        DISABLED(0), ENABLED(1);

    }

    enum class USER_TYPE(var value: Int) {
        ZABBIX_USER(1), ZABBIX_ADMIN(2), ZABBIX_SUPER_ADMIN(3);

    }
}