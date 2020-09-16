package problem

import AnotherStaff.Url
import com.fasterxml.jackson.annotation.JsonProperty

open class ProblemObject {
    val eventid: String? = null
    val source: Int? = null

    @JsonProperty("object")
    val objectType: Int? = null
    val objectid: String? = null
    val clock: Long? = null
    val ns: Int? = null
    val r_eventid: String? = null
    val r_clock: Long? = null
    val r_ns: Int? = null
    val correlationid: String? = null
    var userid: String? = null
    val name: String? = null
    val acknowledged: Int? = null
    val severity: Int? = null
    val suppressed: Int? = null
    val opdata: String? = null
    var urls: ArrayList<Url>? = null

}