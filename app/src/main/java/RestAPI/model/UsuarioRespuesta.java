package RestAPI.model;

/**
 * Created by RGonzales on 11/22/2016.
 */

public class UsuarioRespuesta {

    private String id;
    private String token;
    private String animal;

    public UsuarioRespuesta() {
    }

    public UsuarioRespuesta(String id, String token, String animal) {
        this.id = id;
        this.token = token;
        this.animal = animal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
