package kr.jimin.test.util

import java.nio.charset.StandardCharsets
import java.util.UUID
import kotlin.test.Test

class AuthTokenTest {

    @Test
//    fun main() {
//        val student = AuthToken(1, "Spring", AuthToken.Role.STUDENT)
//        println(student.toToken())
//
//        println(AuthToken.formToken(student.toToken()))
//
//        println(student.toString())
//    }
    fun main() {
        println(tokenUUID(10614, "서지민"))
    }

    fun tokenUUID(id: Int, name: String,): UUID {
        val format = "$id:$name"
        return UUID.nameUUIDFromBytes(format.toByteArray(StandardCharsets.UTF_8))
    }
}