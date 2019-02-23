package com.eno.userss.portalberita.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eno.userss.portalberita.BuildConfig;
import com.eno.userss.portalberita.Detail.BeritaDetail;
import com.eno.userss.portalberita.Model.BeritaItem;
import com.eno.userss.portalberita.Model.BeritaItemPL;
import com.eno.userss.portalberita.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {

    private Context context;
    private List<BeritaItem> dataBerita;


    public List<BeritaItem> getDataBerita() {
        return dataBerita;
    }

    public void setDataBerita(List<BeritaItem> dataBerita) {
        this.dataBerita = dataBerita;
    }

    public  BeritaAdapter(Context context, List<BeritaItem> dataBerita){
        this.context = context;
        this.dataBerita = dataBerita;


    }
    @NonNull
    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita, parent, false);
        BeritaAdapter.ViewHolder holder = new BeritaAdapter.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.ViewHolder holder, final int position) {
        holder.judul.setText(dataBerita.get(position).getJudulBerita());
        holder.penulis.setText(dataBerita.get(position).getPenulis());
        holder.tgl.setText(dataBerita.get(position).getTanggalPosting());

        Picasso.with(context)
                .load(BuildConfig.BASE_URL + "images/" + dataBerita.get(position).getFoto())
                .error(R.mipmap.ic_launcher)
                .into(holder.img);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, BeritaDetail.class);
//                intent.putExtra("Judul", dataBerita.get(position).getJudulBerita());
//                intent.putExtra("Penulis", dataBerita.get(position).getPenulis());
//                intent.putExtra("Tanggal", dataBerita.get(position).getTanggalPosting());
//                intent.putExtra("Image", dataBerita.get(position).getFoto());
//                intent.putExtra("Detail", dataBerita.get(position).getIsiBerita());
//                context.startActivity(intent);

                BeritaItemPL data = new BeritaItemPL(
                        dataBerita.get(position).getPenulis(),
                        dataBerita.get(position).getFoto(),
                        dataBerita.get(position).getId(),
                        dataBerita.get(position).getJudulBerita(),
                        dataBerita.get(position).getTanggalPosting(),
                        dataBerita.get(position).getIsiBerita());
                Intent intent = new Intent(context, BeritaDetail.class);
                intent.putExtra("data", data);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBerita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul,penulis,tgl;
        ImageView img;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.tv_berita);
            judul = (TextView)itemView.findViewById(R.id.tv_judul_berita);
            penulis = (TextView)itemView.findViewById(R.id.tv_penulis);
            tgl = (TextView)itemView.findViewById(R.id.tv_tanggal_posting);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
