package algocraft.tableroconstruccionherramientatemplates;

import algocraft.constructorherramienta.TableroConstruccionHerramienta;
import algocraft.material.MaderaMaterialHerramienta;
import algocraft.material.MaterialHerramienta;

public class TableroPicoMaderaTemplate extends TableroConstruccionHerramienta {

    public TableroPicoMaderaTemplate(){
        super();

        tablero[0] = new MaderaMaterialHerramienta();
        tablero[1] = new MaderaMaterialHerramienta();
        tablero[2] = new MaderaMaterialHerramienta();
        tablero[4] = new MaderaMaterialHerramienta();
        tablero[7] = new MaderaMaterialHerramienta();
    }


    @Override
    public void putSuperiorIzquierda(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
    @Override
    public void putSuperior(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
    @Override
    public void putSuperiorDerecha(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
    @Override
    public void putIzquierda(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
    @Override
    public void putCentro(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
    @Override
    public void putDerecha(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
    @Override
    public void putInferiorIzquierda(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
    @Override
    public void putInferior(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
    @Override
    public void putInferiorDerecha(MaterialHerramienta material){
        // No se puede modificar el Template.
    }
}
