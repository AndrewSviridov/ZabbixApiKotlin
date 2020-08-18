package Api


import User.RequestUser
import User.ResponseUser
import User.User
import com.fasterxml.jackson.core.JsonGenerationException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.CollectionType
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.util.EntityUtils
import org.slf4j.LoggerFactory


open class ZabbixApiMethod(var apiUrl: String?, var auth: String?) {

    val mapper = ObjectMapper().registerModule(KotlinModule())
    //  .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    fun serialize(obj: Any): String {
        var result = ""
        try {
            result = mapper.writeValueAsString(obj)

        } catch (e: JsonGenerationException) {
            e.printStackTrace();
        } catch (e: JsonMappingException) {
            e.printStackTrace();
        }

        return result

    }

    fun checkSession(login: String?, password: String?): ResponseUser? {
        var resp: ResponseUser? = null
        try {

            val user = User(apiUrl, auth)
            val req = RequestUser()
            req.params.extend = true
            req.params.sessionid = auth
            resp = user.checkAuthentication(req)

            if (resp.result.isNullOrEmpty()) {

                val req = RequestUser()
                req.params.password = password
                req.params.user = login
                resp = user.login(req)
            }

        } catch (e: ZabbixApiException) {
            throw ZabbixApiException(e)
        }

        return resp
    }


    fun deserialize(json: String, obj: Any): Any? {
        var result: Any? = null
        try {
            result = mapper.readValue(json, obj::class.java)

        } catch (e: JsonGenerationException) {
            e.printStackTrace();
        } catch (e: JsonMappingException) {
            e.printStackTrace();
        }
        return result
    }


    fun deserializeToList(json: String, obj: Any): Any? {
        var asList: Any? = null
        try {
            val javaType: CollectionType = mapper.typeFactory
                .constructCollectionType(MutableList::class.java, obj::class.java)
            asList = mapper.readValue(json, javaType)


        } catch (e: JsonGenerationException) {
            e.printStackTrace();
        } catch (e: JsonMappingException) {
            e.printStackTrace();
        }

        return asList
    }


    // todo проверить, возможно переделать
    @Throws(ZabbixApiException::class)
    fun sendRequest(requestJson: String): String? {
        logger.debug("request json is \n$requestJson")


        // HTTP POST
        val httpResponse: HttpResponse
        val httpPost = HttpPost(apiUrl)
        var responseBody: String? = null
        try {
            httpPost.setHeader("Content-Type", "application/json-rpc")
            httpPost.entity = StringEntity(requestJson)
            val client = DefaultHttpClient()
            //HttpClient client = HttpClientBuilder.create().build();
            httpResponse = client.execute(httpPost)
            responseBody = EntityUtils.toString(httpResponse.getEntity())
        } catch (e: Exception) {
            throw ZabbixApiException("HTTP Request Error")
        }

        // HTTP status error
        if (httpResponse.getStatusLine().statusCode != HttpStatus.SC_OK) {
            throw ZabbixApiException("HTTP Error : $responseBody")
        }


        // response message to JSON Object
        val responseJson: JsonNode
        responseJson = try {
            mapper.readTree(responseBody)
        } catch (e: Exception) {
            throw ZabbixApiException(e.message)
        }

        // API error
        if (responseJson.has("error")) {
            var message: String
            message = try {
                "API Error : " + (responseJson["error"]).toString()
                // todo возможно другой эксепшен
            } catch (e: Exception) {
                throw ZabbixApiException(e.message)
            }
            message += "\nRequest:$requestJson"
            throw ZabbixApiException(message)
        }

        // todo сделать проверку из комментариев
        // check id
        //  val gson = Gson()
        /*val request: ZabbixApiRequest = gson.fromJson(requestJson, ZabbixApiRequest::class.java)
        val response: ZabbixApiResponse = gson.fromJson(responseBody, ZabbixApiResponse::class.java)
        if (request.id.equals(response.id) === false) {
            throw ZabbixApiException("id mismatch")
        }
        logger.debug("response json is \n$responseBody")
        */
        return responseBody
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ZabbixApiMethod::class.java)
    }

}