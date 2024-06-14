package SingletonDesign;

public class Drive {

	public static void main(String[] args) {
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 != obj2) {
			System.out.println("Two object has been created");
		}
		else {
			System.out.println("Only one object has been created");
		}

	}

}
