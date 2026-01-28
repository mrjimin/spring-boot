package kr.jimin.test.service

import kr.jimin.test.domain.Member
import kr.jimin.test.repository.MemoryMemberRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.fail
import kotlin.test.fail

class MemberServiceTest {

    private lateinit var memberService: MemberService
    private lateinit var memberRepository: MemoryMemberRepository

    @BeforeEach
    fun beforeEach() {
        memberRepository = MemoryMemberRepository()
        memberService = MemberService(memberRepository)
    }

    @AfterEach
    fun afterEach() = memberRepository.clear()

    @Test
    fun 회원가입() {
        // given
        val member = Member(name = "spring")
            // .let { memberService.join(it) }

        // when
        val saveId = memberService.join(member)

        // then
        val findMember = memberService.findOne(saveId)
        Assertions.assertThat(member.name).isEqualTo(findMember?.name)
//        Assertions.assertThat {
//            member.name == findMember?.name
//        }
    }

    @Test
    fun 중복_회원_예외() {
        // given
        val member1 = Member(name = "spring")
        val member2 = Member(name = "spring")

        // when
        memberService.join(member1)
        val e = assertThrows(IllegalStateException::class.java) {
            memberService.join(member2)
        }

        assertThat(e.message).isEqualTo("이미 존재하는 회원입니다.")

//        try {
//            memberService.join(member2)
//            fail()
//        } catch (e: IllegalStateException) {
//            assertThat(e.message).isEqualTo("이미 존재하는 회원입니다.")
//        }

        // then
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }

}