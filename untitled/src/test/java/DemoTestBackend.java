import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class DemoTestBackend {

    @Test
    public void testGetItemsYBusquedas()
    {
        baseURI = "https://api.mercadolibre.com";
        String terminoBuscado="termoLumilagro";
        String urlSufix="/sites/MLA/search?q=".concat(terminoBuscado);
        given().
                when()
                .get(urlSufix)
                .then()
                .statusCode(200)
                .body("isEmpty()", Matchers.is(false))
                .body("site_id", Matchers.equalTo("MLA"))
                .body("query", Matchers.equalTo(terminoBuscado))
                .body("results[2].currency_id", Matchers.equalTo("ARS"));


    }





}
