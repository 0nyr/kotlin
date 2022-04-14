package net.onyr.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogApplicationKt

class MainKt {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<BlogApplicationKt>(*args)
		}
	}
}
