package Event

import AnotherStaff.Url

open class EventObject {
    val eventid: String? = null
    val source: Int? = null
    val `object`: Int? = null
    val objectid: String? = null
    val acknowledged: Int? = null
    private val clock: Long? = null
    private val ns: Int? = null
    val name: String? = null
    val value: Int? = null
    val severity: Int? = null
    val r_eventid: String? = null
    val c_eventid: String? = null
    val correlationid: String? = null
    val c_eveuseridntid: String? = null
    val suppressed: Int? = null
    val opdata: String? = null
    var urls: ArrayList<Url>? = null

    /*
    val clockDate: Date?
        get() = if (clock != null && clock != 0L) {
            Date(clock)
        } else null
*/
    enum class OBJECT_TYPE(var value: Int) {
        TRIGGER(0), DISCOVERED_HOST(1), DISCOVERED_SERVICE(2), AUTO_REGISTERED_HOST(3), ITEM(4), LLD_RULE(5);

    }

    enum class EVENT_SOURCE(var value: Int) {
        TRIGGER(0), DISCOVERY_RULE(1), AUTO_REGISTRATION(2), INTERNAL_EVENT(3);

    }


    enum class TRIGGER_EVENT(var value: Int) {
        OK(0), PROBLEM(1);

    }

    enum class DISCOVERY_EVENT(var value: Int) {
        SERVICE_UP(0), SERVICE_DOWN(1), SERVICE_DISCOVERED(2), SERVICE_LOST(3);

    }

    enum class INTERNAL_EVENT(var value: Int) {
        NORMAL_STATE(0), UNKNOWN_OR_NOT_SUPPORTED_STATE(1);

    }

    enum class SEVERITY(var value: Int) {
        NOT_CLASSIFIED(0), INFORMATION(1), WARNING(2), AVERAGE(3), HIGH(4), DISASTER(5);

    }
}