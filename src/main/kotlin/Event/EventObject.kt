package Event

import java.util.*

open class EventObject {
    private val eventid: Int? = null
    private val acknowledged: Int? = null
    private val clock: Long? = null
    private val ns: Int? = null
    private val `object`: Int? = null
    private val objectid: Int? = null
    private val source: Int? = null
    private val value: Int? = null
    private val value_changed: Int? = null
    val clockDate: Date?
        get() = if (clock != null && clock != 0L) {
            Date(clock)
        } else null

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
}