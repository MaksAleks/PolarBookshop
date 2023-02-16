package max.learn.cloud.catalog.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "catalog.app")
class HelloProps @ConstructorBinding constructor(
    val helloMsg: String
)