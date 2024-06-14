package Drive;
import java.io.File;

import Decorator.*;

public class Client {
	
	    public static void main(String[] args) {
	        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
	        
	        File outputDir = new File("out");
	        if (!outputDir.exists()) {
	            outputDir.mkdirs();
	        }
	        
	        DataSourceDecorator encoded = new CompressionDecorator(
	                                         new EncryptionDecorator(
	                                             new FileDataSource("out/OutputDemo.txt")));
	        encoded.writeData(salaryRecords);
	        DataSource plain = new FileDataSource("out/OutputDemo.txt");

	        System.out.println("- Input ----------------");
	        System.out.println(salaryRecords);
	        System.out.println("- Encoded --------------");
	        System.out.println(plain.readData());
	        System.out.println("- Decoded --------------");
	        System.out.println(encoded.readData());
	    }
	}

