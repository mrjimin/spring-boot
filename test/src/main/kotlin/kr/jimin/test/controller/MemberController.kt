package kr.jimin.test.controller

import kr.jimin.test.service.MemberService
import org.springframework.stereotype.Controller

@Controller
class MemberController(
    private val memberService: MemberService
) {



}