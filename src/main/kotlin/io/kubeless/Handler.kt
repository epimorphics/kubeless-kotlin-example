package io.kubeless

class Hello {
  fun sayHello(event : io.kubeless.Event, context : io.kubeless.Context) : String {
    println(event.toString())
    return "hello world"
  }

  fun printKafka(event : io.kubeless.Event, context : io.kubeless.Context) : String {
    println(event.Data)
    return event.Data
  }
}
