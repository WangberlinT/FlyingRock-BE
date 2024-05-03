import com.flyingrock.domain.ResponseBody
import com.flyingrock.domain.user.RegistrationResponse
import com.flyingrock.domain.user.RegistrationRequest
import com.flyingrock.module
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertEquals

class RegisterTest {
    @Test
    fun testRegister() = testApplication {
        application {
            module()
        }
        val response = client.post("/register") {
            headers {
                append(HttpHeaders.ContentType, "text/plain")
            }
            setBody(Json.encodeToString(RegistrationRequest(username = "tiki", password = "123456")))
        }
        val data = response.body<ResponseBody<RegistrationResponse>>().data
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(data, RegistrationResponse(message = "success"))

    }
}