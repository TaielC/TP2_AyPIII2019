package algocraft;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public class Tablero {

    private Map<String,Casillero> tablero = new HashMap<>();
    private int bordeHorizontal;
    private int bordeVertical;

    private String posAString(int x, int y){
        String posVertical = String.valueOf(y);
        String posHorizontal = String.valueOf(x);
        return posHorizontal+','+posVertical;
    }

    public Tablero(int x, int y){

        bordeHorizontal = x;
        bordeVertical = y;
        for(int i = 0; i < x; i ++){
            for (int j = 0; j < y; j++){

                Casillero casillero = new Casillero(i, j);

                this.tablero.put(posAString(i, j), casillero);
            }
            }

        }


    public Casillero casillero(String clave){
        return tablero.get(clave);


    }

    public Casillero modificarHaciaArriba(Casillero casillero){
        if(casillero.posicionVertical()+1 > bordeVertical ){
            return casillero;
        }

        String pos = posAString(casillero.posicionHorizontal(),casillero.posicionVertical()+1);
        Casillero casilleroNuevo = tablero.get(pos);

        if(casilleroNuevo.estaVacio()){
            return casilleroNuevo;
        }

        return casillero;



    }





}
