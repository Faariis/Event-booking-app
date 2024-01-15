package com.projekat.dogadjaji_196.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Dogadjaj implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String naziv;
    private String opis;
    private String lokacija;
    private String datumOdrzavanja;
    private String imageUrl;

    private String kodDogadjaja;

    public Dogadjaj() {}

    public Dogadjaj(String naziv, String opis, String lokacija, String datumOdrzavanja, String imageUrl, String kodDogadjaja)
    {
        this.naziv = naziv;
        this.opis = opis;
        this.lokacija = lokacija;
        this.datumOdrzavanja = datumOdrzavanja;
        this.imageUrl = imageUrl;
        this.kodDogadjaja = kodDogadjaja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(String datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getKodDogadjaja() {
        return kodDogadjaja;
    }

    public void setKodDogadjaja(String kodDogadjaja) {
        this.kodDogadjaja = kodDogadjaja;
    }


    @Override
    public String toString()
    {
        return "Dogadjaj{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", lokacija='" + lokacija + '\'' +
                ", datumOdrzavanja=" + datumOdrzavanja + '\'' +
                ", imageUrl=" + imageUrl + '\'' +
                ", kodDogdjaja" + kodDogadjaja + '\'' +
                '}';
    }
}
