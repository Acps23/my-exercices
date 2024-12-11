const box = document.querySelector("#box");
const container = document.querySelector("#container");

let direction = 1; // 1 para direita, -1 para esquerda
let interval = 10; // Intervalo entre movimentos em ms

function move({ target }) {
  const containerWidth = parseInt(getComputedStyle(container).width);
  const boxWidth = parseInt(getComputedStyle(target).width);
  const actualPosition = parseInt(getComputedStyle(target).left) || 0;

  // Atualiza a posição
  let newPosition = actualPosition + direction;

  // Verifica os limites do container
  if (newPosition + boxWidth >= containerWidth) {
    direction = -1; // Muda a direção para esquerda
  } else if (newPosition <= 0) {
    direction = 1; // Muda a direção para direita
  }

  // Aplica a nova posição
  target.style.left = `${newPosition}px`;

  // Chama novamente o movimento após o intervalo
  setTimeout(() => move({ target }), interval);
}

box.addEventListener("click", (e) => {
  console.log("Start moving...");
  move(e); 
});