package Figuras;

import java.awt.Rectangle;

/**
 * Clase que representa un obstáculo de tipo Hurraca en el juego.
 * Extiende las características de Cactus, pero con dimensiones específicas.
 */
public class Hurraca extends Cactus {
    /**
     * Constructor que inicializa las dimensiones y posición de la Hurraca.
     *
     * @param x Coordenada X de la hurraca.
     * @param y Coordenada Y de la hurraca.
     */
    public Hurraca(int x, int y) {
        super(x, y, 80, 40); // Tamaño específico de la Hurraca
    }

    @Override
    public Rectangle getRectangulo() {
        return new Rectangle(getX(), getY(), getAncho(), getAlto());
    }
}
