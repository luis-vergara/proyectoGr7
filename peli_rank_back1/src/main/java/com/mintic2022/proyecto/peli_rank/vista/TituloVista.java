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
import com.mintic2022.proyecto.peli_rank.modelo.Titulo;
import com.mintic2022.proyecto.peli_rank.servicios.TituloServicio;

@RestController
@RequestMapping("/titulos")
public class TituloVista {

    private TituloServicio servicio;

    public TituloVista(){
        this.servicio = new TituloServicio();
    }

    @PostMapping
    @CrossOrigin("*")
    public String create(@RequestBody Titulo titulo){
        return servicio.create(titulo);
      }

    @PutMapping
    @CrossOrigin("*")
    public String update(@RequestBody Titulo titulo){

        String message = "";
        try {
            servicio.update(titulo);
            message = "titulo actualizado con exito";
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
    public List<Titulo> getList(){
        List<Titulo> titulos = new ArrayList<>();
        try {
          titulos = servicio.getList();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return titulos;
      }
    @GetMapping("/nombre")
    @CrossOrigin("*")
    public List<Titulo> getByNombre(@RequestParam String nombre){
      List<Titulo> titulo = new ArrayList<>();
      try {
          titulo = servicio.getListTitulo(nombre);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return titulo;

  }
    
}
