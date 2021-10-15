import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    @Test
    public void testGetItemsYBusquedas(){
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







    @Test
    public void testGetUser(){
       baseURI = "https://reqres.in/api";
        given().
                when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("data[1].first_name", Matchers.equalTo("Janet"));

        }
    @Test
    public void testPostUser(){
        baseURI = "https://reqres.in/api";

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "Alejandro");
        map1.put("job", "Costumer Success");
        given()

                .body(map1.toString())
                .when()
                    .log().all()
                .post("/users")
                .then()
                .statusCode(201);

    }
}