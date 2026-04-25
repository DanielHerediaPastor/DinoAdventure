package Figuras;

import java.awt.*;

/**
 * Clase abstracta que define las propiedades y comportamientos comunes de un personaje.
 */
public abstract class Personaje {
    protected int x, y;       // Posición del personaje
    protected final int ancho; // Ancho del personaje
    protected final int alto;  // Alto del personaje

    /**
     * Constructor para inicializar las propiedades de un personaje.
     *
     * @param x Coordenada X inicial del personaje.
     * @param y Coordenada Y inicial del personaje.
     * @param ancho Ancho del personaje.
     * @param alto Alto del personaje.
     */
    public Personaje(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
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

    /**
     * Método abstracto para dibujar el personaje.
     *
     * @param g Objeto Graphics para realizar el dibujo.
     */
    public abstract void dibujar(Graphics g);

    /**
     * Obtiene un rectángulo que representa el área del personaje para detección de colisiones.
     *
     * @return Un objeto Rectangle que delimita el personaje.
     */
    public Rectangle getRectangulo() {
        return new Rectangle(x, y, ancho, alto);
    }
}
