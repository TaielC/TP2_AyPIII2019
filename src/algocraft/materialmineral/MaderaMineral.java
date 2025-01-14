package algocraft.materialmineral;

import algocraft.herramienta.*;
import algocraft.juego.Posicion;
import algocraft.materialherramienta.MaterialHerramienta;
import algocraft.materialinventario.MaderaMaterialInventario;
import algocraft.materialinventario.MaterialInventario;

public class MaderaMineral extends MaterialMineral  {

    public MaderaMineral(Posicion posicion){
        durabilidad = 10;
        posicionMaterial = posicion;
    }

    @Override
    public void serGolpeado(Hacha hacha) {
        durabilidad -= hacha.fuerza();
        hacha.golpear(this);
    }

    @Override
    public void serGolpeado(Pico pico) { pico.golpear(this); }

    @Override
    public void serGolpeado(PicoFino picoFino) { picoFino.golpear(this); }

    @Override
    public boolean esDaniadoPor(MaterialHerramienta material) {
        return material.daniaA(this);
    }

    @Override
    public MaterialInventario obtenerMaterialInventario() {
        return new MaderaMaterialInventario();
    }

}
