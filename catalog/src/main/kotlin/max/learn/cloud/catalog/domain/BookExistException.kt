package max.learn.cloud.catalog.domain

class BookExistException(isbn: String) : RuntimeException("Book(isbn = $isbn) already exist")