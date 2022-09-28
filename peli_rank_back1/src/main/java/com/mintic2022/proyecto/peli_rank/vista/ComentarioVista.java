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

import com.mintic2022.proyecto.peli_rank.modelo.Comentario;
import com.mintic2022.proyecto.peli_rank.servicios.ComentarioServicio;

@RestController
@RequestMapping("/comentarios")
public class ComentarioVista {
    
    private ComentarioServicio servicio;

    public ComentarioVista(){
        this.servicio = new ComentarioServicio();
    }

    @PostMapping("/publicar")
    public String create(@RequestParam int usuario, @RequestParam int titulo, @RequestParam String comentario, @RequestParam int valoracion){
        return servicio.create(usuario, titulo, comentario, valoracion);
      }

    /*@PostMapping("/valoracion")
    public String updateValoracion(@RequestParam int idtitulo){
        return servicio.updateValoracion(idtitulo);
        }*/

    @PutMapping
    public String update(@RequestBody Comentario comentario){

        String message = "";
        try {
            servicio.update(comentario);
            message = "comentario actualizado con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") int id){
        return servicio.delete(id);
    }

    @GetMapping
    public List<Comentario> getList(){
        List<Comentario> comentarios = new ArrayList<>();
        try {
            comentarios = servicio.getList();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return comentarios;
      }

}
