package RestAPI.adapter;

import RestAPI.ConstantesRestAPI;
import RestAPI.Endpoints;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RGonzales on 11/22/2016.
 */

public class RestApiAdapter {

    public Endpoints establecerConexionesAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Endpoints.class);
    }

}
