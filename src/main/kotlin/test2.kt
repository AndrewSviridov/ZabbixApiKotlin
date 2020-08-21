/*@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Car.class, name = "car"),
    @JsonSubTypes.Type(value = Truck.class, name = "truck")
})*/
open class test2 {


    open var countOutput: Boolean? = null


    open var excludeSearch: Boolean? = null

    private var limit: Int? = null

    fun tesM() {

    }

}