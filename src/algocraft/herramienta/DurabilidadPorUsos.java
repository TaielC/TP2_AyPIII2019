package algocraft.herramienta;

public class DurabilidadPorUsos extends Durabilidad {

    private int usos;

    public DurabilidadPorUsos(double durabilidadHerramienta, int cantUsos){
        durabilidad = durabilidadHerramienta;
        usos = cantUsos;
    }

    @Override
    public void desgastar() {
        usos -=1;
        if(usos <= 0) durabilidad = 0;
    }
}
