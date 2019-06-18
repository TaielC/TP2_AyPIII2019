package algocraft.juego;

import algocraft.herramienta.*;
import algocraft.material.*;

public class Jugador implements ObjetoUbicable{

    private Inventario inventario;
    private Tablero tablero;
    private Posicion posicion;
    private Direccion direccion;

    public Jugador(Tablero tablero, Posicion posicion) {
        inventario = new Inventario();
        inventario.agregar(new Hacha(new MaderaMaterialHerramienta()));
        this.tablero = tablero;
        this.posicion = posicion;
    }

    public int agregarAInventario(Herramienta herramienta) {
        return inventario.agregar(herramienta);
    }

    public void agregarAInventario(Herramienta herramienta, int posicion) {
        inventario.agregar(herramienta, posicion);
    }

    public Herramienta obtenerDeInventario(int posicion) {
        return inventario.obtener(posicion);
    }

    public boolean inventarioEstaVacio() {
        return inventario.estaVacio();
    }

    public void moverHacia(Direccion direccion) {
        this.direccion = direccion;
        if (!(this.tablero.estaEnElLimite(this.posicion))) {
            Posicion siguientePosicion = this.posicion.obtenerSiguiente(direccion);
            Casillero casilleroSiguiente = tablero.casillero(siguientePosicion.getString());

            if (casilleroSiguiente.estaVacio()) {
                this.posicion = siguientePosicion;
            }
            //Deberia lanzar una excepcion si esta en el borde
        }
    }

    @Override
    public Posicion getPosicion() {
        return this.posicion;
    }

    @Override
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }


}

