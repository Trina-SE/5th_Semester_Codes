package Deep;

public abstract class Shape {
    
    public String color;
    public int borderSize;
    public Font font;
    
    public Shape() {
    }

    public Shape(Shape shape, Font font) {
        if (shape != null) {
            this.color = shape.color;
            this.borderSize = shape.borderSize;
            this.font = font;
        }
    }

    public abstract Shape clone();
}
