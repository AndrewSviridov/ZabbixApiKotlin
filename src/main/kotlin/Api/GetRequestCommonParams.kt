package Api

import com.fasterxml.jackson.annotation.JsonInclude
import com.zabbix4j.utils.ZbxListUtils

/*
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY, property = "type")

    @JsonSubTypes.Type(value = RequestHost.Params.class, name = "params")
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
open class GetRequestCommonParams() {
    //   @JsonProperty("countOutput")
    var countOutput: Boolean? = null

    //   @JsonProperty("editable")
    var editable: Boolean? = null

    //   @JsonProperty("excludeSearch")
    var excludeSearch: Boolean? = null

    // @JsonProperty("limit")
    //todo подумать че с методами делать
    var limit: Int? = null

    //  @JsonProperty("nodeids")
    var nodeids: List<Int>? = null

    //   @JsonProperty("output")
    var output = "extend"

    //  @JsonProperty("preservekeys")
    var preservekeys: Boolean? = null

    //  @JsonProperty("search")
    var search: String? = null

    //  @JsonProperty("searchByAny")
    var searchByAny: Boolean? = null

    //   @JsonProperty("searchWildcardsEnabled")
    var searchWildcardsEnabled: Boolean? = null

    //   @JsonProperty("sortorder")
    // var sortorder: List<SortOrder>? = null
    // @JsonProperty("startSearch")
    var startSearch: String? = null

    // @JsonProperty("limitSelects")
    var limitSelects: Int? = null

    //  @JsonProperty("sortfield")
    var sortfield: List<String>? = null

    //   @JsonProperty("selectConditions")
    var selectConditions: String? = null

    //  @JsonProperty("selectOperations")
    var selectOperations: String? = null

    //  @JsonSetter("limit")
    /*  fun setLimit(limit1: Int?) {
           this.limit1 = limit1
       }
   */
    fun addSortField(field: String) {
        sortfield = ZbxListUtils.add(sortfield, field)
    }

    fun setNodeId(id: Int) {
        nodeids = ZbxListUtils.add(nodeids, id)
    }

    fun setSortField(field: String) {
        sortfield = ZbxListUtils.add(sortfield, field)
    }

    fun isCountOutput(): Boolean? {
        return countOutput
    }

    fun isEditable(): Boolean? {
        return editable
    }

    fun isExcludeSearch(): Boolean? {
        return excludeSearch
    }
/*
    fun getLimit(): Int {
        return limit1!!
    }
*/


    fun isPreservekeys(): Boolean? {
        return preservekeys
    }

    fun isSearchByAny(): Boolean? {
        return searchByAny
    }

    fun isSearchWildcardsEnabled(): Boolean? {
        return searchWildcardsEnabled
    }
/*
    fun setSortOrder(order: SortOrder) {
        sortorder = ZbxListUtils.add(sortorder, order)
    }

     class SortOrder private constructor() {
        var sortfield: String? = null
        private val order: String? = null

    }
*/

}
