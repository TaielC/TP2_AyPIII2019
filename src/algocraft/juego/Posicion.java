package algocraft.juego;

import java.util.Arrays;

public class Posicion {

    private int coordenadaX;
    private int coordenadaY;

    public Posicion(int posX, int posY){
        this.coordenadaX = posX;
        this.coordenadaY = posY;

    }

    public int getX(){
        return coordenadaX;
    }

    public int getY(){
        return coordenadaY;
    }

    public Posicion obtenerSiguiente (Direccion direccion){
        return direccion.obtenerSiguiente(this);
    }

    @Override
    public String toString(){
        int posX = this.coordenadaX;
        int posY = this.coordenadaY;
        int[] posicion = {posX, posY};
        return Arrays.toString(posicion);
    }

    @Override
    public boolean equals(Object objeto){
        if (!(objeto instanceof Posicion)) {
            return false;
        }
        if (objeto == this) {
            return true;
        }
        Posicion otro = (Posicion) objeto;

        return (this.getX() == otro.getX() && this.getY() == otro.getY());
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
