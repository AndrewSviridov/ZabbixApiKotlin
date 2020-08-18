package History


open class HistoryObject {
    var clock: Long? = null
    var itemid: Int? = null
    var ns: Int? = null
    var value: String? = null

    /**
     * Use only Text Hisotry
     */
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
    var source: String? = null

    /**
     * Windows event log entry time.
     * Use Only Log Hisotry
     */
    var timestamp: Long? = null

    enum class HISOTRY_OBJECT_TYPE(var value: Int) {
        FLOAT(0), STRING(1), LOG(2), INTEGER(3), TEXT(4);
    }
}