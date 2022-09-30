package com.mintic2022.proyecto.peli_rank.vista;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mintic2022.proyecto.peli_rank.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mintic2022.proyecto.peli_rank.modelo.Usuario;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/login")
public class AuthControllers {
    private UsuarioServicio usuarioServicio;
    public AuthControllers(){
        this.usuarioServicio= new UsuarioServicio();
    }
    @PostMapping
    @CrossOrigin("*")
    public  String login(@RequestBody Usuario usuario){
        if(usuarioServicio.verificarCredencial(usuario)){
            return "Ok";
        }else{
            return "False";
        }
    }
    
    
}
