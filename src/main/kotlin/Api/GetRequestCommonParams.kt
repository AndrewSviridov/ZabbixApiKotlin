package Api

import com.zabbix4j.utils.ZbxListUtils

/**
 * Created by Suguru Yajima on 2014/05/02.
 */
class GetRequestCommonParams {
    var countOutput: Boolean? = null
    var editable: Boolean? = null
    var excludeSearch: Boolean? = null
    private var limit: Int? = null
    var nodeids: List<Int>? = null
    var output = "extend"
    var preservekeys: Boolean? = null
    var search: String? = null
    var searchByAny: Boolean? = null
    var searchWildcardsEnabled: Boolean? = null
    var sortorder: List<SortOrder>? = null
    var startSearch: String? = null
    var limitSelects: Int? = null
    var sortfield: List<String>? = null
    var selectConditions: String? = null
    var selectOperations: String? = null

    fun setLimit(limit: Int?) {
        this.limit = limit
    }

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

    fun getLimit(): Int {
        return limit!!
    }

    fun setLimit(limit: Int) {
        this.limit = limit
    }

    fun isPreservekeys(): Boolean? {
        return preservekeys
    }

    fun isSearchByAny(): Boolean? {
        return searchByAny
    }

    fun isSearchWildcardsEnabled(): Boolean? {
        return searchWildcardsEnabled
    }

    fun setSortOrder(order: SortOrder) {
        sortorder = ZbxListUtils.add(sortorder, order)
    }

    inner class SortOrder private constructor() {
        var sortfield: String? = null
        private val order: String? = null

    }
}