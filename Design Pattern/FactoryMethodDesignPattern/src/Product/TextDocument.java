package Product;

public class TextDocument implements Document {
	
	public void open() {
		System.out.println("Text Document has opened Successfully!");
	}
	public void close() {
		System.out.println("Text Document has closed Successfully!");
	}
	public void save() {
		System.out.println("Text Document has saved Successfully!");
	}

}
