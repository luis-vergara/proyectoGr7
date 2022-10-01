package com.mintic2022.proyecto.peli_rank.vista;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.mintic2022.proyecto.peli_rank.modelo.Usuario;
import com.mintic2022.proyecto.peli_rank.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioVista {
    
    private UsuarioServicio servicio;

    public UsuarioVista(){
        this.servicio = new UsuarioServicio();
    }

    @PostMapping
    @CrossOrigin("*")
    public String create(@RequestBody Usuario usuario){
        return servicio.create(usuario);
      }

    @PutMapping
    @CrossOrigin("*")
    public String update(@RequestBody Usuario usuario){

        String message = "";
        try {
            servicio.update(usuario);
            message = "usuario actualizado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public String delete(@PathVariable(name = "id") int id){
        return servicio.delete(id);
    }

        

    @GetMapping
    @CrossOrigin("*")
    public List<Usuario> getList(){
        List<Usuario> usuarios = new ArrayList<>();
        try {
          usuarios = servicio.getList();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return usuarios;
      }

    @GetMapping("/nickname")
    @CrossOrigin("*")
    public List<Usuario> getByNickname(@RequestParam String nickname){
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios = servicio.getListUsername(nickname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;

    }
      

}
