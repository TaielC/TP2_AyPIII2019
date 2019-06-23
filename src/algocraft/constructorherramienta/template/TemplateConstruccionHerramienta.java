package algocraft.constructorherramienta.template;

import algocraft.constructorherramienta.TableroConstruccionHerramienta;
import algocraft.herramienta.Herramienta;

public abstract class TemplateConstruccionHerramienta {

    protected TableroConstruccionHerramienta template;

    public Herramienta construirSiEsIgual(TableroConstruccionHerramienta tablero){
        if (template.equals(tablero)) { return construir(); }
        return null;
    }

    public TableroConstruccionHerramienta getTemplate(){ return template; }

    protected abstract Herramienta construir();
}
