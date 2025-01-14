package controller.constructor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import media.Sonidos;

public class BotonCerrarEventHandler implements EventHandler<ActionEvent> {

    private Stage ventanaConstructor;

    public BotonCerrarEventHandler(Stage ventanaConstructor){
        this.ventanaConstructor = ventanaConstructor;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Media sound = Sonidos.get("boton");
        MediaPlayer sonido = new MediaPlayer(sound);
        sonido.play();

        Button boton = (Button) actionEvent.getSource();
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        boton.setEffect(colorAdjust);
        ventanaConstructor.close();
    }
}
