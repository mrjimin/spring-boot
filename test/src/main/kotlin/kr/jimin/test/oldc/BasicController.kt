package kr.jimin.test.oldc

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

// @Controller
class BasicController {

    @GetMapping("/")
    fun hello(): String {
        return "index.html"
    }

    @GetMapping("/about")
    @ResponseBody
    fun about(): String {
        return "About"
    }
}