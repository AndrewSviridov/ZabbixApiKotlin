package Event

import AnotherStaff.Tag
import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestEvent : ZabbixApiRequest() {
    val params = Params()

    class Params : GetRequestCommonParams() {
        var eventids: List<String>? = null
        var groupids: List<String>? = null
        var hostids: List<String?>? = null
        var objectids: List<String?>? = null
        var applicationids: List<String?>? = null
        var source: Int? = null
        var `object`: Int? = null
        var acknowledged: Boolean? = null
        var suppressed: Boolean? = null
        var severities: List<Int?>? = null
        var evaltype: Int? = null
        var tags: ArrayList<Tag>? = null
        var eventid_from: String? = null
        var eventid_till: String? = null
        var time_from: Long? = null
        var time_till: Long? = null
        var problem_time_from: Long? = null
        var problem_time_till: Long? = null
        var value: List<Int?>? = null
        var selectHosts: List<String?>? = null
        var selectRelatedObject: List<String?>? = null
        var select_alerts: List<String?>? = null
        var select_acknowledges: List<String?>? = null
        var selectTags: List<String?>? = null
        var selectSuppressionData: List<String?>? = null


    }
}