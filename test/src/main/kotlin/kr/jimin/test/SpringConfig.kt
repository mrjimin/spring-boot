//package kr.jimin.test
//
//import kr.jimin.test.repository.MemberRepository
//import kr.jimin.test.repository.MemoryMemberRepository
//import kr.jimin.test.service.MemberService
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//class SpringConfig {
//
//    @Bean
//    fun memberService(): MemberService =
//        MemberService(memberRepository())
//
//    @Bean
//    fun memberRepository(): MemberRepository =
//        MemoryMemberRepository()
//
//}