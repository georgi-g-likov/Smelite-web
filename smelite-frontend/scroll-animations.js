
document.addEventListener("DOMContentLoaded", function () {
  const fadeElements = document.querySelectorAll('.fade-in, .fade-left, .fade-right');

  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add('visible');
        observer.unobserve(entry.target);
      }
    });
  }, {
    threshold: 0.1
  });

  fadeElements.forEach(el => observer.observe(el));
});
