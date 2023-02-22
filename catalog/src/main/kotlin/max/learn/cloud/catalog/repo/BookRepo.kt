package max.learn.cloud.catalog.repo

import max.learn.cloud.catalog.domain.Book

interface BookRepo {

    fun getBook(isbn: String): Book
    fun getBooks(): List<Book>
    fun createBook(book: Book)
    fun updateBook(book: Book)
    fun deleteBook(isbn: String)
}