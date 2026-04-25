package DinoJuego;

import Figuras.Cactus;
import Figuras.Hurraca;

/**
 * Clase fábrica para crear diferentes tipos de obstáculos en el juego.
 */
public class ObstaculoFactory {

    /**
     * Crea un objeto de tipo Cactus.
     *
     * @param x Coordenada X del cactus.
     * @param y Coordenada Y del cactus.
     * @return Instancia de Cactus.
     */
    public static Cactus crearCactus(int x, int y) {
        return new Cactus(x, y);
    }

    /**
     * Crea un objeto de tipo Hurraca.
     *
     * @param x Coordenada X de la hurraca.
     * @param y Coordenada Y de la hurraca.
     * @return Instancia de Hurraca.
     */
    public static Hurraca crearHurraca(int x, int y) {
        return new Hurraca(x, y);
    }
}
