package Api

import java.util.*

object ZbxListUtils {
    fun <E> add(list: ArrayList<E>?, e: E): ArrayList<E> {
        var list = list
        if (list == null) {
            list = ArrayList()
        }
        list.add(e)
        return list
    }
}