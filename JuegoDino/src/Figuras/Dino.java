package Figuras;

import java.awt.*;

/**
 * Clase que representa el personaje Dino en el juego.
 */
public class Dino extends Personaje {

    /**
     * Constructor que inicializa las propiedades del Dino.
     *
     * @param x Coordenada X inicial del Dino.
     * @param y Coordenada Y inicial del Dino.
     */
    public Dino(int x, int y) {
        super(x, y, 50, 50); // Tamaño del Dino (50x50)
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.GREEN); // Color verde para el Dino
        g.fillRect(getX(), getY(), ancho, alto);
    }
}
