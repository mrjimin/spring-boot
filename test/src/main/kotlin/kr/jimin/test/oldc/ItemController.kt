package kr.jimin.test.oldc

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

// @Controller
class ItemController {

    @GetMapping("/list")
    fun list(model: Model): String {
        // model.addAttribute("전달할데이터이름", "데이터")
        // model.addAttribute("name", "홍길동")
        // model["전달할데이터이름"] = "데이터"
        model["name"] = "홍길동"
        return "list.html"
    }

}