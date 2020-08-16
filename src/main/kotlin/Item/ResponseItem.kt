package Item

import Api.ZabbixApiResponse
import java.util.*


class ResponseItem() : ZabbixApiResponse() {
    var result: MutableList<Result> = ArrayList()


    class Result : ItemObject() {
        var evaltype: Int? = null
        var discover: Int? = null

    }

}