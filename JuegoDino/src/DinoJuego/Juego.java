package DinoJuego;

import Figuras.Bird;
import Figuras.Cactus;
import Figuras.Dino;
import Figuras.Hurraca;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el panel principal del juego.
 */
public class Juego extends JPanel {
    private String character;
    private Escena escena;
    private Dino dino;
    private Bird bird;
    private boolean saltoEnCurso = false;
    private int velocidadSalto = 13;
    private final int gravedad = 5;
    private final int alturaMaximaSalto = 250;
    private final int alturaMinimaBird = 250;
    private boolean gameOver = false;
    private Image fondoImage;

    /**
     * Constructor que inicializa el panel del juego con el personaje seleccionado.
     *
     * @param character Nombre del personaje (Dino o Bird).
     */
    public Juego(String character) {
        this.character = character;
        fondoImage = new ImageIcon("Resources/BACKGROUND 2.jpg").getImage();
        escena = new Escena();
        setPreferredSize(new Dimension(1920, 1080));
        setBackground(Color.GRAY);

        if ("Dino".equals(character)) {
            dino = new Dino(100, 525);
        } else if ("Bird".equals(character)) {
            bird = new Bird(100, 250);
        }
    }

    /**
     * Inicia el salto del personaje.
     */
    public void iniciarSalto() {
        if (!saltoEnCurso && !gameOver) {
            saltoEnCurso = true;
            System.out.println("Salto iniciado desde Juego");
        }
    }

    /**
     * Detecta colisiones entre el personaje y los obstáculos.
     *
     * @return true si se detecta una colisión; false en caso contrario.
     */
    private boolean detectarColision() {
        if ("Dino".equals(character) && dino != null) {
            for (Cactus cactus : escena.getCactusList()) {
                if (dino.getRectangulo().intersects(cactus.getRectangulo())) {
                    return true;
                }
            }
            for (Hurraca hurraca : escena.getHurracaList()) {
                if (dino.getRectangulo().intersects(hurraca.getRectangulo())) {
                    return true;
                }
            }
        } else if ("Bird".equals(character) && bird != null) {
            for (Cactus cactus : escena.getCactusList()) {
                if (bird.getRectangulo().intersects(cactus.getRectangulo())) {
                    return true;
                }
            }
            for (Hurraca hurraca : escena.getHurracaList()) {
                if (bird.getRectangulo().intersects(hurraca.getRectangulo())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Maneja la lógica del salto del personaje Dino.
     */
    private void manejarSaltoDino() {
        if (saltoEnCurso) {
            if (dino.getY() > alturaMaximaSalto) {
                dino.setY(dino.getY() - velocidadSalto);
            } else {
                saltoEnCurso = false;
            }
        }

        if (!saltoEnCurso && dino.getY() < 525) {
            dino.setY(dino.getY() + gravedad);
        }
    }

    /**
     * Maneja el movimiento del personaje Bird.
     */
    private void manejarMovimientoBird() {
        if (saltoEnCurso) {
            if (bird.getY() < 495) {
                bird.setY(bird.getY() + velocidadSalto);
            } else {
                saltoEnCurso = false;
            }
        }

        if (!saltoEnCurso && bird.getY() > alturaMinimaBird) {
            bird.setY(bird.getY() - gravedad);
        }
    }

    /**
     * Inicia el bucle principal del juego.
     */
    public void startGame() {
        new Timer(16, e -> {
            if (!gameOver) {
                escena.actualizar();
                if ("Dino".equals(character) && dino != null) {
                    manejarSaltoDino();
                } else if ("Bird".equals(character) && bird != null) {
                    manejarMovimientoBird();
                }
                if (detectarColision()) {
                    gameOver = true;
                }
            }
            repaint();
        }).start();
    }

    /**
     * Muestra el mensaje de Game Over en la pantalla.
     *
     * @param g Objeto Graphics para pintar en el panel.
     */
    private void mostrarGameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("GAME OVER", getWidth() / 2 - 150, getHeight() / 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fondoImage != null) {
            g.drawImage(fondoImage, 0, 0, getWidth(), getHeight(), this);
        }

        for (Cactus cactus : escena.getCactusList()) {
            g.setColor(Color.BLUE);
            g.fillRect(cactus.getX(), cactus.getY(), cactus.getAncho(), cactus.getAlto());
        }

        for (Hurraca hurraca : escena.getHurracaList()) {
            g.setColor(Color.RED);
            g.fillRect(hurraca.getX(), hurraca.getY(), hurraca.getAncho(), hurraca.getAlto());
        }

        if ("Dino".equals(character) && dino != null) {
            dino.dibujar(g);
        } else if ("Bird".equals(character) && bird != null) {
            bird.dibujar(g);
        }

        if (gameOver) {
            mostrarGameOver(g);
        }
    }
}
