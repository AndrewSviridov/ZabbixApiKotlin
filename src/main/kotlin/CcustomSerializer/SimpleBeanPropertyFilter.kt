package CcustomSerializer

import Api.GetRequestCommonParams
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter
import com.fasterxml.jackson.databind.ser.PropertyWriter
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter


class SimpleBeanPropertyFilter : SimpleBeanPropertyFilter() {

    @Throws(Exception::class)
    override fun serializeAsField(
        pojo: Any,
        jgen: JsonGenerator,
        provider: SerializerProvider?,
        writer: PropertyWriter
    ) {
        if (include(writer)) {

            if (!writer.name.equals("output")) {
                // writer.serializeAsField(pojo, jgen, provider)
                val outputValue: ArrayList<String>? = (pojo as GetRequestCommonParams).output
                if (outputValue != null) {
                    if (outputValue.size == 1 && (outputValue[0] == "extend" || outputValue[0] == "count")) {
                        // writer.serializeAsField(pojo, jgen, provider)
                        // writer.serializeAsElement(pojo, jgen, provider)
                        writer.serializeAsField("extend", jgen, provider)
                    }
                }
                return
            }
            /* val intValue: Int = (pojo as MyDtoWithFilter).getIntValue()
             if (intValue >= 0) {
                 writer.serializeAsField(pojo, jgen, provider)
             }*/
        } else if (!jgen.canOmitFields()) { // since 2.3
            writer.serializeAsOmittedField(pojo, jgen, provider)
        }
    }

    override fun include(writer: BeanPropertyWriter?): Boolean {
        return true
    }

    override fun include(writer: PropertyWriter?): Boolean {
        return true
    }
}