package view.constructor;

import algocraft.juego.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.juego.PantallaJuego;


public class VentanaConstructor extends Stage {

    private static final double TAMANIO = Screen.getPrimary().getVisualBounds().getHeight()/2;

    public VentanaConstructor(PantallaJuego pantallaJuego, Juego juego, Button botonConstructor){
        super(StageStyle.UNDECORATED);
        this.setHeight(TAMANIO*166/150);
        this.setWidth(TAMANIO*176/150);
        this.initStyle(StageStyle.TRANSPARENT);

        PantallaConstructor pantallaConstructor = new PantallaConstructor(this, pantallaJuego, juego);

        Scene escenaConstructor = new Scene(pantallaConstructor);
        Effect efectoAnterior = pantallaJuego.getEffect();
        this.setOnHidden(e -> {
            pantallaJuego.setEffect(efectoAnterior);
            botonConstructor.setEffect(new ColorAdjust());
        });
        pantallaJuego.setEffect(new GaussianBlur(8));

        this.setTitle("Constructor Herramientas");
        this.initOwner(pantallaJuego.getScene().getWindow());
        escenaConstructor.setFill(Color.TRANSPARENT);
        this.setScene(escenaConstructor);
        this.initModality(Modality.APPLICATION_MODAL);

        this.showAndWait();
        this.setX((pantallaJuego.getWidth() - this.getWidth())/2);
        this.setY((pantallaJuego.getHeight() - this.getHeight())/2);
    }
}
