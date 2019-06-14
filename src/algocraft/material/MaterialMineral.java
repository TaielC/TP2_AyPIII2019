package algocraft.material;

import algocraft.herramienta.*;
import algocraft.juego.ObjetoUbicable;

public abstract class MaterialMineral implements ObjetoUbicable {

    protected int durabilidad;

    public abstract void serGolpeado(Hacha hacha);

    public abstract void serGolpeado(Pico pico);

    public abstract void serGolpeado(PicoFino picoFino);

    public abstract boolean esDaniadoPor(MaterialHerramienta material);

    public int durabilidad() {
        return durabilidad;
    }

    @Override
    public int obtenerPosicionHorizontal() {
        return 0;
    }

    @Override
    public int obtenerPosicionVertical() {
        return 0;
    }
}
