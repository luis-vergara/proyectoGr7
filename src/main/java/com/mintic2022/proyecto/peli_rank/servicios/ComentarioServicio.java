package com.mintic2022.proyecto.peli_rank.servicios;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mintic2022.proyecto.peli_rank.modelo.Comentario;
import com.mintic2022.proyecto.peli_rank.modelo.Titulo;
import com.mintic2022.proyecto.peli_rank.modelo.Usuario;

public class ComentarioServicio {

    SessionFactory factory;

    public ComentarioServicio(){
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Comentario.class)
        .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public String create(int idUsuario, int idTitulo, String comentarioUsuario, Integer valoracion){
        String message = "";
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            Usuario usuario = session.find(Usuario.class, idUsuario);
            Titulo titulo = session.find(Titulo.class, idTitulo);
            Comentario comentario = new Comentario();
            comentario.setUsuario(usuario);
            comentario.setTitulo(titulo);
            comentario.setValoracion(valoracion);
            comentario.setComentario(comentarioUsuario);
            comentario.setFecha(new Date());
            session.persist(comentario);
            session.getTransaction().commit();
            updateValoracion(idTitulo);
            message = "Comentario creado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }

    public void update(Comentario comentario) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        // Realziar actualización en la BD
        session.merge(comentario);
        session.getTransaction().commit();
        session.close();
    }

    public String delete(int id) {
        //Session session = createSession();
        //Comentario comentario = session.find(Comentario.class, id);
        Comentario comentario = new Comentario();
        comentario.setIdComentario(id);
        deleteService(comentario);
        return "Comentario eliminado con exito";
    }

    public void deleteService(Comentario comentario) {
        Session session = createSession();
        // Eliminar
        session.remove(comentario);
        session.getTransaction().commit();
    }

    public String updateValoracion(int idTitulo){
        String message = "";
        double sumaValor = 0.0;
        double promedio = 0.0;
        Session session = createSession();
        try {

            List<Comentario> objComentarios = session.createNativeQuery("select * from comentario where idTitulo2 = :n", Comentario.class)
            .setParameter("n", idTitulo)
            .list();
            if (objComentarios.size() > 0){

                for (int i=0; i < objComentarios.size(); i++){

                    sumaValor += objComentarios.get(i).getValoracion();
    
                }
    
                promedio = sumaValor/objComentarios.size();
                promedio = Math.round(promedio * 10) / 10d;
            }else{

                promedio = 0.0;
                
            }
            

            TituloServicio tituloServicio = new TituloServicio();
            tituloServicio.updateValoracion(idTitulo,promedio);
            message = "Se actualizó la valoracion con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }

    public List<Comentario> getList() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Comentario> comentarios = session.createQuery("from Comentario", Comentario.class).list();
        session.close();
        return comentarios;
    }
}
