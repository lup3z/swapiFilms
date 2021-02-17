package tests;
import cliente.GetCharacterInTheFilm;
import cliente.GetFilmClient;
import mapeos.CharacterInTheFilm;
import mapeos.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import java.util.List;
import static utils.PageUtils.pickRandomCharacter;


public class ConsultaPeliTest {

    @Autowired
    private GetFilmClient getFilmClient;

    @Autowired
    private GetCharacterInTheFilm getCharacterInTheFilm;

    @Test(groups="ConsultaTresPersonajesAleatoriosYSusUltimasPeliculas", description = "Test que selecciona una pelicula y," +
            " de esta, tres personajes aleatorios, y de estos ultimos, las ultimas peliculas en las que aparecieron cada uno")
    public void obtenerPersonajeYUltimaPelicula(){
    /////////// CONSULTA DE FILM: /////////////
        Film respuesta = getFilmClient.getFilm();
        List<String> characterRandom = pickRandomCharacter(respuesta.getCharacters(),3);

    /////////// CONSULTA CHARACTER: ///////////
        System.out.println("Los Resultados son: ");
        for(int i =0; i< characterRandom.size(); i++){
            CharacterInTheFilm character =getCharacterInTheFilm.getCharacter(characterRandom.get(i));
            System.out.println("Nombre: "+character.getName());
            System.out.println("Pelicula: "+character.getFilms().get(character.getFilms().size()-1));
        }
    }


}
