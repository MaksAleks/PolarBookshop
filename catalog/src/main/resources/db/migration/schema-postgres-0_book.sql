create table book(
                             isbn varchar(256) constraint book_pk primary key,
                             title varchar(256) constraint book_title_nn not null,
                             author varchar(256) constraint book_author_nn not null,
                             price decimal constraint book_price_nn not null,
                             constraint book_title_not_empty check ( title <> '' ),
                             constraint book_author_not_empty check ( author <> '' ),
                             constraint book_price_positive check ( price > 0 )
)