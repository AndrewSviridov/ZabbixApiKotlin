package Api

open class ZabbixApiException : Exception {
    constructor(message: String?) : super(message) {}
    constructor(t: Throwable?) : super(t) {}
}