package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Head extends Organ
{
    public Head()
    {
        super(220,70, 60, 30);
    }

    @Override
    public void display(GraphicsContext input)
    {
        this.show = true;
        input.setStroke(Color.BLACK);
        input.strokeRect(this.x1, this.y1, this.x2, this.y2);
    }

    @Override
    public void remove(GraphicsContext input)
    {
        this.show = true;
        input.setStroke(Color.WHITE);
        input.strokeRect(this.x1, this.y1, this.x2, this.y2);
    }
}
