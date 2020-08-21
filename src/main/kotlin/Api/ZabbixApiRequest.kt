package Api

import java.util.*


open class ZabbixApiRequest {
  open var id = Random().nextInt(Int.MAX_VALUE)

  open var jsonrpc = "2.0"

  open lateinit var method: String

  open var auth: String? = null

}