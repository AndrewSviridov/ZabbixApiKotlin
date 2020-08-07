import org.slf4j.LoggerFactory
import java.io.IOException
import java.util.*

class PropertiesClassK {

    var url: String
    var password: String
    var user: String

    var properties = Properties()

    @Throws(Exception::class)
    fun getProperties() {
        try {
            this.javaClass.classLoader
            try {
                ClassLoader.getSystemResourceAsStream(NAMEFILEPROPERTY)
                    .use { inputStream -> properties.load(inputStream) }
            } catch (e: IOException) {
                logger.error("Failed load properties {}.", e)
                throw IOException("Failed load properties.", e)
            }
        } catch (e: Exception) {
            logger.error("Wrong path or name file properties {}.", e)
            throw Exception("Wrong path or name file properties ", e)
        }
    }

    override fun toString(): String {
        return "PropertiesClassK(host='$url', password='$password', user='$user')"
    }

    companion object {
        const val NAMEFILEPROPERTY = "config.properties"

        val logger = LoggerFactory.getLogger(PropertiesClassK::class.java)
    }

    init {
        getProperties()

        if (!properties.isEmpty) {
            val fields = PropertiesClassK::class.java.getDeclaredFields()
            val listFields: MutableList<String> = mutableListOf()
            for (field in fields) {
                listFields.add(field.name)
            }

            for (key in properties.keys) {
                if (!listFields.contains(key.toString())) {
                    throw Exception("No key value in Properties: $key")
                }
            }


            password = properties.getProperty("password")
            user = properties.getProperty("user")
            url = properties.getProperty("url")

        } else {
            throw Exception("Properties is empty")
        }
    }
}