package cliente;

import mapeos.CharacterInTheFilm;

import static io.restassured.RestAssured.given;

public class GetCharacterInTheFilm {

    public static CharacterInTheFilm getCharacter (String url){
        return given().header("Content-Type", "application/json")
                .when().get(url)
                .then().statusCode(200).extract().body().as(CharacterInTheFilm.class);
    }
}
