package com.yuskay.apis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static retrofit2.converter.gson.GsonConverterFactory.create;

public class MainActivity extends AppCompatActivity {

    public final String TAG="Api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getEmployee();
        setContentView(R.layout.activity_main);
    }

    public void getEmployee(){
        String BASE_URL="http://dummy.restapiexample.com/api/v1/";
        OkHttpClient.Builder httpclient=new OkHttpClient.Builder();
        Retrofit.Builder builder = new
                Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpclient.build()).build();
        Employeeclient employeeclient = retrofit.create(Employeeclient.class);
        Call<List<Employee>> call  =employeeclient.getEmployee();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                Log.d(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });

    }
}
