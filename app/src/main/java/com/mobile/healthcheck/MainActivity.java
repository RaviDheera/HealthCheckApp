package com.mobile.healthcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mobile.healthcheck.model.Object;
import com.mobile.healthcheck.service.ServiceInterface;
import com.mobile.healthcheck.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    ServiceInterface apiInterface;
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView txtresponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtresponse=(TextView)findViewById(R.id.txtresponse);

        retrofit = new Retrofit.Builder()
                .baseUrl(ServiceInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ServiceInterface.class);

        setHealthCheck();
    }

    private void setHealthCheck() {

        Call<Object> bannerCall = apiInterface.healthCheck();
        bannerCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    Object responseObject = response.body();
                    Log.v(TAG, "Response code : " + response.body());

                    txtresponse.setText(responseObject.getData().getMessage().toString());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }
}