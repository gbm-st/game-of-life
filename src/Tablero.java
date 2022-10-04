public class Tablero {
    int filas;
    int columnas;
    Celula[][] listaCelulas;

    public Tablero(int columnas, int filas){
        listaCelulas = new Celula[columnas][filas];
    }

    public Tablero calcularSiguienteEstado(){
        return null;
    }

    public Celula calcularCambioEstadoCelula(){
        return null;
    }

    public Celula[][] calcularVecinos(){
        return null;
    }

    public boolean[][] vecinosVivos(Celula celulaCentral){
        return null;
    }
}
