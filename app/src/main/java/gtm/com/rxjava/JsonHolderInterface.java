package gtm.com.rxjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gowtham pr on 4/21/2017.
 */

public interface JsonHolderInterface {


    @GET("/posts")
    Call<List<Model>> getRepos();


}
