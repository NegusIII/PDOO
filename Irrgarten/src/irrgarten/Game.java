package irrgarten;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Game {
    
    private final char BLOCK_CHAR='X';
    private final char EMPTY_CHAR='-';
    private final char MONSTER_CHAR='M';
    private final char COMBAT_CHAR='C';
    private final char EXIT_CHAR='E';
    private final int ROW=0;
    private final int COL=1;
    
    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;
    
    Labyrinth(int nFilas, int nColumnas, int FilaSalida, int columnaSalida){
        nRows=nFilas;
        nCols=nColumnas;
        exitRow=filaSalida;
        exitCol=columnaSalida;
    }
    
    public void spreadPlayers(ArrayList<Player> players){
        
    }
    
    public boolean haveAWinner(){
        
    }
    
    public String toString(){
        
    }
    
    public void addMonster(int row, int col, Monster monster){
        
    }
    
    public Monster putPlayer(Directions direction, Player player){
        
    }
    
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        
    }
    
    public ArrayList<Directions> validMoves(int row, int col){
        
    }
    
    // Métodos privados
    
    private boolean posOK(int row, int col){
        
    }
    
    private boolean emptyPos(int row, int col){
        
    }
    
    private boolean monsterPos(int row, int col){
        
    }
    
    private boolean exitPos(int row, int col){
        
    }
    
    private boolean combatPos(int row, int col){
        
    }
    
    private boolean canStepOn(int row, int col){
        
    }
    
    private void updateOldPos(int row, int col){
        
    }
    
    private ArrayList<int> dir2Pos(int row, int col, Directions direction){
        
    }
    
    private ArrayList<int> randomEmptyPos(){
        
    }
    
    private Monster putPlayer2D(int oldRow, int oldCol, int row, int col. Player player){
        
    }
}
