import Api.GetRequestCommonParams
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class test(tt: String) : test3() {
    override var method: String = "host.get"
    val params = testparams()

    /*   class testIN:GetRequestCommonParams(){
           private var groupids: List<Int?>? = null
           private var applicationids: List<Int>? = null
       }
   */
    class testparams : GetRequestCommonParams() {
        val testfff = ""
    }
}