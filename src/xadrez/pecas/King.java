package xadrez.pecas;


import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;


public class King extends PecaXadrez{
    

    public King(Tabuleiro tabuleiro, Color color){
        super(color, tabuleiro);

    }


    @Override
    public String toString() {
        return "K";
    }

    private boolean canMoves(Position position){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(position);
        return p == null || p.getColor() != getColor();
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean [getTabuleiro().getRows()][getTabuleiro().getColumns()];
        Position p = new Position(0, 0);

        //Acima
        p.setValues(position.getRow() - 1, position.getColumn());
        
        if(getTabuleiro().positionExists(p) && canMoves(p)){
            
            mat[p.getRow()][p.getColumn()]=true;

        }       
        //baixo
        p.setValues(position.getRow() + 1, position.getColumn() );
        
        if(getTabuleiro().positionExists(p) && canMoves(p)){
            
            mat[p.getRow()][p.getColumn()]=true;

        }       
        //esquerda
        p.setValues(position.getRow(), position.getColumn()-1);
        
        if(getTabuleiro().positionExists(p) && canMoves(p)){
            
            mat[p.getRow()][p.getColumn()]=true;

        }       
        //direita
        p.setValues(position.getRow(), position.getColumn()+1);
        
        if(getTabuleiro().positionExists(p) && canMoves(p)){
            
            mat[p.getRow()][p.getColumn()]=true;

        }      
        //Diagonal cima esquerda
        p.setValues(position.getRow() - 1, position.getColumn()-1);
        
        if(getTabuleiro().positionExists(p) && canMoves(p)){
            
            mat[p.getRow()][p.getColumn()]=true;

        }        
        //Diagonal cima direita
        p.setValues(position.getRow() - 1, position.getColumn()+1);
        
        if(getTabuleiro().positionExists(p) && canMoves(p)){
            
            mat[p.getRow()][p.getColumn()]=true;

        }       
        //Diagonal baixo esquerda
        p.setValues(position.getRow() + 1, position.getColumn() -1);
        
        if(getTabuleiro().positionExists(p) && canMoves(p)){
            
            mat[p.getRow()][p.getColumn()]=true;

        }       
        //Diagonal baixo direita
        p.setValues(position.getRow() + 1, position.getColumn()+1);
        
        if(getTabuleiro().positionExists(p) && canMoves(p)){
            
            mat[p.getRow()][p.getColumn()]=true;

        }       
        
        return mat;
    }

}
