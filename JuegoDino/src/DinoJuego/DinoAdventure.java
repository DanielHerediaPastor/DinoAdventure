package DinoJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase principal que gestiona la ventana del juego Dino Adventure.
 */
public class DinoAdventure extends JFrame {
    private JPanel menuPanel;
    private CardLayout cardLayout;
    private Juego juego;

    /**
     * Constructor que inicializa la ventana del juego.
     */
    public DinoAdventure() {
        setTitle("Dino Adventure");
        setSize(1920, 1080); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Evita el redimensionamiento de la ventana

        // Configuración de CardLayout para las pantallas
        cardLayout = new CardLayout();
        menuPanel = new JPanel(cardLayout);

        // Añadir el panel de selección de personaje
        JPanel selectionPanel = createCharacterSelectionPanel();
        menuPanel.add(selectionPanel, "Selección de Personaje");

        // Inicializar el juego con un personaje por defecto
        juego = new Juego("Dino");
        menuPanel.add(juego, "Juego");

        setContentPane(menuPanel); // Establece el contenido principal

        // KeyListener para gestionar el salto con la barra espaciadora
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (isGamePanelVisible()) {
                        juego.iniciarSalto();
                    }
                }
            }
        });

        setFocusable(true);
    }

    /**
     * Verifica si el panel de juego está visible actualmente.
     *
     * @return true si el panel de juego está visible; false en caso contrario.
     */
    private boolean isGamePanelVisible() {
        Component[] components = menuPanel.getComponents();
        for (Component component : components) {
            if (component.isVisible() && component == juego) {
                return true;
            }
        }
        return false;
    }

    /**
     * Crea el panel de selección de personaje.
     *
     * @return JPanel configurado para la selección de personaje.
     */
    private JPanel createCharacterSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        JButton dinoButton = new JButton("Seleccionar Dino");
        dinoButton.setFont(new Font("Arial", Font.BOLD, 20));
        dinoButton.addActionListener(e -> startGame("Dino"));

        JButton birdButton = new JButton("Seleccionar Bird");
        birdButton.setFont(new Font("Arial", Font.BOLD, 20));
        birdButton.addActionListener(e -> startGame("Bird"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(dinoButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(birdButton, gbc);

        return panel;
    }

    /**
     * Inicia el juego con el personaje seleccionado.
     *
     * @param personaje Nombre del personaje seleccionado.
     */
    private void startGame(String personaje) {
        juego = new Juego(personaje);
        menuPanel.add(juego, "Juego");
        cardLayout.show(menuPanel, "Juego");
        juego.startGame();
    }

    /**
     * Método principal para iniciar la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DinoAdventure frame = new DinoAdventure();
            frame.setVisible(true);
        });
    }
}
