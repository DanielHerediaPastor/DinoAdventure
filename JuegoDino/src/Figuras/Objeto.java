package Figuras;

import java.awt.*;

/**
 * Clase que representa un objeto genérico en el juego.
 */
public class Objeto {
    private int x, y;          // Posición del objeto
    private int ancho, alto;   // Dimensiones del objeto
    private Color color;       // Color del objeto

    /**
     * Constructor que inicializa las propiedades del objeto.
     *
     * @param x Coordenada X inicial del objeto.
     * @param y Coordenada Y inicial del objeto.
     * @param ancho Ancho del objeto.
     * @param alto Alto del objeto.
     * @param color Color del objeto.
     */
    public Objeto(int x, int y, int ancho, int alto, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    // Métodos getter y setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Método para dibujar el objeto en pantalla.
     *
     * @param g Objeto Graphics para realizar el dibujo.
     */
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);
    }

    /**
     * Método para mover el objeto hacia la izquierda.
     *
     * @param velocidad Velocidad con la que se mueve el objeto.
     */
    public void mover(int velocidad) {
        x -= velocidad;
        if (x + ancho < 0) { // Si sale de la pantalla, reaparece
            x = 1920; // Puedes modificar esta coordenada según el ancho de la pantalla.
        }
    }

    /**
     * Obtiene un rectángulo que representa el área del objeto para detección de colisiones.
     *
     * @return Un objeto Rectangle que delimita el objeto.
     */
    public Rectangle getRectangulo() {
        return new Rectangle(x, y, ancho, alto);
    }
}
