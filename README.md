# Kubeless kotlin example

## Getting started

- Setup kubeless using the [quick start guide](https://kubeless.io/docs/quick-start/)
- Compile with `mvn clean package`
- Deploy with `kubeless function deploy hello --runtime jvm-1.8 --from-file target/hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar --handler helloworld_Handler.sayHello`
- Check status with `kubeless function ls`
- Once running invoke with `kubeless function call hello`
- Check logs with `kubeless function logs hello`
