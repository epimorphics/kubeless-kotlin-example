# Kubeless kotlin example

## Getting started
- Setup kubeless using the [quick start guide](https://kubeless.io/docs/quick-start/)
- Compile with `mvn clean package`

## Basic Function
- Deploy with `kubeless function deploy hello --runtime jvm-1.8 --from-file target/hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar --handler io_kubeless_Hello.sayHello`
- Check status with `kubeless function ls`
- Once running invoke with `kubeless function call hello`
- Check logs with `kubeless function logs hello`

## Http Trigger
- `kubeless trigger http create test --function-name=hello`
- This creates and ingress in kubernetes, you will need a ingress controller to access it, (minikube `minikube addons enable ingress`)
- the hostname can be found in `kubectl get ingress`
- curl --header "Host: get-jvm-kt.192.168.99.100.nip.io" 192.168.99.100/echo

## Kafka Trigger
- Deploy with `kubeless function deploy hello --runtime jvm-1.8 --from-file target/hello-world-1.0-SNAPSHOT-jar-with-dependencies.jar --handler io_kubeless_Hello.printKafka`
- `kubeless trigger kafka create test --function-selector created-by=kubeless,function=kafka-test --trigger-topic test-topic`
- Create kafka cluster in kube `kubectl create -f https://github.com/kubeless/kafka-trigger/releases/download/v1.0.0-beta.0/kafka-zookeeper-v1.0.0-beta.0.yaml`
- `kubeless topic create test-topic`
- `kubeless topic publish --topic test-topic --data "hello world"`

## Deploy with kotlin runtime
This requires the epimorphics/kubeless fork to work since kotlin isn't supported by default kubeless, run this to create a kotlin function
- kubeless function deploy java-test --runtime kotlin1.8 --handler Hello.sayHello --from-file src/main/kotlin/io/kubeless/Handler.kt --dependencies dep-pom.xml
