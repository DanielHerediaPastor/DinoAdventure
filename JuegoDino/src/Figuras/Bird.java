package Figuras;

import java.awt.*;

/**
 * Clase que representa el personaje Bird en el juego.
 */
public class Bird extends Personaje {

    /**
     * Constructor que inicializa las propiedades del Bird.
     *
     * @param x Coordenada X inicial del Bird.
     * @param y Coordenada Y inicial del Bird.
     */
    public Bird(int x, int y) {
        super(x, y, 50, 70); // Tamaño del Bird (50x70)
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.RED); // Color rojo para el Bird
        g.fillRect(getX(), getY(), ancho, alto);
    }
}
