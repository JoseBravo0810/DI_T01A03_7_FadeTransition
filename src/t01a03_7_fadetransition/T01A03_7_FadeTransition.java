/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t01a03_7_fadetransition;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author jose
 */
public class T01A03_7_FadeTransition extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        // Creamos la elipse args(2) -> Radio X, Radio Y | args(4) -> Eje X, Eje Y, Radio X, radio Y
        Ellipse ellipse = new Ellipse(200, 150);
        // Le damos color
        ellipse.setFill(Color.DARKCYAN);
        
        // Creamos la animacion FadeTransition
        FadeTransition ft = new FadeTransition(Duration.millis(3000), ellipse);
        /* Le establecemos el valor inicial en la opacidad canal alpha
                1.0 -> MAX objeto totalmente opaco
                0.0 -> MIN objeto totalmente transparente
        */
        ft.setFromValue(1.0);
        // Establecemos el valor de destino en la transicion (lo dejamos a 0.1 para que no se vuelva transparente del todo)
        ft.setToValue(0.1);
        // Establecemos durante cuanto tiempo se ejecutará la transicion (indefinido - infinito)
        ft.setCycleCount(Timeline.INDEFINITE);
        // Establecemos que al final de la animacion, la realice a la inversa
        ft.setAutoReverse(true);
        // Establecemos que no se pare al finalizar una transicion, animacion lineal
        ft.setInterpolator(Interpolator.LINEAR);
        
        // Creamos el nodo raiz
        StackPane root = new StackPane();
        // Le añadimos la elipse
        root.getChildren().add(ellipse);
        
        // Comenzamos la animacion
        ft.play();
        
        // Al hacer click en la ventana se detiene la animacion
        root.setOnMousePressed(e -> ft.pause());
        // Al soltar el raton continua la animacion
        root.setOnMouseReleased(e -> ft.play());
        
        // Creamos la escena
        Scene scene = new Scene(root, 540, 400);
        
        // Establecemos titulo, establecemos la escena que se va a ver, y mostramos el escenario
        primaryStage.setTitle("Fade Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     * Main, con el lanzador de la aplicacion
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
