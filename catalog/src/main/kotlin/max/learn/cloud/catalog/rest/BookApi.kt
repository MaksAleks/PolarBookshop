package max.learn.cloud.catalog.rest

import jakarta.validation.Valid
import max.learn.cloud.catalog.domain.Book
import max.learn.cloud.catalog.domain.BookExistException
import max.learn.cloud.catalog.repo.BookRepo
import org.springframework.dao.DataAccessException
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/books")
class BookApi(val repo: BookRepo) {

    @GetMapping
    fun list(): List<Book> {
        return repo.getBooks()
    }

    @GetMapping("/{isbn}")
    fun get(@PathVariable("isbn", required = true) isbn: String): Book {
        return repo.getBook(isbn)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody book: Book) {
        repo.createBook(book)
    }

    @PutMapping
    fun update(@Valid @RequestBody book: Book) {
        repo.updateBook(book)
    }

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("isbn", required = true) isbn: String) {
        repo.deleteBook(isbn)
    }

    @ExceptionHandler(NoSuchElementException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNoSubElement(ex: NoSuchElementException): String {
        return ex.message ?: "Book not found"
    }

    @ExceptionHandler(BookExistException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun alreadyExist(ex: BookExistException): String {
        return ex.message ?: "Book already exist"
    }

    @ExceptionHandler(DuplicateKeyException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun duplicate(ex: DuplicateKeyException): String {
        return ex.message ?: "Book already exist"
    }

    @ExceptionHandler(DataAccessException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun dataAccess(ex: DataAccessException): String {
        return ex.message ?: "Error accessing book storage"
    }
}