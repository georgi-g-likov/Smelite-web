document.addEventListener('DOMContentLoaded', () => {
  const decors = document.querySelectorAll('.decor');
  decors.forEach((decor, i) => {
    setTimeout(() => {
      decor.classList.add('show');
    }, 500 + i * 400); // Първият се появява след 0.5s, останалите през 0.4s
  });
});
