package Drive;
import Product.*;
import Factory.*;
import java.util.Scanner;

public class Client {
	
	public static void main(String[]args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the type of your Document(CSV Or Text)?");
		String documentType = scanner.nextLine();
		
		  Application application;
		
		if(documentType.equalsIgnoreCase("CSV")) {
			application = new CsvApplication();
		}
		else {
			application = new TextApplication();
		}
		
	   application.operation();
		
		
	}

}
