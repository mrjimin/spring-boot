package kr.jimin.test.repository

import kr.jimin.test.domain.Member
import javax.sql.DataSource

class JdbcMemberRepository(
    private val dataSource: DataSource
) : MemberRepository {

    override fun save(member: Member): Member {
        val sql = "INSERT INTO member(name) values(?)"
        val pstmt = dataSource.connection.prepareStatement(sql)
        pstmt.setString(1, member.name)
        pstmt.executeUpdate()
        return Member(1, "a")
    }

    override fun findById(id: Long): Member? {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String): Member? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Member> {
        TODO("Not yet implemented")
    }
}