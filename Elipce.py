import pygame
import sys

# Inisialisasi Pygame
pygame.init()

# Lebar dan tinggi layar
screen_width = 800
screen_height = 600

# Membuat layar
screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption("Membuat Elips dengan Mouse")

# Warna
white = (255, 255, 255)

# Koordinat titik awal elips
center_x = 0
center_y = 0

# Loop utama
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        elif event.type == pygame.MOUSEBUTTONDOWN:
            # Mendapatkan koordinat titik awal elips saat tombol mouse ditekan
            center_x, center_y = pygame.mouse.get_pos()
        elif event.type == pygame.MOUSEMOTION:
            if event.buttons[0]:  # Tombol mouse kiri ditekan
                # Mendapatkan koordinat saat ini saat mouse digerakkan
                current_x, current_y = pygame.mouse.get_pos()

                # Menghitung jarak antara titik awal dan titik saat ini
                distance_x = current_x - center_x
                distance_y = current_y - center_y

                # Menghitung jari-jari horizontal dan vertikal elips
                radius_x = abs(distance_x) // 2
                radius_y = abs(distance_y) // 2

                # Gambar latar belakang layar dengan warna putih
                screen.fill(white)

                # Gambar elips pada layar
                pygame.draw.ellipse(screen, (255, 0, 0), (center_x, center_y, radius_x, radius_y))

    # Update tampilan
    pygame.display.update()
