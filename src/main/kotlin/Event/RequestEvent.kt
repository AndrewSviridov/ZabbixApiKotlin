package Event

import AnotherStaff.Tag
import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestEvent : ZabbixApiRequest() {
    val params = Params()

    class Params : GetRequestCommonParams() {
        var eventids: ArrayList<String>? = null
        var groupids: ArrayList<String>? = null
        var hostids: ArrayList<String?>? = null
        var objectids: ArrayList<String?>? = null
        var applicationids: ArrayList<String?>? = null
        var source: Int? = null
        var `object`: Int? = null
        var acknowledged: Boolean? = null
        var suppressed: Boolean? = null
        var severities: ArrayList<Int?>? = null
        var evaltype: Int? = null
        var tags: ArrayList<Tag>? = null
        var eventid_from: String? = null
        var eventid_till: String? = null
        var time_from: Long? = null
        var time_till: Long? = null
        var problem_time_from: Long? = null
        var problem_time_till: Long? = null
        var value: ArrayList<Int?>? = null
        var selectHosts: ArrayList<String?>? = null
        var selectRelatedObject: ArrayList<String?>? = null
        var select_alerts: ArrayList<String?>? = null
        var select_acknowledges: ArrayList<String?>? = null
        var selectTags: ArrayList<String?>? = null
        var selectSuppressionData: ArrayList<String?>? = null


    }
}