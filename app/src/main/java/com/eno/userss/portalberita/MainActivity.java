package com.eno.userss.portalberita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.eno.userss.portalberita.Adapter.BeritaAdapter;
import com.eno.userss.portalberita.Model.BeritaItem;
import com.eno.userss.portalberita.Model.ResponseBerita;
import com.eno.userss.portalberita.Network.ConfigRetrofit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        sendRequestBerita(); 

    }

    private void sendRequestBerita() {
        ConfigRetrofit.getInstancee().showAllBerita().enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {

                boolean status = response.body().isStatus();
                List<BeritaItem> dataBerita = response.body().getBerita();

                if (status) {
                    Log.d("TAG", "DATA NYA ADA NIH !!");
                    Toast.makeText(MainActivity.this, "Assalamualaikum Enov_", Toast.LENGTH_SHORT).show();
                    BeritaAdapter adapter = new BeritaAdapter(getApplicationContext(), dataBerita);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
