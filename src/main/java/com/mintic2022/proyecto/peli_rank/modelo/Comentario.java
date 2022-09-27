package com.mintic2022.proyecto.peli_rank.modelo;

//import java.sql.Timestamp;
//import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "comentario")
public class Comentario {

    private int idComentario;
    private String Comentario;
    private int Valoracion;
    private Date Fecha;

    private Usuario usuario;
    private Titulo titulo;

    /*public Comentario() {

    }

    public Comentario(Usuario usuario, Titulo titulo, String comentario, int valoracion, Date fecha) {
        this.usuario = usuario;
        this.titulo = titulo;
        Comentario = comentario;
        Valoracion = valoracion;
        Fecha = fecha;
    }*/

    @Override
    public String toString() {

        String info = "----------------------------\n";
        info += "IdComentario: " + idComentario;
        info += "\nComentario: " + Comentario;
        info += "\nValoracion: " + Valoracion;
        info += "\nFecha: " + Fecha;
        info += "\n----------------------------\n";

        return info;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComentario")
    public int getIdComentario() {
        return idComentario;
    }

    public String getComentario() {
        return Comentario;
    }

    public int getValoracion() {
        return Valoracion;
    }

    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    public Date getFecha() {
        return Fecha;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario2")
    public Usuario getUsuario() {
        return usuario;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTitulo2")
    public Titulo getTitulo() {
        return titulo;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public void setValoracion(int valoracion) {
        Valoracion = valoracion;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }












}
