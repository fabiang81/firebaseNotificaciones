package RestAPI;

import RestAPI.model.UsuarioRespuesta;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by RGonzales on 11/22/2016.
 */

public interface Endpoints {

    @FormUrlEncoded
    @POST(ConstantesRestAPI.KEY_POST_ID_TOKEN)
    Call<UsuarioRespuesta> registrarTokenID(@Field("token") String token, @Field("animal") String animal);


    @GET(ConstantesRestAPI.KEY_TOQUE_ANIMAL)
    Call<UsuarioRespuesta> toqueAnimal(@Path("id") String id, @Path("animal") String animal);

}
