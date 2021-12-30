[![Maven](https://img.shields.io/maven-central/v/com.nbottarini/asimov-kotlin-extensions.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.nbottarini%22%20AND%20a%3A%22asimov-kotlin-extensions%22)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![CI Status](https://github.com/nbottarini/asimov-kotlin-extensions/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/nbottarini/asimov-kotlin-extensions/actions?query=branch%3Amain+workflow%3Aci)

# asimov/kotlin-extensions
Useful Kotlin extensions. Part of Asimov collection of libraries.

## Installation

#### Gradle (Kotlin)

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.nbottarini:asimov-kotlin-extensions:1.0")
}
```

#### Gradle (Groovy)

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.nbottarini:asimov-kotlin-extensions:1.0'
}
```

#### Maven

```xml
<dependency>
    <groupId>com.nbottarini</groupId>
    <artifactId>asimov-kotlin-extensions</artifactId>
    <version>1.0</version>
</dependency>
```

## Any Extensions

- `Any?.ifNull(block: () -> Unit)`
- `<T: Any> T?.ifNotNull(block: (T) -> Unit)`
- `Any?.throwIfNull(block: (T) -> Throwable)`

```kotlin
user.ifNull { println("User is null") }

user.ifNotNull { println("User is not null") }

user.throwIfNull { UserRequiredError() }
```

## Boolean Extensions

- `Boolean.ifTrue(block: () -> Unit)`
- `Boolean.ifFalse(block: () -> Unit)`
- `Boolean.throwIfTrue(block: () -> Throwable)`
- `Boolean.throwIfFalse(block: () -> Throwable)`

```kotlin
condition.ifTrue { println("Condition is true") }

condition.ifFalse { println("Condition is false") }

(fromDate > toDate).throwIfTrue { InvalidDateRange() }

(fromDate < toDate).throwIfFalse { InvalidDateRange() }
```

## Generic Extensions

- `T.alsoIf(condition: Boolean, block: (T) -> Unit)`

```kotlin
User().alsoIf(addUser) { userRepository.add(it) }
```
