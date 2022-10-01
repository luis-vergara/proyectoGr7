const URL_API_TITULO = "http://localhost:8080/titulos"
const URL_API_TITULONOMBRE = "http://localhost:8080/titulos/nombre?nombre="
let NICKNAME= ""

function entrarTitulo(){
  // Indicar por medio del evento que no recargue pagina
  const bPelicula = document.getElementById("entrarT").value
  //getNombreTitulo(bPelicula)
  
  getNombreTitulo(bPelicula)
  
  //const form = evt.target
  //    nickname : form.login_usuario.value,
  //    contrasena : form.login_contrasena.value
  }

async function getNombreTitulo(NPelicula,usuario){
  const resp = await fetch(URL_API_TITULONOMBRE+NPelicula)
  // Obtener datos de la petición
  const titulo = await resp.json()
  if (titulo[0] != null){
    window.location.href = `titulo.html?titulo=${titulo[0].titulo}&usuario=${NICKNAME}`
  }
  else{
    alert("La pelicula no existe")
  }

}

  

function show (titulo) {
  const divbody = document.getElementById("nombreT")
    divbody.innerHTML = `<div>${titulo}</div>`
}

function save_usuario (nickname) {
  NICKNAME = nickname
}

/*function update (titulo) {
  window.location.href = `titulo.html?titulo=${JSON.stringify(titulo)}`
}*/

function setUsuario(nickname){
  const nickname_home = document.getElementById("nick")
  nickname_home.innerHTML=nickname
}

async function main () {
  //const titulo = await get_titulos()
  const search = window.location.search
  const url = new URLSearchParams(search)
  const param_titulo = url.get("titulo")
  const param_nickname = url.get("usuario")
  setUsuario(param_nickname)
  console.log(param_titulo)
  save_usuario (param_nickname)
  show(param_titulo)

}

main()