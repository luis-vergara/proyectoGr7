const URL_API_TITULO = "http://localhost:8080/titulos"
const URL_API_TITULONOMBRE = "http://localhost:8080/titulos/nombre?nombre="
let NICKNAME= ""

async function get_titulos () {
  // Enviar petición
  const resp = await fetch(URL_API_TITULO)
  // Obtener datos de la petición
  const titulos = await resp.json()
  return titulos
}

function entrarTitulo(){
  // Indicar por medio del evento que no recargue pagina
  const bPelicula = document.getElementById("entrarT").value
  
  getNombreTitulo(bPelicula)
  
  }

function entrarTitulo1(){
  // Indicar por medio del evento que no recargue pagina
  const bPelicula = document.getElementById("id1").value
  
  getNombreTitulo(bPelicula)
  
  }

  
function entrarTitulo2(){
  // Indicar por medio del evento que no recargue pagina
  const bPelicula = document.getElementById("id2").value
  
  getNombreTitulo(bPelicula)
  
  }

function entrarTitulo3(){
  // Indicar por medio del evento que no recargue pagina
  const bPelicula = document.getElementById("id3").value
  console.log(bPelicula)
  
  getNombreTitulo(bPelicula)
  
  }

function show (titulos) {
  const divbody = document.getElementById("imatitulos")
  let cont_titulos =`<div class="container_title">Nuestro Catálogo</div>
                <div class="container_cent">
                  <div class="flechaizp">🡸</div>`
  // Iterar titulos
  for (let i = 0; i < 3; i++) {
    const obj = titulos[i]
    cont_titulos += `
      <div class="central0${i+1}">
        <div class="_container${i+1}">
          <div class="con0${i+1}img" style="background-image:url(${obj.url_Poster});></div>
          <div class="con0${i+1}txt" id="id${i+1}" onclick="entrarTitulo${i+1}()">${obj.titulo}</div>
        </div>
      </div>
    `
  }
  cont_titulos += `
            <div class="flechader">🡺</div>
          </div>
    `
    divbody.innerHTML = cont_titulos
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

async function main () {
  const titulos = await get_titulos()
  const search = window.location.search
  const url = new URLSearchParams(search)
  const param_nickname = url.get("usuario")
  setUsuario(param_nickname)
  save_usuario (param_nickname)
  show(titulos)

}

main()