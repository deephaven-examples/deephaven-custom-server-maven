# Deephaven custom server with Maven

This project is a developer-targeted example for integrating code and 3rd-party libraries into a custom Deephaven server
using [Maven](https://maven.apache.org/). For a higher-level introduction to Deephaven, see the
[Deephaven Community Docs](https://deephaven.io/core/docs/).

For developers who prefer Gradle, see [Deephaven custom server with Gradle](https://github.com/deephaven-examples/deephaven-custom-server-gradle).

For example purposes, this project depends on the [commons-math3](https://commons.apache.org/proper/commons-math/)
library, as well as some custom code to find the roots of the
[quadratic equation](https://en.wikipedia.org/wiki/Quadratic_equation).

### Getting started

To get up and running immediately with the server, you can run:

```shell
./mvnw -Ddeephaven.console.type=groovy compile exec:java -Dexec.mainClass=io.deephaven.server.netty.NettyMain
```

To run the tests:

```shell
./mvnw verify
```

By default, this will run the Deephaven gRPC API at `localhost:8080`.
Note: the current Netty-based distribution does not start a web server.

### POM

#### os-maven-plugin
The [os-maven-plugin](https://github.com/trustin/os-maven-plugin) is a required build extension.
It is responsible to resolve netty OS / architecture specific  dependencies.

```xml
<build>
    <extensions>
        <extension>
            <groupId>kr.motd.maven</groupId>
            <artifactId>os-maven-plugin</artifactId>
            <version>1.7.0</version>
        </extension>
    </extensions>
</build>
```

#### Bill of Materials
The Deephaven BOM is used to inherit the proper versions for other Deephaven dependencies. This dependency is optional.

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>io.deephaven</groupId>
            <artifactId>deephaven-bom</artifactId>
            <version>0.10.0</version>
            <type>pom</type>
            <scope>import</scope>
      </dependency>
    </dependencies>
</dependencyManagement>
```

#### Repositories

There are currently some external dependencies that aren't deployed to Maven Central.
To ensure these dependencies can be downloaded, a few extra repositories will need to be specified:

```xml
  <repositories>
    <repository>
      <id>central</id>
      <name>Central Repository</name>
      <url>https://repo.maven.apache.org/maven2</url>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
    </repository>

    <!-- io.confluent / org.apache.kafka -->
    <repository>
      <id>packages.confluent.io</id>
      <url>https://packages.confluent.io/maven</url>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
    </repository>

    <!-- com.hadoop.gplcompression -->
    <repository>
      <id>maven.twttr.com</id>
      <url>https://maven.twttr.com</url>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
    </repository>

    <!-- com.github.rdblue -->
    <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
    </repository>
  </repositories>
```
