package Shallow;

public class Drive {

	public static void main(String[] args) {
		
		Font font1 = new Font ("Arial",12);
		
		Circle circle1 = new Circle();
		
		circle1.borderSize = 2;
		circle1.color = "Red";
		circle1.radius = 5;
		
		circle1.font = font1;
		
		System.out.println("Red Circle:\n"+circle1);
		
		Circle copyCircle1 = (Circle)circle1.clone();
		
		System.out.println("Clone of Red Circle:\n"+copyCircle1);
		
		System.out.println("Green Circle creating using clone");
		
		Circle copyCircle2 = (Circle)circle1.clone();
		
		copyCircle2.color = "Green";
		copyCircle2.font.setFontName("Times New Roman");
		
		System.out.println("Red Circle:\n"+circle1);
		System.out.println("Green Clone of Red Circle:\n"+copyCircle2);
		

	}

}
