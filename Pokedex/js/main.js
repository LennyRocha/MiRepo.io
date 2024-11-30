const listaPokemon = document.querySelector("#pokemonList");
let URL = "https://pokeapi.co/api/v2/pokemon/";
const btnHeaders = document.querySelectorAll(".btn-header");

for(let i = 1; i <= 151; i++){
    fetch(URL+i)
        .then((response) => response.json())
        .then((data) => getAllPokemon(data))
}

function getAllPokemon(pok){

    let tipos = pok.types.map((type) =>
        `<p class="tipo ${type.type.name} badge">${type.type.name}</p>`
    );
    tipos = tipos.join('');

    let pokeId = pok.id.toString();
    if(pokeId.length === 1){
       pokeId = "00"+pokeId; 
    }
    if(pokeId.length === 2){
        pokeId = "0"+pokeId; 
    }
    console.log(pokeId);

    const div = document.createElement("div");
    div.setAttribute("class","pokemon");
    div.innerHTML=`<p class="pokemon-id-back">#${pokeId}</p>
        <div class="pokemon-imagen">
          <img src="${pok.sprites.other["official-artwork"].front_default}" alt="${pok.name}">
        </div>
        <div class="pokemon-info">
          <div class="nombre-contenedor">
            <p class="pokemon-id">#${pokeId}</p>
            <h2 class="nombre-pokemon">${pok.name}</h2>
          </div>
          <div class="pokemon-tipos">
            ${tipos}
          </div>
          <div class="pokemon-stats">
            <p class="stat">${pok.height}m</p>
            <p class="stat">${pok.weight}kg</p>
          </div>
        </div>`;
        listaPokemon.append(div);
}

document.getElementById("Buscar").addEventListener("click", async () => {
    let nombre_pok = document.getElementById("buscarPok").value;
    console.log(nombre_pok);

    await fetch(URL+nombre_pok.toLowerCase())
        .then(async (response) => await response.json())
        .then((data) => {
          console.log(data);
          if(data === undefined){
            Swal.fire({
              icon: "error",
              title: "Oops...",
              text: "Something went wrong!",
            });
          }else{
            listaPokemon.innerHTML = "";
            getAllPokemon(data);
          }
        })
        .catch((error) => {
          Swal.fire({
            icon: "error",
            title: "404",
            text: "¡No se encontró al pokemon!",
            confirmButtonText: "Reintentar"
          });
          console.error(error);
        })
});

document.getElementById("Borrar").addEventListener("click",  () => {
    document.getElementById("buscarPok").value = "";
});

btnHeaders.forEach(boton => boton.addEventListener("click", (event) => {
  const botonId = event.currentTarget.id;

  listaPokemon.innerHTML = "";

  for(let i = 1; i <= 151; i++){
    fetch(URL+i)
        .then((response) => response.json())
        .then((data) => {

          if(botonId === "ver_todos"){
            getAllPokemon(data);
          }else{
            console.log(data.types.map(type => type.type.name));
            const tipos = data.types.map(type => type.type.name);
            if(tipos.some(tipo => tipo.includes(botonId))){
              getAllPokemon(data);
            }
          }
        })
}
}));

/*
fetch(URL+nombre_pok.toLowerCase())
        .then((response) => {
          if(response.status === 404){
            Swal.fire({
              icon: "error",
              title: "404",
              text: "¡Pokemon no encontrado!",
              confirmButtonText: "Aceptar"
            });
            return null;
          }
          response.json()
        })
        .then((data) => {
          console.log(data);
          if(data === null){
            Swal.fire({
              icon: "error",
              title: "Oops...",
              text: "Something went wrong!",
            });
          }else{
            listaPokemon.innerHTML = "";
            getAllPokemon(data);
          }
        })
      .catch((error) => {
        Swal.fire({
          icon: "error",
          title: "500",
          text: "¡Algo salió mal, intentalo nuevamente!",
          confirmButtonText: "OK"
        });
        console.err(error);
      });


<div class="pokemon">
        <p class="pokemon-id-back">#025</p>
        <div class="pokemon-imagen">
          <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png" alt="Pikachu">
        </div>
        <div class="pokemon-info">
          <div class="nombre-contenedor">
            <p class="pokemon-id">#025</p>
            <h2 class="nombre-pokemon">Pikachu</h2>
          </div>
          <div class="pokemon-tipos">
            <p class="tipo electric badge">Electric</p>
            <p class="tipo fighting badge">Fighting</p>
          </div>
          <div class="pokemon-stats">
            <p class="stat">40cm</p>
            <p class="stat">61kg</p>
          </div>
        </div>
      </div>
 */