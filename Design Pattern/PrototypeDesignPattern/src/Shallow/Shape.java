package Shallow;

public abstract class Shape {
	
	public String color;
	public int borderSize;
	public Font font;

	
	public Shape() {
		
	}
	
	public Shape(Shape shape,Font font) {
		
		if(shape != null) {
			
			this.borderSize = shape.borderSize;
			this.color = shape.color;
			this.font = shape.font;
		}
	}
	
	public abstract Shape clone();

}
