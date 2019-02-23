package com.eno.userss.portalberita.Network;

import com.eno.userss.portalberita.Model.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    // function / method request

    @GET("tampil_berita.php")
    Call<ResponseBerita> showAllBerita();
}
