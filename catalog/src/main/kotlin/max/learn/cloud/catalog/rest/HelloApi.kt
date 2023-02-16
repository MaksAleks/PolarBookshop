package max.learn.cloud.catalog.rest

import max.learn.cloud.catalog.config.HelloProps
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RequestMapping("/hello")
@RestController
class HelloApi(
    val props: HelloProps
) {

    @GetMapping
    fun hello(): String {
        return props.helloMsg
    }
}