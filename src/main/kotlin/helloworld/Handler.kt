package helloworld

class Handler {
  fun sayHello(event : io.kubeless.Event, context : io.kubeless.Context) : String {
    println(event.toString())
    return "hello world"
  }
}
