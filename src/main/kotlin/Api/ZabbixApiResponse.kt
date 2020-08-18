package Api


open class ZabbixApiResponse {
    var id = 0
    val jsonrpc: String? = null
/*
    val mapper = ObjectMapper().registerModule(KotlinModule())
    //    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // todo сделать try catch
    fun deserialize(json: String, obj: Any): Any? {

        return mapper.readValue(json, obj::class.java)

    }

    // todo сделать try catch
    fun deserializeToList(json: String, obj: Any): MutableList<Any>? {
//obj.javaClass
        val javaType: CollectionType = mapper.typeFactory
            .constructCollectionType(MutableList::class.java, obj::class.java)
        val asList: MutableList<Any> = mapper.readValue(json, javaType)

        // val asList:MutableList<Any> = mapper.readValue(json)
        return asList

    }
    */

    /*
       var mapCollectionType: `var` = mapper.typeFactory
           .constructCollectionType(MutableList::class.java, PersonV2::class.java)
       var json: `var` = "[{\"name\":\"Juan Garcia\",\"birthdate\":[1980,9,15]," +
               "\"hobbies\":[\"football\",\"squash\"]}," +
               "{\"name\":\"Manuel Perez\",\"birthdate\":\"1987-07-23\"}]"
       var value: List<PersonV2> = mapper.readValue(json, mapCollectionType)

       var asList: List<MyDto> = mapper.readValue(
           jsonArray, object : TypeReference<List<MyDto?>?>() {})

       var listOfDtos: List<MyDto> = Lists.newArrayList(
           MyDto("a", 1, true), MyDto("bc", 3, false)
       )
       var jsonArray = mapper.writeValueAsString(listOfDtos)

       var javaType: CollectionType = mapper.typeFactory
           .constructCollectionType(MutableList::class.java, MyDto::class.java)
       var asList: List<MyDto> = mapper.readValue<List<MyDto>>(jsonArray, javaType)

     */
}