package kr.jimin.test.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @GetMapping("/hello")
    fun hello(model: Model): String {
        model["data"] = "hello!!"
        return "hello"
    }

    @GetMapping("/hello-mvc")
    fun helloMVC(
        @RequestParam("name") name: String,
        model: Model
    ): String {
        model["name"] = name
        return "hello-template"
    }

    @GetMapping("/hello-string")
    @ResponseBody
    fun helloString(@RequestParam("name") name: String): String {
        return "hello $name"
    }

    @GetMapping("/hello-api")
    @ResponseBody
    fun helloAPI(
        @RequestParam("name") name: String
    ): Hello {
        val hello = Hello()
        hello.name = name
        return hello
    }

    class Hello {
        var name: String? = null
    }

}