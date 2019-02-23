package com.eno.userss.portalberita.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class BeritaItemPL implements Parcelable {
        private String penulis;
        private String foto;
        private String id;
        private String judulBerita;
        private String tanggalPosting;
        private String isiBerita;

        public BeritaItemPL() {
        }

        public BeritaItemPL(String penulis, String foto, String id, String judulBerita, String tanggalPosting, String isiBerita) {
            this.penulis = penulis;
            this.foto = foto;
            this.id = id;
            this.judulBerita = judulBerita;
            this.tanggalPosting = tanggalPosting;
            this.isiBerita = isiBerita;
        }

        public String getPenulis() {
            return penulis;
        }

        public void setPenulis(String penulis) {
            this.penulis = penulis;
        }

        public String getFoto() {
            return foto;
        }

        public void setFoto(String foto) {
            this.foto = foto;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJudulBerita() {
            return judulBerita;
        }

        public void setJudulBerita(String judulBerita) {
            this.judulBerita = judulBerita;
        }

        public String getTanggalPosting() {
            return tanggalPosting;
        }

        public void setTanggalPosting(String tanggalPosting) {
            this.tanggalPosting = tanggalPosting;
        }

        public String getIsiBerita() {
            return isiBerita;
        }

        public void setIsiBerita(String isiBerita) {
            this.isiBerita = isiBerita;
        }

        protected BeritaItemPL(Parcel in) {
            penulis = in.readString();
            foto = in.readString();
            id = in.readString();
            judulBerita = in.readString();
            tanggalPosting = in.readString();
            isiBerita = in.readString();
        }

        public static final Creator<BeritaItemPL> CREATOR = new Creator<BeritaItemPL>() {
            @Override
            public BeritaItemPL createFromParcel(Parcel in) {
                return new BeritaItemPL(in);
            }

            @Override
            public BeritaItemPL[] newArray(int size) {
                return new BeritaItemPL[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

            dest.writeString(penulis);
            dest.writeString(foto);
            dest.writeString(id);
            dest.writeString(judulBerita);
            dest.writeString(tanggalPosting);
            dest.writeString(isiBerita);
        }

        // Cukup sesuaikan nama objeknya
        public static final Parcelable.Creator<BeritaItemPL> CREATORPL = new Parcelable.Creator<BeritaItemPL>() {
            @Override
            public BeritaItemPL createFromParcel(Parcel source) {
                return new BeritaItemPL(source);
            }

            @Override
            public BeritaItemPL[] newArray(int size) {
                return new BeritaItemPL[size];
            }
        };
    }

