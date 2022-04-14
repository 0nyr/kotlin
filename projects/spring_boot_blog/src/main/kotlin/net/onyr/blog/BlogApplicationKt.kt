package net.onyr.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogApplicationKt

fun main(args: Array<String>) {
	runApplication<BlogApplicationKt>(*args)
}
