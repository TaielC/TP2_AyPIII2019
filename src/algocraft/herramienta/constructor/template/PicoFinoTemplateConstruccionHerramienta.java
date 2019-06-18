package algocraft.herramienta.constructor.template;

import algocraft.herramienta.constructor.TableroConstruccionHerramienta;
import algocraft.herramienta.Herramienta;
import algocraft.herramienta.PicoFino;
import algocraft.herramienta.material.MaderaMaterialHerramienta;
import algocraft.herramienta.material.MetalMaterialHerramienta;
import algocraft.herramienta.material.PiedraMaterialHerramienta;

public class PicoFinoTemplateConstruccionHerramienta extends TemplateConstruccionHerramienta {

    public PicoFinoTemplateConstruccionHerramienta(){
        super();
        TableroConstruccionHerramienta template = new TableroConstruccionHerramienta();

        template.putSuperiorIzquierda(new MetalMaterialHerramienta());
        template.putSuperior(new MetalMaterialHerramienta());
        template.putSuperiorDerecha(new MetalMaterialHerramienta());
        template.putIzquierda(new PiedraMaterialHerramienta());
        template.putCentro(new MaderaMaterialHerramienta());
        template.putInferior(new MaderaMaterialHerramienta());

        templatesPosibles.add(template);

        template = new TableroConstruccionHerramienta();

        template.putSuperiorIzquierda(new MetalMaterialHerramienta());
        template.putSuperior(new MetalMaterialHerramienta());
        template.putSuperiorDerecha(new MetalMaterialHerramienta());
        template.putDerecha(new PiedraMaterialHerramienta());
        template.putCentro(new MaderaMaterialHerramienta());
        template.putInferior(new MaderaMaterialHerramienta());

        templatesPosibles.add(template);
    }

    @Override
    protected Herramienta construir() {
        return new PicoFino();
    }
}