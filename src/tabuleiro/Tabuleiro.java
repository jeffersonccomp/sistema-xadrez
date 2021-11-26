package tabuleiro;

public class Tabuleiro {

    private int rows;
    private int columns;

    private Peca[][] pecas;


    public Tabuleiro(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pecas = new Peca[rows][columns];
    }

    public int getRows(){
        return rows;
    }
    
}
