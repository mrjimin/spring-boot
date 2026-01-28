package kr.jimin.test.service

import kr.jimin.test.domain.Member
import kr.jimin.test.repository.MemberRepository

class MemberService(
    private val memberRepository: MemberRepository
) {

    fun join(member: Member): Long =
        memberRepository.findByName(member.name)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        } ?: memberRepository.save(member).id

//    fun join(member: Member): Long =
//        validateDuplicateMember(member)

//    private fun validateDuplicateMember(member: Member): Long = memberRepository.findByName(member.name)?.let {
//        throw IllegalStateException("이미 존재하는 회원입니다.")
//    } ?: memberRepository.save(member).id

//    fun join(member: Member): Long {
//        validateDuplicateMember(member)
//        return memberRepository.save(member).id
//    }
//
//    private fun validateDuplicateMember(member: Member) {
//        memberRepository.findByName(member.name)?.let {
//            throw IllegalStateException("이미 존재하는 회원입니다.")
//        }
//    }

    fun findMembers(): List<Member> =
        memberRepository.findAll()

    fun findOne(memberId: Long) =
        memberRepository.findById(memberId)


}