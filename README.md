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
    implementation("com.nbottarini:asimov-kotlin-extensions:1.0.1")
}
```

#### Gradle (Groovy)

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.nbottarini:asimov-kotlin-extensions:1.0.1'
}
```

#### Maven

```xml
<dependency>
    <groupId>com.nbottarini</groupId>
    <artifactId>asimov-kotlin-extensions</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Any Extensions

- `fun Any?.ifNull(block: () -> Unit)`
- `fun <T: Any> T?.ifNotNull(block: (T) -> Unit)`
- `fun Any?.throwIfNull(block: (T) -> Throwable)`

```kotlin
user.ifNull { println("User is null") }

user.ifNotNull { println("User is not null") }

user.throwIfNull { UserRequiredError() }
```

## Boolean Extensions

- `fun Boolean.ifTrue(block: () -> Unit)`
- `fun Boolean.ifFalse(block: () -> Unit)`
- `fun Boolean.throwIfTrue(block: () -> Throwable)`
- `fun Boolean.throwIfFalse(block: () -> Throwable)`

```kotlin
condition.ifTrue { println("Condition is true") }

condition.ifFalse { println("Condition is false") }

(fromDate > toDate).throwIfTrue { InvalidDateRange() }

(fromDate < toDate).throwIfFalse { InvalidDateRange() }
```

## Generic Extensions

- `fun T.alsoIf(condition: Boolean, block: (T) -> Unit)`

```kotlin
User().alsoIf(addUser) { userRepository.add(it) }
```

## Iterable Extensions

- `fun <T> Iterable<T>.each(action: (T) -> Unit)`

```kotlin
users.each { println(it.name)}
```

## List Extensions

- `fun List<Any>.stringArray(): Array<String>`

## String Extensions

- `fun String.toSnakeCase(): String`
- `fun String?.throwIfNullOrBlank(block: () -> Throwable)`
- `fun String.lastWord()`

```kotlin
"myName".toSnakeCase() // returns "my_name"
email.throwIfNullOrBlan { EmailRequiredError() }
"Some sentence".lastWord() // returns "sentence"
```

## MutableLazy

```kotlin
var user by mutableLazy { fetchUser() }
user = fetchOtherUser()
```

## DetailsExt

```kotlin
fun address(addDetails: DetailsExt<AddressBuilder>): Address {
    return AddressBuilder().also(addDetails).build()
}

val myAddress = address { street("Western Avenue"); city("New York") }
```
