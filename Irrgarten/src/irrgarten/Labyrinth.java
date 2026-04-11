package irrgarten;
import java.util.ArrayList;

/**
 *
 * @author Sergio Salvador Gil
 */
public class Labyrinth {
    
        
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
    
    private Monster[][] monsters;
    private Player[][] players;
    private char[][]labyrinth;
    
    Labyrinth(int nRows, int nCols, int exitRow, int exitCol){
        this.nRows=nRows;
        this.nCols=nCols;
        this.exitRow=exitRow;
        this.exitCol=exitCol;
        
        labyrinth[exitRow][exitCol]=EXIT_CHAR;
    }
    
    public void spreadPlayers(ArrayList<Player> players){
        throw new UnsupportedOperationException();
    }
    
    public boolean haveAWinner(){
        return players[exitRow][exitCol] != null;
    }
    
    public String toString(){
        String laberinto = "";
        for (int i = 0; i< nCols; i++){
            for (int j = 0; j < nRows; j++){
                laberinto += "[" + labyrinth[i][j] + "]";
            }
            laberinto += "\n";
        }
        return laberinto;
    }
    
    public void addMonster(int row, int col, Monster monster){
        if (posOK(row, col)){
            labyrinth[row][col]=MONSTER_CHAR;
            monsters[row][col]=monster;
            monster.setPos(row,col);
        }
    }
    
    public Monster putPlayer(Directions direction, Player player){
        throw new UnsupportedOperationException();
    }
    
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        throw new UnsupportedOperationException();
    }
    
    public ArrayList<Directions> validMoves(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    // Métodos privados
    
    private boolean posOK(int row, int col){
        return (0 <= row && row < nRows && 0 <= col && col < nCols);
    }
    
    private boolean emptyPos(int row, int col){
        return labyrinth[row][col]==EMPTY_CHAR;
    }
    
    private boolean monsterPos(int row, int col){
        return labyrinth[row][col]==MONSTER_CHAR;
    }
    
    private boolean exitPos(int row, int col){
        return labyrinth[row][col]==EXIT_CHAR;
    }
    
    private boolean combatPos(int row, int col){
        return labyrinth[row][col]==COMBAT_CHAR;
    }
    
    private boolean canStepOn(int row, int col){
        return (posOK(row,col)&&(monsterPos(row, col)||exitPos(row,col)||combatPos(row,col)));
    }
    
    private void updateOldPos(int row, int col){
        if (posOK(row,col)){
            if (combatPos(row,col)){
                labyrinth[row][col]=MONSTER_CHAR;
            }
            else labyrinth[row][col]=EMPTY_CHAR;
        }
    }
    
    private int [] dir2Pos(int row, int col, Directions direction){
        
        int pos[]={0,0};
        if(direction==Directions.DOWN){
           pos[ROW]=row+1;
           pos[COL]=col;
        }
        if(direction==Directions.LEFT){
           pos[ROW]=row;
           pos[COL]=col-1;
        }
        if(direction==Directions.RIGHT){
           pos[ROW]=row;
           pos[COL]=col+1;
        }
        if(direction==Directions.UP){
           pos[ROW]=row-1;
           pos[COL]=col;
        }
        return pos;
    }
    
    private int[] randomEmptyPos(){
        boolean empty=false;
        Dice dado = new Dice();
        int pos[]={0,0};
        
        while (empty=false){
            pos[ROW]=dado.randomPos(nRows);
            pos[COL]=dado.randomPos(nCols);
            empty=emptyPos(pos[ROW],pos[COL]);
        }
        return pos;
    }
    
    private Monster putPlayer2D(int oldRow, int oldCol, int row, int col. Player player){
        throw new UnsupportedOperationException();
    }
    
}