package Api

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_NULL)
open class GetRequestCommonParams {
    var countOutput: Boolean? = null

    var editable: Boolean? = null

    var excludeSearch: Boolean? = null

    var filter: ArrayList<Pair<String, ArrayList<String>>>? = null

    var limit: Int? = null

    var output: ArrayList<String>? = null

    @JsonGetter("output")
    fun anotherGetOutput(): Any? {
        output?.let {
            if (it.size == 1 && (it[0] == "extend" || it[0] == "count")) {

                return it[0]
            } else {
                return it
            }
        } ?: return null
    }


    var preservekeys: Boolean? = null

    var search: ArrayList<Pair<String, String>>? = null

    var searchByAny: Boolean? = null

    var searchWildcardsEnabled: Boolean? = null

    var sortfield: ArrayList<String>? = null

    var sortorder: ArrayList<String>? = null

    var startSearch: Boolean? = null


    fun addFilterField(field: Pair<String, ArrayList<String>>) {
        filter = ZbxListUtils.add(filter, field)
    }

    fun addSearchField(field: Pair<String, String>) {
        search = ZbxListUtils.add(search, field)
    }

    fun addOutputField(field: String) {
        output = ZbxListUtils.add(output, field)
    }

    fun addSortField(field: String) {
        sortfield = ZbxListUtils.add(sortfield, field)
    }


    fun addSortOrder(order: String) {
        sortorder = ZbxListUtils.add(sortorder, order)
    }


}


