import Api.GetRequestCommonParams
import CcustomSerializer.GetRequestCommonParamsCustomSerializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

object JaksonUtil {

    init {
        val kot = KotlinModule()

        val mapper = ObjectMapper().registerModule(kot)

        // val simpleModule:SimpleModule = SimpleModule()

        println("3333333")
        kot.addSerializer(GetRequestCommonParams::class.java, GetRequestCommonParamsCustomSerializer())
        //simpleModule.addSerializer(GetRequestCommonParamsCustomSerializer())
        //mapper.regi
    }

}