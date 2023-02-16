package max.learn.cloud.catalog

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(properties = ["catalog.app.hello-msg='test'"])
class CatalogServiceApplicationTests {

    @Test
    fun contextLoads() {
    }

}
