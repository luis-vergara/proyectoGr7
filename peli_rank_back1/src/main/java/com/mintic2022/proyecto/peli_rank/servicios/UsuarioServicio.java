package com.mintic2022.proyecto.peli_rank.servicios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mintic2022.proyecto.peli_rank.modelo.Usuario;

public class UsuarioServicio {
    
    SessionFactory factory;

    public UsuarioServicio(){
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public String create(Usuario usuario){
        String message = "";
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.persist(usuario);
            session.getTransaction().commit();
            message = "Usuario creado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        session.close();
        return message;
    }

    public void update(Usuario usuario) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        // Realziar actualización en la BD
        session.merge(usuario);
        session.getTransaction().commit();
        session.close();
    }

    public String delete(int id) {
        //Session session = createSession();
        //Usuario usuario = session.find(Usuario.class, id);
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        deleteService(usuario);
        return "Usuario eliminado con exito";
    }

    public void deleteService(Usuario usuario) {
        Session session = createSession();
        // Eliminar
        session.remove(usuario);
        session.getTransaction().commit();
    }

    public List<Usuario> getList() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Usuario> usuarios = session.createQuery("from Usuario", Usuario.class).list();
        session.close();
        return usuarios;
    }
    public boolean  verificarCredencial(Usuario usuario){
        Session session = createSession();
        List<Usuario> query = session.createNativeQuery("select * from usuario where Nickname =:nickname AND Contrasena =:contrasena",Usuario.class)
                .setParameter("nickname",usuario.getNickname())
                .setParameter("contrasena",usuario.getContrasena()).getResultList();
        return !query.isEmpty();
    }

    public List<Usuario> getListUsername(String nickname) throws Exception{

        Session session = createSession();
        List<Usuario> objUsuarios = session.createNativeQuery("select * from usuario where Nickname = :n ",Usuario.class)
        .setParameter("n", nickname)
        .list();
        session.close();
        return objUsuarios;

    }

}
