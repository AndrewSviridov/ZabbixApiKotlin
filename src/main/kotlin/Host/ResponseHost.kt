package Host

import Api.ZabbixApiResponse


class ResponseHost(val responseHost: String) : ZabbixApiResponse() {
    // val result: List<Result> = ArrayList()
// может сделать как список и его брать всегда
    fun getResult(): Any? {
        val actualObj = mapper.readTree(responseHost)

        val jsonNode1 = actualObj["result"]
        val data = jsonNode1.toString()
        //val tr=Result()
        //val tht=serialize(tr)
        val result = deserializeToList(data, Result()) //as ResponseHost.Result
        return result
    }

    class Result : HostObject() {
        var templateid: Int? = null
        var proxy_address: String? = null
        var auto_compress: Int? = null
        var discover: Int? = null


        /*  private List<HostgroupObject> groups;
           private List<ItemObject> items;


           private List<TriggerObject> triggers;
           private List<GraphObject> graphs;
           private List<ApplicationObject> applications;

           private List<Macro> macros;
           private List<HostInterfaceObject> interfaces;
           private List<DiscoveryRuleObject> discoveryRule;
           private List<HostObject> hostDiscovery;
   */
    }

}