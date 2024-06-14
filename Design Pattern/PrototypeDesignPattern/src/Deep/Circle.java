package Deep;

public class Circle extends Shape {
	
	public int radius;
	
	public Circle() {
		
	}
	
	public Circle(Circle circle,Font font) {

          super(circle,font);
          
          if(circle != null) {
        	  this.radius = circle.radius;
          }
	}

	@Override
	public Shape clone()
	{
		Font fontCopy=this.font.clone();
		return new Circle (this,fontCopy);
	}
	
	public String toString() {
		return "Radius:"+radius+",Color:"+color+",Border Size:"+borderSize+"||Font["+font+"]\n";
	}

	
	

}
