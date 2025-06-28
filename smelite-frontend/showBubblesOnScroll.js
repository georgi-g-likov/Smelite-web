function showBubblesOnScroll() {
  const bubbles = document.querySelectorAll('.shop-bubble');
  const triggerY = window.innerHeight * 0.9;

  let delay = 0;
  bubbles.forEach((bubble, i) => {
    const rect = bubble.getBoundingClientRect();
    // Виждали ли сме го вече (да не анимира пак)
    if (rect.top < triggerY && !bubble.classList.contains('visible')) {
      setTimeout(() => {
        bubble.classList.add('visible');
      }, delay);
      delay += 220; // 120ms стъпаловидно
    }
    // Ако излезе от екрана — скрий отново (ако искаш да може да се анимира пак)
    else if (rect.top > window.innerHeight) {
      bubble.classList.remove('visible');
    }
  });
}

window.addEventListener('scroll', showBubblesOnScroll);
window.addEventListener('resize', showBubblesOnScroll);
showBubblesOnScroll(); // При load
