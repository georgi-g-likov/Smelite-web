document.addEventListener('mousemove', function(e) {
  const x = (e.clientX / window.innerWidth - 0.5) * 2; // -1 to 1
  const y = (e.clientY / window.innerHeight - 0.5) * 2;
  // Паралакс на кръга
  const bg = document.getElementById('circle-bg');
  if(bg) {
    bg.style.transform = `translateX(-50%) translateY(${y * 30}px) scale(${1 + y * 0.05})`;
  }
  // Паралакс на картите (различен фактор за всяка)
  const cardGreen = document.getElementById('card-green');
  const cardBrown = document.getElementById('card-brown');
  const btnFloat = document.getElementById('btn-float');
  if(cardGreen) {
    cardGreen.style.transform = `translate(${x * 18}px, ${y * 18}px)`;
  }
  if(cardBrown) {
    cardBrown.style.transform = `translate(${x * -12}px, ${y * 12}px)`;
  }
  if(btnFloat) {
    btnFloat.style.transform = `translate(${x * 20}px, ${y * -8}px)`;
  }
});