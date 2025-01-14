package algocraft.materialinventario;

public class PiedraMaterialInventario implements MaterialInventario {

    @Override
    public boolean equals(MaterialInventario material) {
        return material.equals(this);
    }

    @Override
    public boolean equals(MaderaMaterialInventario material) {
        return false;
    }

    @Override
    public boolean equals(PiedraMaterialInventario material) {
        return true;
    }

    @Override
    public boolean equals(MetalMaterialInventario material) {
        return false;
    }

    @Override
    public boolean equals(DiamanteMaterialInventario material) {
        return false;
    }

    @Override
    public int hashCode(){ return "piedra".hashCode(); }
}