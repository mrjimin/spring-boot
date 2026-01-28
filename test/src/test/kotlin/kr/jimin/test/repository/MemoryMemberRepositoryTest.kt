package kr.jimin.test.repository

import kr.jimin.test.domain.Member
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import kotlin.test.Test

class MemoryMemberRepositoryTest {

    val repository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() =
        repository.clear()

    @Test
    fun save() {
        val member = Member(name = "spring").let {
            repository.save(it)
        }

        val result = repository.findById(member.id)
        // println("result: ${member == result}")
        Assertions.assertThat(member).isEqualTo(result)
    }

    @Test
    fun findByName() {
        val member1 = Member(name = "spring1").let {
            repository.save(it)
        }

        val member2 = Member(name = "spring2").let {
            repository.save(it)
        }

        val result = repository.findByName("spring1")
        assertThat(result).isSameAs(member1)
    }

    @Test
    fun findAll() {
        val member1 = Member(name = "spring1").let {
            repository.save(it)
        }

        val member2 = Member(name = "spring2").let {
            repository.save(it)
        }

        val result = repository.findAll()
        result.forEach {
            println(it)
        }

        assertThat(result.size).isGreaterThanOrEqualTo(2)
    }
}