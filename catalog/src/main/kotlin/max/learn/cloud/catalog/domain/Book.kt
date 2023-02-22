package max.learn.cloud.catalog.domain

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class Book(
    @NotEmpty
    val isbn: String,
    @NotEmpty
    val title: String,
    @NotEmpty
    val author: String,
    @Positive
    val price: BigDecimal
)