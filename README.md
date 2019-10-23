[![viglet_logo.png](https://openturing.github.io/turing/img/banner/viglet_turing.png)](http://viglet.com/turing)
------

**Viglet Turing XMPP** is a XMPP Server using Spring Boot.

**If you'd like to contribute to Viglet Turing XMPP, be sure to review the [contribution
guidelines](CONTRIBUTING.md).**

**We use [GitHub issues](https://github.com/openshio/turing-xmpp/issues) for
tracking requests and bugs.**

# Installation
## Deploy 
### Generate Fat Jar File

Use Gradle to generate a Viglet Turing Fat Jar file.

```shell
$ ./gradlew build
```

## Run

To run Viglet Turing Fat Jar file, just execute the following line:

```shell
$ java -jar build/libs/turing-xmpp-0.1.0.jar
```