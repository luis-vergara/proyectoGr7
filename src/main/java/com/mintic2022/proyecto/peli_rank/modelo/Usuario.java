package com.mintic2022.proyecto.peli_rank.modelo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    private int idUsuario;
    private String Nombre;
    private String Apellido;
    private String Email;
    private String Pais;
    private String Nickname;
    private String Contrasena;

    private Set<Comentario> comentarios = new HashSet<Comentario>();

    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String email, String pais, String nickname, String contrasena) {
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Pais = pais;
        Nickname = nickname;
        Contrasena = contrasena;
    }

    /*@Override
    public String toString() {

        String info = "----------------------------\n";

        info += "Id: " + idUsuario;
        info += "\nNombre: " + Nombre;
        info += "\nApellido: " + Apellido;
        info += "\nEmail: " + Email;
        info += "\nPais: " + Pais;
        info += "\nNickname: " + Nickname;
        info += "\nContraseña: " + Contrasena;
        info += "\n----------------------------\n";

        return info;
    }*/

    public void addTitulo(Comentario titulo){
        this.comentarios.add(titulo);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getEmail() {
        return Email;
    }

    public String getPais() {
        return Pais;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPais(String pais) {
        Pais = pais;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    @OneToMany(mappedBy = "usuario")
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
