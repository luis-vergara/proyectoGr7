package com.mintic2022.proyecto.peli_rank.modelo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "titulo")
public class Titulo {

    //private final static double VALORACION_INICIAL = 0.0;

    
    private int idTitulo;
    private String Titulo;
    private String Genero;
    private String TipoTitulo;
    private String Sinopsis;
    private String URL_Poster;
    private Double Valoracion;

    private Set<Comentario> comentarios = new HashSet<Comentario>();
    
    public Titulo() {

    }

    public Titulo(String titulo, String genero, String tipoTitulo, String sinopsis, String uRL_Poster,
    Double valoracion) {

        Titulo = titulo;
        Genero = genero;
        TipoTitulo = tipoTitulo;
        Sinopsis = sinopsis;
        URL_Poster = uRL_Poster;
        Valoracion = valoracion;

    }

    /*public Titulo(String Titulo, String Genero, String TipoTitulo, String Sinopsis, String URL_Poster) {
        
        this.Titulo = Titulo;
        this.Genero = Genero;
        this.TipoTitulo = TipoTitulo;
        this.Sinopsis = Sinopsis;
        this.URL_Poster = URL_Poster;
        this.Valoracion = VALORACION_INICIAL;

    }*/

    @Override
    public String toString(){
        
        String info = "----------------------------\n";
        info += "Id: " + idTitulo;
        info += "\nTitulo: " + Titulo;
        info += "\nGenero: " + Genero;
        info += "\nTipoTitulo: " + TipoTitulo;
        info += "\nSinopsis: " + Sinopsis;
        info += "\nURL_Poster: " + URL_Poster;
        info += "\nValoracion: " + Valoracion;
        info += "\n----------------------------\n";

    return info;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTitulo")
    public int getIdTitulo() {
        return idTitulo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getGenero() {
        return Genero;
    }

    public String getTipoTitulo() {
        return TipoTitulo;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public String getURL_Poster() {
        return URL_Poster;
    }

    public Double getValoracion() {
        return Valoracion;
    }

    public void setIdTitulo(int idTitulo) {
        this.idTitulo = idTitulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public void setTipoTitulo(String tipoTitulo) {
        TipoTitulo = tipoTitulo;
    }

    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }

    public void setURL_Poster(String uRL_Poster) {
        URL_Poster = uRL_Poster;
    }

    public void setValoracion(Double valoracion) {
        Valoracion = valoracion;
    }

    @OneToMany(mappedBy = "titulo")
    @JsonIgnore
    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public void addComentarios(Comentario comentario){
        this.comentarios.add(comentario);
    }

}