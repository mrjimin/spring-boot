package kr.jimin.test.repository

import kr.jimin.test.domain.Member
import org.springframework.stereotype.Repository

@Repository
class MemoryMemberRepository : MemberRepository {

    companion object {
        val store: MutableMap<Long, Member> = hashMapOf()
        var sequence: Long = 0L
    }

    override fun save(member: Member): Member =
        member.copy(id = ++sequence).also {
            store[it.id] = it
        }

    override fun findById(id: Long): Member? =
        store[id]

    override fun findByName(name: String): Member? =
        store.values.find { it.name == name }

    override fun findAll(): List<Member> =
        store.values.toList()

    fun clear() = store.clear()
}