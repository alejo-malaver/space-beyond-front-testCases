# qa-serenity-example

[![gradle](https://img.shields.io/badge/gradle-v7.3.X-yellow.svg)](https://gradle.org/install/)


>A simple Gradle project to test with Java, Serenity && Cucumber.
## Prerequisites

You will need the following things properly installed on your computer.

* [Git](http://git-scm.com/)
* [Gradle](https://gradle.org)
* [Java](https://www.java.com)


## Installation

We use [Gradle](http://www.gradle.org), a cross-platform build automation tool that help with our full development flow.
If you prefer [install Gradle](http://www.gradle.org/installation) or use a [Gradle wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html) inside this project.

* ´git clone https://github.com/alejo-malaver/space-beyond-front-testCases` this repository
##  Executing the tests
the parameter **-Denvironment** can to take values like:
* dev: development environment.
- stg: staging environment.
+ pro: production environment.

By default, the tests will execute the pro environment, the tests will run using Chrome, generating report in html and executing only the @Booking tags test cases:
```bash
./gradlew clean test aggregate
```

For specific tags, use the param -Dcucumber.filter.tags with value of tag or tags to execute

```bash
./gradlew clean test aggregate -Dcucumber.filter.tags="@Booking"
```

The test results will be recorded in the `target/site/serenity` directory, open the index.html file.

The file will detail the results from the latest execution.

To run sonarqube analysis:

```bash
./gradlew sonar -x test
```

A code formatter is included that allows you to sort your code after any change, to use it you can run:
```bash
./gradlew spotlessApply
```

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _stg_ and _pro_, with different starting URLs for each:
```json
environments {
default {
	base.url = "http://demo.testim.io/"
}
dev {
	base.url = "http://dev.demo.testim.io/"
}
stg {
	base.url = "http://stg.demo.testim.io/"
}
pro {
	base.url = "http://demo.testim.io/"
}
}
```

You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ ./gradlew test aggregate -Denvironment=stg
```
In the following link you can view the project running locally, the execution time is notably affected by the screen recording made by the Mac, so I suggest executing the project locally to validate the real execution times:
[Execution Video](https://youtu.be/yoiKaIgwxIE)

Into serenity.conf file exists the follows params:

```json
serenity.browser.width = 1670
serenity.browser.height = 1020
headless.mode = false
```

The first ones allow you to configure the screen resolution, in my case the highest resolution in my Mac.

The third parameter allows us to execute the project without the need to view the browser, that is, to execute it underneath without affecting our daily work, simply leaving the parameter in true, in case it is false, the browser will be loaded and will prevent you from continuing with other tasks within the machine.
