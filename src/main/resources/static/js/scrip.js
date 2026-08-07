const API_DRAGONBALL = 'http://localhost:8080/api/characters';

const fighter1Options = document.getElementById('fighter1Options');
const fighter2Options = document.getElementById('fighter2Options');
const fighter1ScrollUp = document.getElementById('fighter1ScrollUp');
const fighter1ScrollDown = document.getElementById('fighter1ScrollDown');
const fighter2ScrollUp = document.getElementById('fighter2ScrollUp');
const fighter2ScrollDown = document.getElementById('fighter2ScrollDown');
const fighter1PageIndicator = document.getElementById('fighter1PageIndicator');
const fighter2PageIndicator = document.getElementById('fighter2PageIndicator');
const fighter1Image = document.getElementById('fighter1Image');
const fighter2Image = document.getElementById('fighter2Image');
const fighter1Name = document.getElementById('fighter1Name');
const fighter2Name = document.getElementById('fighter2Name');
const fighter1PowerFill = document.getElementById('fighter1PowerFill');
const fighter2PowerFill = document.getElementById('fighter2PowerFill');
const fighter1PowerValue = document.getElementById('fighter1PowerValue');
const fighter2PowerValue = document.getElementById('fighter2PowerValue');
const fighter1Selected = document.getElementById('fighter1Selected');
const fighter2Selected = document.getElementById('fighter2Selected');
const fightButton = document.getElementById('fightButton');
const resultDiv = document.getElementById('result');

let characters = [];
let selectedFighter1 = null;
let selectedFighter2 = null;
let maxPower = 1; // para calcular el % de la barra de poder

// ---------- Manejo de imágenes ----------

const PLACEHOLDER_IMAGE = 'images/logo.png';

// Archivos de personajes disponibles en /images
const CHARACTER_IMAGE_FILES = [
    'Android_16.png', 'Android_17.png', 'Android_18.png', 'Android_20.png',
    'Bills.png', 'Broly.png', 'Freezer.png', 'Gogeta.png', 'Gohan.png', 'Goku.png',
    'Gotenks.png', 'Janemba.png', 'Jiren.png', 'Krilin.png', 'Majin_Buu.png',
    'Piccolo.png', 'Raditz.png', 'Tenshinhan.png', 'Trunks.png', 'Vegeta.png',
    'Whis.png', 'Yamcha.png', 'Zarbon.png', 'Zenosama.png'
];

function normalizeName(str) {
    return (str || '')
        .normalize('NFD').replace(/[\u0300-\u036f]/g, '')
        .toLowerCase()
        .replace(/[^a-z0-9]/g, '');
}

const IMAGE_MAP = {};
CHARACTER_IMAGE_FILES.forEach(filename => {
    const key = normalizeName(filename.replace('.png', ''));
    IMAGE_MAP[key] = `images/${filename}`;
});

// Si la base ya trae "imagenUrl" la usa; si no, matchea por nombre contra /images
function resolveImagePath(fighter) {
    if (fighter.imagenUrl && fighter.imagenUrl.trim() !== '') {
        return fighter.imagenUrl;
    }
    const key = normalizeName(fighter.nombre);
    return IMAGE_MAP[key] || PLACEHOLDER_IMAGE;
}

// ---------- Carga de datos ----------

async function fetchData() {
    try {
        const response = await fetch(API_DRAGONBALL);
        characters = await response.json();
        maxPower = Math.max(...characters.map(f => f.energia + f.puntosVida), 1);
    } catch (error) {
        console.error('Error al cargar los personajes:', error);
    }
    loadFighters();
}

const PAGE_SIZE = 5; // cuántos personajes se muestran por página en cada lista
let fighter1Page = 0;
let fighter2Page = 0;

function loadFighters() {
    renderPage('fighter1');
    renderPage('fighter2');
}

