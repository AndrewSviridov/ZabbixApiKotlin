package Event

import Api.ZabbixApiResponse
import java.util.*


class ResponseEvent() : ZabbixApiResponse() {
    var result: MutableList<Result> = ArrayList()

    class Result : EventObject() {

    }

}