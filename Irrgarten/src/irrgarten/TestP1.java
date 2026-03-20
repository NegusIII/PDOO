/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class TestP1 {
    
    public static void main() {
        
        // Índice de pruebas
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        
        System.out.println("Pruebas:");
        System.out.println("1-Clase Gamestate\n2-Clase Dice\n3-Clases Weapon y Shield\n4-Structs\n");
        
        // Prueba del GameState
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        
        System.out.println("1- Clase GameState:\n");
        
        GameState estado = new GameState("Namibia", "No hay jugadores",
                "No hay monstruos", 0, false, "No ha ocurrido nada");
        
        System.out.println("Labyrinth: " + estado.getLabyrinth());
        System.out.println("Players: " + estado.getPlayers());
        System.out.println("Monsters: " + estado.getMonsters());
        System.out.println("Current Player: " + estado.getCurrentPlayer());
        System.out.println("Winner? " + estado.isWinner());
        System.out.println("Log: " + estado.getLog()+ "\n");
        
        // Prueba de la clase Dice
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("2- Clase Dice:\n");
        Dice dado = new Dice();
        
        System.out.println("Posiciones aleatorias [0,9]:");
        int num = 10;
        for(int i = 0; i < num; i++){
            
            if(i==num-1){
                System.out.println(dado.randomPos(10)+"\n");
            }
            else{
                System.out.print(dado.randomPos(10)+", ");
            }
        }
        
        System.out.println("Fuerza de un arma aleatoria (hasta 10):");
        
        for(int i = 0; i < num; i++){
            
            if(i==num-1){
                System.out.println(dado.randomStrength()+"\n");
            }
            else{
                System.out.print(dado.randomStrength()+", ");
            }
        }
        
        // Los métodos con implementaciones idénticas (Que simplemente hagan uso
        // de los métodos nextInt() y nextFloat() de la clase Random) se dan 
        // por probados.
        
        System.out.println("Intentos de resurrección de un jugador:");
        
        for(int i = 0; i < num; i++){
            
            if(i==num-1){
                System.out.println(dado.resurrectPlayer());
            }
            else{
                System.out.print(dado.resurrectPlayer()+", ");
            }
        }
        
        int exitos = 0;
        num=1000000;
        
        for(int i = 0; i < num; i++){
            
            if(dado.resurrectPlayer()){
                exitos++;
            }
        }
        
        float p = exitos/(float)num;
        
        System.out.println("Tras "+num+" intentos, la probabilidad calculada de resurrección es de: "+p+"\n");
        
        System.out.println("Descartar elementos:");
        
        num=10;
        for(int i = 0; i<num; i++){
            
            int usos=dado.usesLeft();
            
            System.out.println("Usos: "+usos+"/5. Descartado: "+ dado.discardElement(usos));
            
        }
        
        // Prueba de las clases Weapon y Shield
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("3- Clases Weapon y Shield:\n");
        
        System.out.println("Generación de armas y escudos:");
        for(int i = 0; i<num; i++){
            Weapon w= new Weapon(dado.weaponPower(), dado.usesLeft());
            if(i==num-1){
                System.out.print(w.toString()+"\n");
            }
            else{
                System.out.print(w.toString()+", ");
            }
        }
        
        for(int i = 0; i<num; i++){
            Shield s= new Shield(dado.shieldPower(), dado.usesLeft());
            if(i==num-1){
                System.out.println(s.toString()+"\n");
            }
            else{
                System.out.print(s.toString()+", ");
            }
            
        }
        
        System.out.println("Descartar armas y escudos:");
        
        
        
        //Prueba de los Structs
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("4- Structs:\n");
        
        
        // Fin de las pruebas
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");


    }
}
