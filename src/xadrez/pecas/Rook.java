package xadrez.pecas;

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
    

}
