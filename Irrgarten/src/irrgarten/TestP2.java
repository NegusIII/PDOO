
package irrgarten;

/**
 *
 * @author Sergio Salvador GIl
 */
public class TestP2 {
    public static void main() {
        
        // Índice de pruebas
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        
        System.out.println("Pruebas Práctica 2:");
        System.out.println("1-Clase Monster\n2-Clase Player\n3-Clase Labyrinth\n4-Clase Game\n");
        
        // Prueba de la clase Monster
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("1- Clase Monster:\n");
        
        Monster netanyahu = new Monster("netanyahu", 7.0f, 4.0f);
        netanyahu.setPos(2, 3);
        
        System.out.println("Estado inicial: " + netanyahu.toString());
        System.out.println("Fuerza de ataque generada: " + netanyahu.attack());
        System.out.println("¿Defiende bien (daño 2.0)?: " + netanyahu.defend(2.0f));
        System.out.println("¿Está muerto?: " + netanyahu.dead() + "\n");

        // Prueba de la clase Player
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("2- Clase Player:\n");
        
        Player khamenei = new Player('1', 5.0f, 6.0f);
        khamenei.setPos(0, 0);
        
        System.out.println("Estado inicial: " + khamenei.toString());
        System.out.println("Fila: " + khamenei.getRow() + ", Columna: " + khamenei.getCol());
        System.out.println("Identificador (Number): " + khamenei.getNumber());
        System.out.println("Ataque base (sin armas sumadas): " + khamenei.attack());
        System.out.println("¿Está muerto?: " + khamenei.dead() + "\n");

        // Prueba de la clase Labyrinth
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("3- Clase Labyrinth:\n");
        
        Labyrinth TelAviv = new Labyrinth(5, 5, 4, 4);
        TelAviv.addMonster(2, 3, netanyahu);
        
        System.out.println("¿Hay ganador?: " + TelAviv.haveAWinner());
        System.out.println("Mapa del laberinto:\n" + TelAviv.toString());

        // Prueba de la clase Game
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("4- Clase Game:\n");
        
        Game partida = new Game(2); // Inicia partida con 2 jugadores
        
        System.out.println("¿Partida terminada?: " + partida.finished());
        
        GameState estado = partida.getGameState();
        System.out.println("Registro de Eventos (Log):\n" + estado.getLog());
        System.out.println("Monstruos:\n" + estado.getMonsters());

        // Fin de las pruebas
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
    }
}
