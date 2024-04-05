package pro.juxt

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

fun main() {
    val server = HttpServer.create(InetSocketAddress(8080), 0)
    server.createContext("/", Index())
    server.executor = null // WHAT?
    println("Starting chatKotlin on port 8080")
    server.start()
}

class Index : HttpHandler {
    override fun handle(t: HttpExchange) {
        val response = "HELLO"
        t.sendResponseHeaders(200, response.length.toLong())
        val os = t.responseBody
        os.write(response.toByteArray())
        os.close()
    }
}
