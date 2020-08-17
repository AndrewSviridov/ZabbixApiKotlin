package Host

import Api.ZabbixApiResponse


class ResponseHost() : ZabbixApiResponse() {
    var result: MutableList<Result> = ArrayList()

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