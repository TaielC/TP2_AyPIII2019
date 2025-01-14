package algocraft.inventario;

import algocraft.excepciones.NoHaySuficienteMaterialExeption;
import algocraft.materialinventario.*;

import java.util.Hashtable;

public class InventarioMateriales {

    private Hashtable<Integer, Integer> materiales;

    public InventarioMateriales() {
        materiales = new Hashtable<>();
        MaterialInventario madera = new MaderaMaterialInventario();
        materiales.put(madera.hashCode(), 0);
        materiales.put((new PiedraMaterialInventario()).hashCode(), 0);
        materiales.put((new MetalMaterialInventario()).hashCode(), 0);
        materiales.put((new DiamanteMaterialInventario()).hashCode(), 0);
    }

    private InventarioMateriales(Hashtable<Integer, Integer> materiales){
        this.materiales = materiales;
    }

    public void agregar(MaterialInventario materialInventario) {
        if(materialInventario.equals(new MaterialInventarioNulo())) return;
        materiales.put(materialInventario.hashCode(), materiales.get(materialInventario.hashCode())+1);
    }

    public MaterialInventario getMadera(){ return getMaterial(new MaderaMaterialInventario()); }
    public MaterialInventario getPiedra(){ return getMaterial(new PiedraMaterialInventario()); }
    public MaterialInventario getMetal(){ return getMaterial(new MetalMaterialInventario()); }
    public MaterialInventario getDiamante(){ return getMaterial(new DiamanteMaterialInventario()); }

    public MaterialInventario getMaterial(MaterialInventario materialInventario){
        MaterialInventarioNulo materialNulo = new MaterialInventarioNulo();
        if(materialInventario.equals(materialNulo)) return materialNulo;
        if(materiales.get(materialInventario.hashCode()) <= 0){
            throw new NoHaySuficienteMaterialExeption(materialInventario);
        }
        materiales.put(materialInventario.hashCode(), materiales.get(materialInventario.hashCode())-1);
        return materialInventario;
    }

    public Integer cantidadMadera() {return materiales.get((new MaderaMaterialInventario()).hashCode()); }
    public Integer cantidadPiedra() {return materiales.get((new PiedraMaterialInventario()).hashCode()); }
    public Integer cantidadMetal() {return materiales.get((new MetalMaterialInventario()).hashCode()); }
    public Integer cantidadDiamante() {return materiales.get((new DiamanteMaterialInventario()).hashCode()); }

    public InventarioMateriales copy() {
        return new InventarioMateriales((Hashtable<Integer, Integer>) materiales.clone());
    }
}
