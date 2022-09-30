const URL_API = "http://localhost:8080/usuarios"

function get_data_form(evt){
    // Indicar por medio del evento que no recargue pagina
    evt.preventDefault()
    const form = evt.target
    const usuario ={
        nombre: form.login_nombre.value,
        apellido: form.login_apellido.value,
        pais: form.login_pais.value,
        email : form.login_email.value,
        nickname : form.login_nick.value,
        contrasena : form.login_contrasena.value

    }
    create(usuario)

}

async function create(usuarios){
    const resp= await fetch(URL_API,{
         method:'POST',
         headers:{
             'Content-Type':'application/json'
         },
         body:JSON.stringify(usuarios)
     })
 
     const text = await resp.text()
     alert(text)
     window.location.href = 'login.html'
 }