const URL_API = "http://localhost:8080/login"

function get_data_form(evt){
    // Indicar por medio del evento que no recargue pagina
    evt.preventDefault()
    const form = evt.target
    const usuario ={
        nickname : form.login_usuario.value,
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
     if(text == 'Ok'){
        window.location.href = 'home.html'
     }else{
        alert("Usuario o contraseña es incorrecta")
     }

 }