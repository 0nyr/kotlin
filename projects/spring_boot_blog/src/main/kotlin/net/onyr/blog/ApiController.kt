package net.onyr.blog

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class HelloController {

    @RequestMapping
    fun hello(): String {
        return "Hello, World!"
    }
}