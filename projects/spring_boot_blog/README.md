# Spring Boot and Kotlin

### Useful links

[Guide: building a web app with Spring-boot and Kotlin](https://spring.io/guides/tutorials/spring-boot-kotlin/)

[Video guide: Spring boot &amp; Kotlin](https://www.youtube.com/playlist?list=PL6gx4Cwl9DGDPsneZWaOFg0H2wsundyGr)

## Installation

`sdk install gradle 7.4.2`: install `gradle` for automatic recompiling and plugin management.

### VSCode

Install the following extensions

`mathiasfrohlich.kot`

`fwcd.kotlin`: The `launch.json` with `F5` command for building is broken.

## Commands

> Use `ctrl+shift+B` to use directly the commands integrated as VSCode tasks.
>
> Add new tasks by editing `tasks.json` config file.

### Gradle

`gradle init`: Init a new **Gradle** project.

`gradle projects`: list available projects.

`gradle tasks`: Get the list of available tasks for the current project. There is also the `gradle tasks --all` to get all possible tasks.

`gradle bootRun`: Run LiveReload server.

`gradle build`: Launch build and tests

`gradle classes --build-cache --continuous`: Run a build daemon for quick automatic rebuild.

## Workflow

> Read [gradle automatic restart](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#using.devtools.restart) and [gradle live reload](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#using.devtools.livereload) for more details.

1. In a first terminal, launch the **LiveReload** server with `gradle bootRun`. This runs a server for testing purpose.
2. In another terminal, run `gradle build` to rebuild and update the classpath when necessary. This is because the automatic reload is only effective once the classes have been recompiled and modified. This commands runs build and tests and is quite slow. You also need to rerun it when needed. Use `gradle classes --build-cache --continuous` to accelerate the process, and make it automatic when a file is changed.

## TODO
