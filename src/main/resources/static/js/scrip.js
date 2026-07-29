const API_DRAGONBALL = 'http://localhost:8081/api/characters';
const fighter1Select = document.getElementById('fighter1');
const fighter2Select = document.getElementById('fighter2');
const fighter1Image = document.getElementById('fighter1Image');
const fighter2Image = document.getElementById('fighter2Image');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');
let peleadores = [];

async function fetchData() {
    try {
        const response = await fetch(API_DRAGONBALL);
        peleadores = await response.json();
    } catch (error) {
        console.error('Error al cargar los personajes:', error);
    }
    loadFighters();
}

function loadFighters() {
    peleadores.forEach(fighter => {
        const option1 = document.createElement('option');
        option1.value = JSON.stringify(fighter);
        option1.text = `${fighter.nombre} (Vida: ${fighter.puntosVida} | Energía: ${fighter.energia})`;
        fighter1Select.appendChild(option1);

        const option2 = document.createElement('option');
        option2.value = JSON.stringify(fighter);
        option2.text = `${fighter.nombre} (Vida: ${fighter.puntosVida} | Energía: ${fighter.energia})`;
        fighter2Select.appendChild(option2);
    });

    // Sin campo de imagen todavía: quedan los placeholders fijos
    fighter1Image.src = 'placeholder1.png';
    fighter2Image.src = 'placeholder2.png';
}

fightButton.addEventListener('click', () => {
    const fighter1 = JSON.parse(fighter1Select.value);
    const fighter2 = JSON.parse(fighter2Select.value);

    if (!fighter1 || !fighter2) {
        alert('Seleccioná ambos luchadores.');
        return;
    }

    // Poder de combate = energía + puntos de vida
    const power1 = fighter1.energia + fighter1.puntosVida;
    const power2 = fighter2.energia + fighter2.puntosVida;

    let winner;
    if (power1 > power2) {
        winner = fighter1.nombre;
    } else if (power2 > power1) {
        winner = fighter2.nombre;
    } else {
        winner = "¡Empate!";
    }

    resultDiv.textContent = `🏆 El ganador es: ${winner}! 🥊`;
    resultDiv.classList.remove('hidden');
});

fetchData();