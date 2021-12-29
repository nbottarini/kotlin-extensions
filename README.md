# asimov/kotlin-extensions
Useful Kotlin extensions. Part of Asimov collection of libraries.

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
