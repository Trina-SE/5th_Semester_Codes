package Deep;

public class Rectangle extends Shape {

    public int height;
    public int width;
    
    public Rectangle() {
    }
    
    public Rectangle(Rectangle rectangle, Font font) {
        super(rectangle, font);
        if (rectangle != null) {
            this.height = rectangle.height;
            this.width = rectangle.width;
        }
    }

    @Override
    public Shape clone() {
        Font fontCopy = this.font.clone();
        return new Rectangle(this, fontCopy);
    }
    
    @Override
    public String toString() {
        return "Width: " + width + ", Height: " + height + ", Color: " + color + ", Border Size: " + borderSize + " || Font[" + font + "]\n";
    }
}
