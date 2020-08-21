package CcustomSerializer

import Api.GetRequestCommonParams
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

class GetRequestCommonParamsCustomSerializer : JsonSerializer<GetRequestCommonParams>() {

    companion object {
        private const val serialVersionUID = 1L
    }

    override fun serialize(value: GetRequestCommonParams?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        value?.let {
            gen?.writeStartObject()
            it.countOutput?.let { it1 -> gen?.writeBooleanField("countOutput", it1) }
            it.editable?.let { it1 -> gen?.writeBooleanField("editable2222", it1) }
            it.excludeSearch?.let { it1 -> gen?.writeBooleanField("excludeSearch", it1) }
            it.filter?.let { it1 -> serializers?.defaultSerializeField("filter", it1, gen) }

            it.limit?.let { it1 -> gen?.writeNumberField("limit", it1) }
            it.output?.let { it1 ->
                if (it1.size == 1 && (it1[0] == "extend" || it1[0] == "count")) {

                    gen?.writeStringField("output", it1[0])
                } else {
                    serializers?.defaultSerializeField("output", it.output, gen);
                }
            }
            it.preservekeys?.let { it1 -> gen?.writeBooleanField("preservekeys", it1) }
            it.search?.let { it1 -> serializers?.defaultSerializeField("search", it1, gen) }

            it.searchByAny?.let { it1 -> gen?.writeBooleanField("searchByAny", it1) }
            it.searchWildcardsEnabled?.let { it1 -> gen?.writeBooleanField("searchWildcardsEnabled", it1) }
            it.sortfield?.let { it1 -> serializers?.defaultSerializeField("sortfield", it1, gen) }

            it.startSearch?.let { it1 -> gen?.writeBooleanField("startSearch", it1) }


            gen?.writeEndObject()
        }
    }
}
