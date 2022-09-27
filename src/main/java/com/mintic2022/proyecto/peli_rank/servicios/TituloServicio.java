package com.mintic2022.proyecto.peli_rank.servicios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mintic2022.proyecto.peli_rank.modelo.Titulo;

public class TituloServicio {
    
    SessionFactory factory;

    public TituloServicio(){
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Titulo.class)
        .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public String create(Titulo titulo){
        String message = "";
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.persist(titulo);
            session.getTransaction().commit();
            message = "Titulo creado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }

    public void update(Titulo titulo) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        // Realziar actualización en la BD
        session.merge(titulo);
        session.getTransaction().commit();
        session.close();
    }

    public Titulo obtenerTituloxId(int idTitulos) throws Exception {
        
        Session session = createSession();
        Titulo titulo = session.find(Titulo.class, idTitulos);

        session.close();

        return titulo;
    }

    public void updateValoracion(int idTitulos,Double valoracion) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        // Realziar actualización en la BD
        Titulo titulo = obtenerTituloxId(idTitulos);
        titulo.setValoracion(valoracion);
        session.merge(titulo);
        session.getTransaction().commit();
        session.close();
    }

    public String delete(int id) {
        //Session session = createSession();
        //Titulo titulo = session.find(Titulo.class, id);
        Titulo titulo = new Titulo();
        titulo.setIdTitulo(id);
        deleteService(titulo);
        return "Titulo eliminado con exito";
    }

    public void deleteService(Titulo titulo) {
        Session session = createSession();
        // Eliminar
        session.remove(titulo);
        session.getTransaction().commit();
    }

    public List<Titulo> getList() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Titulo> titulos = session.createQuery("from Titulo", Titulo.class).list();
        session.close();
        return titulos;
    }

}
