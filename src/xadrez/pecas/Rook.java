package xadrez.pecas;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaXadrez;

public class Rook extends PecaXadrez{
    

    public Rook(Tabuleiro tabuleiro, Color color){
        super(color, tabuleiro);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean [getTabuleiro().getRows()][getTabuleiro().getColumns()];

        Position p = new Position(0, 0);

        //Acima
        p.setValues(position.getRow() - 1, position.getColumn());
        while(getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
            p.setRow(p.getRow()-1);
        }
        if(getTabuleiro().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
        }
        //Abaixo
        p.setValues(position.getRow() + 1, position.getColumn());
        while(getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
            p.setRow(p.getRow()+1);
        }
        if(getTabuleiro().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
        }
        //Direita
        p.setValues(position.getRow() , position.getColumn() + 1);
        while(getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
            p.setColumn(p.getColumn() + 1);
        }
        if(getTabuleiro().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
        }
        //Esquerda
        p.setValues(position.getRow() , position.getColumn() - 1);
        while(getTabuleiro().positionExists(p) && !getTabuleiro().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
            p.setColumn(p.getColumn() - 1);
        }
        if(getTabuleiro().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()]=true;
        }



        return mat;
    }
    

}
