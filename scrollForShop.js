window.addEventListener('scroll', function() {
  const shopBg = document.querySelector('.shop-bg');
  if (!shopBg) return;
  const shopSection = document.querySelector('.shop');
  const rect = shopSection.getBoundingClientRect();
  const windowHeight = window.innerHeight || document.documentElement.clientHeight;

  let progress = (windowHeight - rect.top) / (windowHeight + rect.height);
  progress = Math.max(0, Math.min(1, progress));

  // Скалата: от 2.5 (fullscreen) до 0.6 (малко кръгче)
  const scale = 2.5 - (progress * 1.9); // 2.5 -> 0.6
  // Малко движение по Y (примерно до 80px)
  const y = progress * 80;
  shopBg.style.transform = `translateX(-50%) translateY(${-y}px) scale(${scale})`;
});

// При зареждане:
document.querySelector('.shop-bg').style.transform = 'translateX(-50%) scale(2.5)';
