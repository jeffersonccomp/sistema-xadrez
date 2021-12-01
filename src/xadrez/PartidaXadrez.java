package xadrez;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.pecas.King;
import xadrez.pecas.Rook;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
        initialSetup();
    }
    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getRows()][tabuleiro.getColumns()];
        for(int i=0; i<tabuleiro.getRows(); i++){
            for(int j=0; j<tabuleiro.getColumns(); j++){
                
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);

            }
        }
        return mat;
    }

    private void lugarNovoPeca(char column, int row, PecaXadrez peca){
        tabuleiro.lugarPeca(peca, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup(){
        lugarNovoPeca('b', 6, new Rook(tabuleiro, Color.WHITE));
        lugarNovoPeca('e', 8, new King(tabuleiro, Color.WHITE));


    }
}
