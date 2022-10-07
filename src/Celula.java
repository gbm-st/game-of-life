
public class Celula
{

    private boolean vivo;

    // CONSTANTES
    static final boolean VIVO = true;
    static final boolean MUERTO = false;

    public Celula()
    {

        this.vivo = MUERTO;

    }

    public boolean isVivo()
    {

        return vivo;

    }

    public void matarCelula()
    {

        vivo = MUERTO;

    }

    public void darVidaCelula()
    {

        vivo = VIVO;

    }

}
