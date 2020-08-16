package History

import Api.ZabbixApiResponse
import java.util.*


class ResponseHistory() : ZabbixApiResponse() {
    var result: MutableList<ResponseHistory.Result> = ArrayList()

    class Result : HistoryObject() {

    }

}