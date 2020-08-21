package Api



import com.fasterxml.jackson.core.JsonGenerationException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.http.HttpResponse
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.util.EntityUtils
import org.slf4j.LoggerFactory


open class ZabbixApiMethod {

    companion object {
        private val logger = LoggerFactory.getLogger(ZabbixApiMethod::class.java)
    }

    val mapper = jacksonObjectMapper()

    fun serialize(obj: Any): String {
        var result = ""
        try {
            result = mapper.writeValueAsString(obj)

        } catch (e: JsonGenerationException) {
            e.printStackTrace()
        } catch (e: JsonMappingException) {
            e.printStackTrace()
        }

        return result

    }

    fun deserialize(json: String, obj: Any): Any? {
        var result: Any? = null
        try {
            result = mapper.readValue(json, obj::class.java)

        } catch (e: JsonGenerationException) {
            e.printStackTrace()
        } catch (e: JsonMappingException) {
            e.printStackTrace()
        }
        return result
    }


    @Throws(ZabbixApiException::class)
    fun sendRequest(requestJson: String, url: String): String? {
        logger.debug("request json is \n$requestJson")

        // HTTP POST
        val httpResponse: HttpResponse
        val httpPost = HttpPost(url)
        var responseBody: String? = null
        try {
            httpPost.setHeader("Content-Type", "application/json-rpc")
            httpPost.entity = StringEntity(requestJson)
            val client = DefaultHttpClient()

            httpResponse = client.execute(httpPost)
            responseBody = EntityUtils.toString(httpResponse.entity)
        } catch (e: Exception) {
            throw ZabbixApiException("HTTP Request Error")
        }

        // HTTP status error
        if (httpResponse.statusLine.statusCode != HttpStatus.SC_OK) {
            throw ZabbixApiException("HTTP Error : $responseBody")
        }


        // response message to JSON Object
        val responseJsonNode: JsonNode
        responseJsonNode = try {
            mapper.readTree(responseBody)
        } catch (e: Exception) {
            throw ZabbixApiException(e.message)
        }

        val requestJsonNode: JsonNode
        requestJsonNode = try {
            mapper.readTree(requestJson)
        } catch (e: Exception) {
            throw ZabbixApiException(e.message)
        }

        // API error
        if (responseJsonNode.has("error")) {
            var message: String
            message = try {

                "API Error : " + (responseJsonNode["error"]).toString()

            } catch (e: Exception) {
                throw ZabbixApiException(e.message)
            }
            message += "\nRequest:$requestJson"
            val mesg = responseJsonNode["error"]["data"].toString()
            if (mesg.contains("re-login")) {
                throw ZabbixApiExceptionReLogin(message)
            }

            throw ZabbixApiException(message)
        }


        if (responseJsonNode.has("id") && requestJsonNode.has("id")) {

            if (!responseJsonNode["id"].isInt.equals(requestJsonNode["id"].isInt)) {
                throw ZabbixApiException("id mismatch")
            }
        }
        logger.debug("response json is \n$responseBody")

        return responseBody
    }

}