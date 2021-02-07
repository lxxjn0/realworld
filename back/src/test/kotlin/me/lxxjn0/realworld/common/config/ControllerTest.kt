package me.lxxjn0.realworld.common.config

import com.fasterxml.jackson.databind.ObjectMapper
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {
    protected val mapper = ObjectMapper()

    @LocalServerPort
    private var port: Int = 0

    @BeforeEach
    internal fun setUp() {
        RestAssured.port = port
    }
}