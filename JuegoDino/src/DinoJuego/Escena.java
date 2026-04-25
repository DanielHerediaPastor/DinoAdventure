package DinoJuego;

import Figuras.Cactus;
import Figuras.Hurraca;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la escena del juego, incluyendo los obstáculos.
 */
public class Escena {
    private List<Cactus> cactusList;    // Lista de cactus en la escena
    private List<Hurraca> hurracaList; // Lista de hurracas en la escena

    /**
     * Constructor que inicializa los obstáculos de la escena.
     */
    public Escena() {
        cactusList = new ArrayList<>();
        hurracaList = new ArrayList<>();

        // Crear obstáculos iniciales utilizando el Factory
        agregarCactus(ObstaculoFactory.crearCactus(300, 475));
        agregarCactus(ObstaculoFactory.crearCactus(800, 475));
        agregarHurraca(ObstaculoFactory.crearHurraca(1200, 245));
        agregarHurraca(ObstaculoFactory.crearHurraca(1700, 245));
    }

    /**
     * Obtiene la lista de cactus en la escena.
     *
     * @return Lista de cactus.
     */
    public List<Cactus> getCactusList() {
        return cactusList;
    }

    /**
     * Obtiene la lista de hurracas en la escena.
     *
     * @return Lista de hurracas.
     */
    public List<Hurraca> getHurracaList() {
        return hurracaList;
    }

    /**
     * Agrega un cactus a la escena.
     *
     * @param cactus Objeto de tipo Cactus a agregar.
     */
    public void agregarCactus(Cactus cactus) {
        cactusList.add(cactus);
    }

    /**
     * Agrega una hurraca a la escena.
     *
     * @param hurraca Objeto de tipo Hurraca a agregar.
     */
    public void agregarHurraca(Hurraca hurraca) {
        hurracaList.add(hurraca);
    }

    /**
     * Elimina un cactus de la escena.
     *
     * @param cactus Objeto de tipo Cactus a eliminar.
     */
    public void eliminarCactus(Cactus cactus) {
        cactusList.remove(cactus);
    }

    /**
     * Elimina una hurraca de la escena.
     *
     * @param hurraca Objeto de tipo Hurraca a eliminar.
     */
    public void eliminarHurraca(Hurraca hurraca) {
        hurracaList.remove(hurraca);
    }

    /**
     * Actualiza la posición de los obstáculos en la escena.
     */
    public void actualizar() {
        for (Cactus cactus : cactusList) {
            cactus.mover(5); // Velocidad de movimiento
        }

        for (Hurraca hurraca : hurracaList) {
            hurraca.mover(5); // Velocidad de movimiento
        }
    }
}
