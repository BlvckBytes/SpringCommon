<!-- This file is rendered by https://github.com/BlvckBytes/readme_helper -->

# SpringCommon

Common and thus factored-out *"boilerplate"* code that all of my spring projects require.

<!-- #toc -->

## Exceptions

The idea here is that a `DescribedException` can generate a helpful description, and all other exceptions inherit from it, thus being forced to generate these descriptions as well. The `DescribedInternalException` can either be thrown with just a message or an added exception for logging later on and represents internal server errors that the user can and should know about. `DuplicateKeyException` represents unique key conflicts, for example a duplicate `name` on an entity, when creating or updating, while `NotFoundException` refers to the absence of a required entity, identified by it's identifier map.

## Validators

A small collection of commonly required validators that gets added to whenever a new need arises. Each validator below contains a message template example, which has to be added to `ValidationMessages.properties`, at least in the case of Spring.

### MinMaxInt

Requires an integer to be within the range of `[min;max]`.

```properties
jakarta.validation.constraints.MinMaxInt.message=must be between {min} and {max}
```

### NullOrNotBlank

Requires a string value to be either null or not blank.

```properties
jakarta.validation.constraints.NullOrNotBlank.message=must be either null or not blank
```