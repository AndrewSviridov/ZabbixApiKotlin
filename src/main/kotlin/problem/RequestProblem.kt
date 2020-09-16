package problem

import AnotherStaff.Tag
import Api.GetRequestCommonParams
import Api.ZabbixApiRequest
import Api.ZbxListUtils
import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class RequestProblem : ZabbixApiRequest() {
    val params = Params()

    class Params : GetRequestCommonParams() {
        var eventids: ArrayList<String>? = null
        var groupids: ArrayList<String>? = null
        var hostids: ArrayList<String?>? = null
        var objectids: ArrayList<String?>? = null
        var applicationids: ArrayList<String?>? = null
        var source: Int? = null

        @JsonProperty("object")
        var objectType: Int? = null
        var acknowledged: Boolean? = null
        var suppressed: Boolean? = null
        var severities: ArrayList<Int?>? = null
        var evaltype: Int? = null
        var tags: ArrayList<Tag>? = null
        var recent: Boolean? = null
        var eventid_from: String? = null
        var eventid_till: String? = null
        var time_from: Long? = null
        var time_till: Long? = null
        var selectAcknowledges: ArrayList<String>? = null

        fun addSelectAcknowledges(item: String) {
            selectAcknowledges = ZbxListUtils.add(selectAcknowledges, item)
        }

        @JsonGetter("selectAcknowledges")
        fun anotherSelectAcknowledges(): Any? {
            selectAcknowledges?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectTags: ArrayList<String?>? = null

        fun addSelectTags(item: String) {
            selectTags = ZbxListUtils.add(selectTags, item)
        }

        @JsonGetter("selectTags")
        fun anotherGetSelectTags(): Any? {
            selectTags?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

        var selectSuppressionData: ArrayList<String?>? = null

        fun addSelectSuppressionData(item: String) {
            selectSuppressionData = ZbxListUtils.add(selectSuppressionData, item)
        }

        @JsonGetter("selectSuppressionData")
        fun anotherGetSelectSuppressionData(): Any? {
            selectSuppressionData?.let {
                if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                    return it[0]
                } else {
                    return it
                }
            } ?: return null
        }

    }
}