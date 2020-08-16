package History

/**
 * History objects differ depending on the item's type of information.
 * They are created by the Zabbix server and cannot be modified via the API.
 *
 *
 * Created by Suguru Yajima on 2014/06/03.
 */
open class HistoryObject {
    var clock: Long? = null
    var itemid: Int? = null
    var ns: Int? = null
    var value: String? = null

    /**
     * Use only Text Hisotry
     */
    var text: String? = null
    var id: Int? = null

    /**
     * Windows event log entry ID
     * Use Only Log Hisotry
     */
    var logeventid: Int? = null

    /**
     * Windows event log entry level.
     * Use Only Log Hisotry
     */
    var severity: Int? = null

    /**
     * Windows event log entry source.
     * Use Only Log Hisotry
     */
    var source: Int? = null

    /**
     * Windows event log entry time.
     * Use Only Log Hisotry
     */
    var timestamp: Long? = null

    /*
        val timestampDate: Date?
            get() = if (timestamp != null && timestamp != 0L) {
                Date(timestamp!!)
            } else null

        val clockDate: Date?
            get() = if (clock != null && clock != 0L) {
                Date(clock!!)
            } else null
    */
    enum class HISOTRY_OBJECT_TYPE(var value: Int) {
        FLOAT(0), STRING(1), LOG(2), INTEGER(3), TEXT(4);

    }
}