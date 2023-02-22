package max.learn.cloud.catalog

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(properties = ["catalog.app.hello-msg='test'"])
@ActiveProfiles("test")
class CatalogServiceApplicationTests {

    @Test
    fun contextLoads() {
    }

}
