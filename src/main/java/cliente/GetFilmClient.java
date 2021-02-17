package cliente;
import mapeos.Film;
import static io.restassured.RestAssured.given;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class GetFilmClient {

    public GetFilmClient(){}

    public static Film getFilm (){
        String url ="https://swapi.dev/api/films/1";
        return given().header("Content-Type", "application/json")
               .when().get(url)
               .then().statusCode(200).extract().body().as(Film.class);
    }
}
