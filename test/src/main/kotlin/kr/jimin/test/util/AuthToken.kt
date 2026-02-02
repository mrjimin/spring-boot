package kr.jimin.test.util

import java.util.UUID
import kotlin.io.encoding.Base64

data class AuthToken(
    val id: Int,
    val name: String,
    val role: Role
) {

    enum class Role(val code: Char) {
        STUDENT('S'), TEACHER('T');

        companion object {
            fun fromCode(code: Char) = entries.find { it.code == code }
                ?: throw IllegalArgumentException("Unknown code")
        }
    }

    fun toToken(): String =
        "${role.code}:$id:$name"
            .let { Base64.encode(it.encodeToByteArray()) }

    companion object {
        fun formToken(token: String): AuthToken = runCatching {
            Base64.decode(token).decodeToString()
                .split(":", limit = 3)
                .let { (role, id, name) -> AuthToken(id.toInt(), name, Role.fromCode(role[0])) }
        }.getOrElse {
            throw IllegalArgumentException("토큰 복원 실패", it)
        }
    }
}