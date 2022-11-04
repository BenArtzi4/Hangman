package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Organ
{
    int x1;
    int y1;
    int x2;
    int y2;
    boolean show;

    public Organ(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        show = false;
    }

    public void display(GraphicsContext input)
    {
        this.show = true;
        input.setStroke(Color.BLACK);
        input.strokeLine(this.x1, this.y1, this.x2, this.y2);
        System.out.println("drawing!!!");
    }

    public void remove(GraphicsContext input)
    {
        this.show = true;
        input.setStroke(Color.WHITE);
        input.strokeLine(this.x1, this.y1, this.x2, this.y2);
    }
}
