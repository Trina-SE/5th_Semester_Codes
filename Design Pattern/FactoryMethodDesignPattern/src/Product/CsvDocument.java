package Product;

public class CsvDocument implements Document {
       
	public void open() {
		System.out.println("CSV Document has opened Successfully!");
	}
	public void close() {
		System.out.println("CSV Document has closed Successfully!");
	}
	public void save() {
		System.out.println("CSV Document has saved Successfully!");
	}
}
