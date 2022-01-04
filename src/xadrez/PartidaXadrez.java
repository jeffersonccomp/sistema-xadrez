package xadrez;

import tabuleiro.Peca;
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
    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return tabuleiro.peca(position).possibleMoves();
 
    }



    public PecaXadrez performChessMove(ChessPosition sourcePosition, ChessPosition targePosition){
        Position source = sourcePosition.toPosition();
        Position target = targePosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Peca capturedPiece = makeMove(source, target);
        return (PecaXadrez)capturedPiece;
    }
    private Peca makeMove(Position source, Position target){
        Peca p = tabuleiro.removePeca(source);
        Peca capturedPiece = tabuleiro.removePeca(target);
        tabuleiro.lugarPeca(p, target);
        return capturedPiece;
    }
    private void validateSourcePosition(Position position){
        if(!tabuleiro.thereIsAPiece(position)){
            throw new ChessException("Sem peça na posiçao inicial");
        }
        if(!tabuleiro.peca(position).isThereAnyPossibleMove()){
            throw new ChessException("Movimento não possivel para essa peça");
        }
    }
    private void validateTargetPosition(Position source, Position target){
            if(!tabuleiro.peca(source).possibleMove(target)){
                throw new ChessException("Movimento não valido");
            }
    }

    private void lugarNovoPeca(char column, int row, PecaXadrez peca){
        tabuleiro.lugarPeca(peca, new ChessPosition(column, row).toPosition());
    }


    private void initialSetup() {
        lugarNovoPeca('c', 1, new Rook(tabuleiro, Color.WHITE));
        lugarNovoPeca('c', 2, new Rook(tabuleiro, Color.WHITE));
        lugarNovoPeca('d', 2, new Rook(tabuleiro, Color.WHITE));
        lugarNovoPeca('e', 2, new Rook(tabuleiro, Color.WHITE));
        lugarNovoPeca('e', 1, new Rook(tabuleiro, Color.WHITE));
        lugarNovoPeca('d', 1, new King(tabuleiro, Color.WHITE));
    
        lugarNovoPeca('c', 7, new Rook(tabuleiro, Color.BLACK));
        lugarNovoPeca('c', 8, new Rook(tabuleiro, Color.BLACK));
        lugarNovoPeca('d', 7, new Rook(tabuleiro, Color.BLACK));
        lugarNovoPeca('e', 7, new Rook(tabuleiro, Color.BLACK));
        lugarNovoPeca('e', 8, new Rook(tabuleiro, Color.BLACK));
        lugarNovoPeca('d', 8, new King(tabuleiro, Color.BLACK));
    }

}

