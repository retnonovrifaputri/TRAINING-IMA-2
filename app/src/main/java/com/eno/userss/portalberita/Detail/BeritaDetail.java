package com.eno.userss.portalberita.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.eno.userss.portalberita.BuildConfig;
import com.eno.userss.portalberita.Model.BeritaItemPL;
import com.eno.userss.portalberita.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeritaDetail extends AppCompatActivity {

    @BindView(R.id.tv_judul_berita)
    TextView tvJudulBerita;
    @BindView(R.id.tv_penulis)
    TextView tvPenulis;
    @BindView(R.id.tv_tanggal_posting)
    TextView tvTanggalPosting;
    @BindView(R.id.txtDetail)
    TextView txtdetail;
    @BindView(R.id.tv_berita)
    ImageView tvBerita;

    WebView webDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        ButterKnife.bind(this);

        webDetail = findViewById(R.id.webDetil);

//        Intent i = getIntent();
//        tvJudulBerita.setText(i.getStringExtra("Judul"));
//        tvPenulis.setText(i.getStringExtra("Penulis"));
//        tvTanggalPosting.setText(i.getStringExtra("Tanggal"));
//        Picasso.with(this)
//                .load(BuildConfig.BASE_URL+"images/"+i.getStringExtra("Image"))
//                .error(R.mipmap.ic_launcher_round)
//                .into(tvBerita);
        //txtdetail.setText(i.getStringExtra("Detail"));

        //webDetail.loadData(i.getStringExtra("Detail"),"text/html","utf-8");

        BeritaItemPL dataDiterima = getIntent().getParcelableExtra("data");

        tvJudulBerita.setText(dataDiterima.getJudulBerita());
        tvPenulis.setText(dataDiterima.getPenulis());
        tvTanggalPosting.setText(dataDiterima.getTanggalPosting());
        //beritaDet.setText(intent.getStringExtra("berita"));
        webDetail = findViewById(R.id.webDetil);
        webDetail.loadData(dataDiterima.getIsiBerita(), "text/html", "utf-8");
        Picasso.with(this)
                .load(BuildConfig.BASE_URL+"images/"+dataDiterima.getFoto())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.mipmap.ic_launcher)
                .into(tvBerita);
    }




}
