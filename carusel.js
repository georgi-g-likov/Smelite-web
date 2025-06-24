const track = document.querySelector('.crafts-oval-list');
const items = Array.from(document.querySelectorAll('.crafts-oval-item'));
const leftBtn = document.querySelector('.carousel-arrow.left');
const rightBtn = document.querySelector('.carousel-arrow.right');
let index = 0, visibleCount = 3, isScrolling = false;

function getItemStep() {
  if (items.length < 2) return items[0].offsetWidth;
  return items[1].offsetLeft - items[0].offsetLeft;
}

function updateCarousel() {
  if (isScrolling) return;
  isScrolling = true;
  const itemStep = getItemStep();
  track.scrollTo({ left: index * itemStep }); // разчитаме на CSS
  leftBtn.style.visibility = (index === 0) ? 'hidden' : 'visible';
  rightBtn.style.visibility = (index >= items.length - visibleCount) ? 'hidden' : 'visible';
  setTimeout(() => isScrolling = false, 350);
}

leftBtn.onclick = () => { if (index > 0) { index--; updateCarousel(); } }
rightBtn.onclick = () => { if (index < items.length - visibleCount) { index++; updateCarousel(); } }
updateCarousel();
