package History

import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.zabbix4j.utils.ZbxListUtils
import java.util.*

// todo сделать чтобы и поля с значениями по умолчанию не попадали, как например proxy_host
@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestHistory() : ZabbixApiRequest() {

    val params = Params()


    class Params : GetRequestCommonParams() {
        private var history: Int? = null
        private var hostids: List<Int>? = null
        private var itemids: List<Int>? = null
        private var time_from: Long? = null
        private var time_till: Long? = null


        fun addHostId(id: Int) {
            hostids = ZbxListUtils.add(hostids, id)
        }

        fun addItemId(id: Int) {
            itemids = ZbxListUtils.add(hostids, id)
        }

        // ещвщ переделать
        @JsonIgnore
        fun getTimeFromDate(): Date? {
            return if (time_from != null && time_from != 0L) {
                Date(time_from!!)
            } else null
        }

        fun getHistory(): Int? {
            return history
        }

        fun setHistory(history: Int) {
            this.history = history
        }

        fun getHostids(): List<Int>? {
            return hostids
        }

        fun setHostids(hostids: List<Int>?) {
            this.hostids = hostids
        }

        fun getItemids(): List<Int>? {
            return itemids
        }

        fun setItemids(itemids: List<Int>?) {
            this.itemids = itemids
        }

        fun getTime_from(): Long? {
            return time_from
        }

        fun setTime_from(time_from: Long?) {
            this.time_from = time_from
        }

        fun getTime_till(): Long? {
            return time_till
        }

        fun setTime_till(time_till: Long?) {
            this.time_till = time_till
        }

        // todo переделать
        @JsonIgnore
        fun getTimeTillDate(): Date? {
            return if (time_till != null && time_till != 0L) {
                Date(time_till!!)
            } else null
        }
    }
}