// Dibuja solo la "página" actual de personajes (no la lista completa)
function renderPage(playerKey) {
    const isPlayer1 = playerKey === 'fighter1';
    const container = isPlayer1 ? fighter1Options : fighter2Options;
    const page = isPlayer1 ? fighter1Page : fighter2Page;
    const selected = isPlayer1 ? selectedFighter1 : selectedFighter2;
    const upBtn = isPlayer1 ? fighter1ScrollUp : fighter2ScrollUp;
    const downBtn = isPlayer1 ? fighter1ScrollDown : fighter2ScrollDown;
    const indicator = isPlayer1 ? fighter1PageIndicator : fighter2PageIndicator;

    container.innerHTML = '';

    const start = page * PAGE_SIZE;
    const pageItems = characters.slice(start, start + PAGE_SIZE);

    pageItems.forEach(fighter => {
        const option = document.createElement('button');
        option.type = 'button';
        option.className = 'character-option';
        if (selected && selected.id === fighter.id) {
            option.classList.add('is-selected');
        }
        option.innerHTML = `<img class="character-option-thumb" src="${resolveImagePath(fighter)}" alt=""><span>${fighter.nombre}</span>`;
        option.addEventListener('click', () => selectFighter(playerKey, fighter));
        container.appendChild(option);
    });

    // Habilitar/deshabilitar flechas según en qué página estamos
    const totalPages = Math.max(1, Math.ceil(characters.length / PAGE_SIZE));
    upBtn.disabled = page <= 0;
    downBtn.disabled = page >= totalPages - 1;
    indicator.textContent = `${Math.min(page + 1, totalPages)} / ${totalPages}`;
}

// Actualiza imagen grande, nombre y barra de poder al elegir un personaje
function selectFighter(playerKey, fighter) {
    const isPlayer1 = playerKey === 'fighter1';
    const image = isPlayer1 ? fighter1Image : fighter2Image;
    const nameEl = isPlayer1 ? fighter1Name : fighter2Name;
    const fillEl = isPlayer1 ? fighter1PowerFill : fighter2PowerFill;
    const valueEl = isPlayer1 ? fighter1PowerValue : fighter2PowerValue;
    const indicatorEl = isPlayer1 ? fighter1Selected : fighter2Selected;

    if (isPlayer1) {
        selectedFighter1 = fighter;
    } else {
        selectedFighter2 = fighter;
    }

    image.onerror = () => { image.src = PLACEHOLDER_IMAGE; };
    image.src = resolveImagePath(fighter);
    image.classList.add('is-active');

    nameEl.textContent = fighter.nombre;
    const power = fighter.energia + fighter.puntosVida;
    fillEl.style.width = `${Math.min(100, Math.round((power / maxPower) * 100))}%`;
    valueEl.textContent = power;
    indicatorEl.textContent = fighter.nombre;

    renderPage(playerKey); // vuelve a dibujar la página para marcar el nuevo seleccionado
}

// ---------- Pelea ----------

fightButton.addEventListener('click', () => {
    if (!selectedFighter1 || !selectedFighter2) {
        alert('Elegí un personaje para cada jugador.');
        return;
    }

    const power1 = selectedFighter1.energia + selectedFighter1.puntosVida;
    const power2 = selectedFighter2.energia + selectedFighter2.puntosVida;

    let winner;
    if (power1 > power2) {
        winner = selectedFighter1.nombre;
    } else if (power2 > power1) {
        winner = selectedFighter2.nombre;
    } else {
        winner = "¡Empate!";
    }

    resultDiv.textContent = `🏆 El ganador es: ${winner}! 🥊`;
    resultDiv.classList.remove('hidden');
});

// ---------- Flechas: pasar de página en la lista de personajes ----------

fighter1ScrollUp.addEventListener('click', () => {
    if (fighter1Page > 0) {
        fighter1Page--;
        renderPage('fighter1');
    }
});
fighter1ScrollDown.addEventListener('click', () => {
    const totalPages = Math.max(1, Math.ceil(characters.length / PAGE_SIZE));
    if (fighter1Page < totalPages - 1) {
        fighter1Page++;
        renderPage('fighter1');
    }
});
fighter2ScrollUp.addEventListener('click', () => {
    if (fighter2Page > 0) {
        fighter2Page--;
        renderPage('fighter2');
    }
});
fighter2ScrollDown.addEventListener('click', () => {
    const totalPages = Math.max(1, Math.ceil(characters.length / PAGE_SIZE));
    if (fighter2Page < totalPages - 1) {
        fighter2Page++;
        renderPage('fighter2');
    }
});

fetchData();