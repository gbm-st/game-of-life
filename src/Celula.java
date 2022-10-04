public class Celula {
    private boolean vivo;

    public Celula(boolean estado) {
        vivo = estado;
    }

    public boolean isVivo(){
        return vivo;
    }

    public void matarCelular(){
        vivo = false;
    }

    public void darVidaCelula(){
        vivo = true;
    }
}
