package User

import Api.ZabbixApiResponse
import com.fasterxml.jackson.annotation.JsonProperty

class ResponseUser(val responseUser: String) : ZabbixApiResponse() {

    fun getResultLoginWithoutUserData(): String {
        val actualObj = mapper.readTree(responseUser)

        val jsonNode1 = actualObj["result"]
        return jsonNode1.textValue()

    }

    fun getResultcheckAuthentication(): Result {
        val actualObj = mapper.readTree(responseUser)

        val jsonNode1 = actualObj["result"]
        val user = jsonNode1.toString()
        //val tr=Result()
        //val tht=serialize(tr)
        val destest = deserialize(user, Result()) as Result
        return destest
    }

    fun getResultLogout(): Boolean? {
        val actualObj = mapper.readTree(responseUser)

        val jsonNode1 = actualObj["result"]

        return jsonNode1.asText().toBoolean()
    }

    /*
        fun getResultLoginWithUserData(){

        }

        // crete,update,delete
        val userids

        //login
        //if userData=true -> +  standard user properties
        val debug_mode
        val gui_access
        val sessionid
        val userip

        val result
    */
    class Result : UserObject() {
        @JsonProperty("sessionid")
        var sessionid: String? = null

        @JsonProperty("debug_mode")
        var debug_mode: Boolean? = null

        @JsonProperty("userip")
        var userip: String? = null

        @JsonProperty("gui_access")
        var gui_access: String? = null


    }

}