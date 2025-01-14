package view.constructor;

import algocraft.herramientafactory.TableroConstruccionHerramienta;
import algocraft.excepciones.NoHaySuficienteMaterialExeption;
import algocraft.inventario.InventarioMateriales;
import algocraft.juego.Juego;
import algocraft.materialinventario.MaterialInventario;
import algocraft.materialinventario.MaterialInventarioNulo;
import controller.constructor.BotonCerrarEventHandler;
import controller.constructor.BotonEliminarMaterialEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import media.Imagenes;
import view.juego.PantallaJuego;

public class PantallaConstructor extends BorderPane{

    private static final double TAMANIO = Screen.getPrimary().getVisualBounds().getHeight()/2;

    private MaterialInventario materialElegido;
    private Juego juego;
    private TableroConstruccionHerramienta tablero;
    private InventarioMateriales inventarioCopiado;
    private PantallaJuego pantallaJuego;
    private GridPane bottomPane;

    public PantallaConstructor(Stage ventanaConstructor, PantallaJuego pantallaJuego, Juego juego){
        this.pantallaJuego = pantallaJuego;
        this.tablero = new TableroConstruccionHerramienta();
        this.juego = juego;
        this.inventarioCopiado = juego.getJugador().getInventarioMateriales().copy();
        this.materialElegido = new MaterialInventarioNulo();

        Button botonEliminar = new Button();
        botonEliminar.setPadding(new Insets(0,0,0,0));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(new ImageView(Imagenes.get("FondoCasillero")), new ImageView(Imagenes.get("EliminarMaterial")));
        stackPane.setAlignment(Pos.CENTER);
        botonEliminar.setGraphic(stackPane);

        BotonEliminarMaterialEventHandler botonEventHandler = new BotonEliminarMaterialEventHandler(this);
        botonEliminar.setOnAction(botonEventHandler);
        botonEliminar.setAlignment(Pos.CENTER);

        VBox leftPane = new VBox();
        leftPane.setAlignment(Pos.CENTER);
        leftPane.setPadding(new Insets(0,0,0,20));
        leftPane.getChildren().add(botonEliminar);
        this.setLeft(leftPane);

        bottomPane = new GridPane();
        Button botonCerrar = new Button();
        botonCerrar.setText("Cerrar");
        botonCerrar.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 30));
        botonCerrar.setMinSize(400, 100);
        botonCerrar.setBackground(new Background(new BackgroundImage(Imagenes.get("BotonMenuPrincipal"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(300, 100, false, false, false, false))));
        botonCerrar.setOnAction(new BotonCerrarEventHandler(ventanaConstructor));
        botonCerrar.setAlignment(Pos.CENTER);

        bottomPane.add(botonCerrar, 0,1);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setVgap(30);
        bottomPane.setPadding(new Insets(10, 10, 150, 10));

        this.setBackground(new Background(new BackgroundImage(Imagenes.get("FondoMenuEmergente"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(TAMANIO*176/150, TAMANIO*166/150, false, false, false, false))));
        this.actualizar();
    }

    public void reiniciar() {
        this.tablero = new TableroConstruccionHerramienta();
        this.inventarioCopiado = juego.getJugador().getInventarioMateriales().copy();
        this.actualizar();
    }

    public void actualizar(){
        try {
            inventarioCopiado.agregar(inventarioCopiado.getMaterial(materialElegido));
        } catch (NoHaySuficienteMaterialExeption e) {
            materialElegido = new MaterialInventarioNulo();
        }

        ContenedorConstructorHerramientas constructorHerramientas = new ContenedorConstructorHerramientas(this);
        this.setCenter(constructorHerramientas);

        ContenedorMaterialesConstructor contenedorMaterialesConstructor = new ContenedorMaterialesConstructor(this);
        bottomPane.add(contenedorMaterialesConstructor, 0, 0);
        this.setBottom(bottomPane);
    }

    public TableroConstruccionHerramienta getTablero(){ return tablero; }

    public MaterialInventario getMaterialElegido(){
        return materialElegido;
    }

    public void setMaterialElegido(MaterialInventario materialElegido) {
        this.materialElegido = materialElegido;
    }

    public Juego getJuego() { return juego; }

    public InventarioMateriales getInventarioCopiado() {
        return inventarioCopiado;
    }

    public PantallaJuego getPantallaJuego() { return pantallaJuego; }
}
