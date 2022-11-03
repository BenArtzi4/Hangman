package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Controller {

    @FXML
    private Canvas cnv;

    public GraphicsContext gc;

    public void initialize()
    {
        gc = cnv.getGraphicsContext2D();
    }



}
