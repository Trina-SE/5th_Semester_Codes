package Shallow;

public class Rectangle extends Shape {

    public int height;
    public int width;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Rectangle rectangle,Font font) {

          super(rectangle,font);
          
          if(rectangle != null) {
        	  this.height = height;
        	  this.width = width;
          }
	}

	@Override
	public Shape clone() {
		
		return new Rectangle(this,font);
	}

	public String toString() {
		return "Width:"+width+"\nHeight:"+height+"Color:"+color+"\nBorder Size:"+borderSize+"\n";
	}

}
