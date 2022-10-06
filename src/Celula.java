public class Celula
{

    private boolean vivo;

    // CONSTANTES
    static final boolean VIVIR = true;
    static final boolean MORIR = false;

    public Celula()
    {

        this.vivo = MORIR;

    }

    public boolean isVivo()
    {

        return vivo;

    }

    public void setVivo(boolean vivo)
    {

        this.vivo = vivo;

    }

    public void matarCelula()
    {

        vivo = MORIR;

    }

    public void darVidaCelula()
    {

        vivo = VIVIR;

    }

}
