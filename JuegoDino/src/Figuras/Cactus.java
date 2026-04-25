package Figuras;

import java.awt.Rectangle;

/**
 * Clase que representa un obstáculo de tipo Cactus en el juego.
 */
public class Cactus {
    private int x, y;        // Posición del cactus
    private int ancho, alto; // Tamaño del cactus

    /**
     * Constructor con valores predeterminados de tamaño.
     *
     * @param x Coordenada X del cactus.
     * @param y Coordenada Y del cactus.
     */
    public Cactus(int x, int y) {
        this(x, y, 50, 100); // Ancho: 50, Alto: 100
    }

    /**
     * Constructor completo para personalizar el tamaño del cactus.
     *
     * @param x Coordenada X del cactus.
     * @param y Coordenada Y del cactus.
     * @param ancho Ancho del cactus.
     * @param alto Alto del cactus.
     */
    public Cactus(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    // Métodos getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    /**
     * Mueve el cactus hacia la izquierda.
     *
     * @param velocidad Velocidad del movimiento.
     */
    public void mover(int velocidad) {
        x -= velocidad; // Mueve hacia la izquierda
        if (x + ancho < 0) { // Si sale de la pantalla, reaparece al final
            x = 1920;
        }
    }

    /**
     * Obtiene un rectángulo que representa el área del cactus, para detección de colisiones.
     *
     * @return Un objeto Rectangle que delimita el cactus.
     */
    public Rectangle getRectangulo() {
        return new Rectangle(x, y, ancho, alto);
    }
}
