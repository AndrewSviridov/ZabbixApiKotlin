import Api.ZabbixApi
import Event.RequestEvent
import org.junit.Test

class testGetProblem {
    @Test
    fun test1() {
        //local

        // login to zabbix

        val zabbixApi = ZabbixApi("http://192.168.1.13/zabbix/api_jsonrpc.php", "sviridov", "1q2w3e")
        val resp = zabbixApi.getProblems()
/*
        val requestProblem = RequestProblem()
        requestProblem.params.output= arrayListOf("eventid")
        val respProblem = zabbixApi.problem().get(requestProblem)
        respProblem.result[0].eventid

 */
        // нужно получить eventid нужной проблемы, например 172
        if (resp.size != 0) {

            val event = zabbixApi.event()

            val requestEvent = RequestEvent()
            requestEvent.params.eventids = arrayListOf(resp[0].eventid!!)
            requestEvent.params.selectHosts = arrayListOf("extend")
            requestEvent.params.value = arrayListOf(1)
            //requestEvent.params.output = arrayListOf("hosts")
            //  requestEvent.params.eventids = resp.


            val getEvents = event.get(requestEvent)
            for (it in getEvents.result[0].hosts!!) {

                println(" " + it.toString())
                //println("itemid " + it.name.toString() + " clock " + it.objectid.toString())
            }

            val resp2 = zabbixApi.getProblemHosts(resp[0].eventid!!)
            println()
        }
    }

    @Test
    fun test2() {
        //work
        val zabbixApi = ZabbixApi("http://192.168.1.13/zabbix/api_jsonrpc.php", "sviridov", "1q2w3e")

    }

}