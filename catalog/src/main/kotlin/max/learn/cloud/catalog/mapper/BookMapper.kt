package max.learn.cloud.catalog.mapper

import max.learn.cloud.catalog.domain.Book
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet

@Component
class BookMapper : RowMapper<Book> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Book? {
        return Book(
            isbn = rs.getString("isbn"),
            title = rs.getString("title"),
            author = rs.getString("author"),
            price = rs.getBigDecimal("price")
        )
    }
}