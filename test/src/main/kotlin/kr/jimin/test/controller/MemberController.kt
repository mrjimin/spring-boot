package kr.jimin.test.controller

import kr.jimin.test.domain.Member
import kr.jimin.test.service.MemberService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MemberController(
    private val memberService: MemberService
) {

    @GetMapping("/members/new")
    fun createForm(): String {
        return "members/createMemberForm"
    }

    @PostMapping("/members/new")
//    fun create(form: MemberForm): String {
//        val member = Member(name = form.name)
//        memberService.join(member)
//        return "redirect:/"
//    }
    fun create(form: MemberForm): String {
        val member = Member(name = form.name)
        memberService.join(member)
        return "redirect:/"
    }

//    @GetMapping("/members")
//    @ResponseBody
//    fun memberList(): List<Member> {
//        return memberService.findMembers().toList()
//    }

    @GetMapping("/members")
    fun list(model: Model): String {
        val members = memberService.findMembers()
        model["members"] = members
        return "members/memberList"
    }

}