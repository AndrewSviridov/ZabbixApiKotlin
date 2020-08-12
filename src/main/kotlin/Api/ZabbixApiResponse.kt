package Api

import com.fasterxml.jackson.core.JsonGenerationException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper


open class ZabbixApiResponse {
    var id = 0
    private val jsonrpc: String? = null


    var mapper = ObjectMapper()

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

    // todo сделать try catch
    fun deserialize(json: String, obj: Any): Any? {

        return mapper.readValue(json, obj::class.java)

    }

}