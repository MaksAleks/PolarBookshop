package max.learn.cloud.catalog.repo.impl

import max.learn.cloud.catalog.domain.Book
import max.learn.cloud.catalog.mapper.BookMapper
import max.learn.cloud.catalog.repo.BookRepo
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class JdbcBookRepo(val jdbcTemplate: JdbcTemplate, val mapper: BookMapper) : BookRepo {

    @Transactional
    override fun getBook(isbn: String): Book {
        return jdbcTemplate.query("select * from book where isbn='$isbn'", mapper)
            .first() ?: throw NoSuchElementException("Book(isbn = $isbn)")
    }

    @Transactional
    override fun getBooks(): List<Book> {
        return jdbcTemplate.query("select * from book", mapper)
    }

    @Transactional
    override fun createBook(book: Book) {
        jdbcTemplate.update("insert into book(isbn, title, author, price)" +
                " values ('${book.isbn.trim()}', '${book.title.trim()}', '${book.author.trim()}', ${book.price})")
    }

    override fun updateBook(book: Book) {
        jdbcTemplate.update(
            "update book set" +
                    " title = '${book.title.trim()}'," +
                    " author = '${book.author.trim()}'," +
                    " price = ${book.price})" +
                    " where isbn = '${book.isbn}'"
        ).let { updatedRowsNum ->
            if (updatedRowsNum == 0) {
                throw NoSuchElementException("Book(isbn = ${book.isbn})")
            }
        }
    }

    override fun deleteBook(isbn: String) {
        jdbcTemplate.update("delete from book where isbn = '${isbn}'").let { deletedRowsNum ->
            if (deletedRowsNum == 0) {
                throw NoSuchElementException("Book(isbn = ${isbn})")
            }
        }
    }
}