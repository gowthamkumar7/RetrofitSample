package gtm.com.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        JsonHolderInterface response = retrofit.create(JsonHolderInterface.class);
        final Call<List<Model>> mcall = response.getRepos();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcall.enqueue(new Callback<List<Model>>() {
                    @Override
                    public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {


                        for (int i = 0; i < response.body().size(); i++) {
                            Log.i(TAG, "onResponse: " + response.body().get(i).getTitle());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Model>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });


       /* mcall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.i("onResponse", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                t.printStackTrace();
            }
        });*/


    }


}
