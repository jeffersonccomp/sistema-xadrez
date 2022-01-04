package tabuleiro;

public class Tabuleiro {

    private int rows;
    private int columns;

    private Peca[][] pecas;


    public Tabuleiro(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Error ao criar o tabuleiro: não pode ter menos de 1 coluna e 1 linha");
        }
        this.rows = rows;
        this.columns = columns;
        pecas = new Peca[rows][columns];
    }


    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public Peca[][] getPecas() {
        return this.pecas;
    }

    public void setPecas(Peca[][] pecas) {
        this.pecas = pecas;
    }

    public Peca peca( int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Posição nao existe");
        }
        return pecas[row][column];
    }
    public Peca peca(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição nao existe");
        }
        return pecas[position.getRow()][position.getColumn()];
    }

    public void lugarPeca(Peca peca, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Já existe uma peça na posição "+ position);
        }
        
        pecas[position.getRow()][position.getColumn()] = peca;
        peca.position = position;
    }
    public Peca removePeca (Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição nao existe");
        }
        if(peca(position) == null){
            return null;
        }
        Peca aux = peca(position);
        aux.position = null;
        pecas[position.getRow()][position.getColumn()] = null;
        return aux;
    }
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column <columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição nao existe");
        }
        return peca(position) != null;
    }
}
