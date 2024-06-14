package Factory;

import Product.*;

public class CsvApplication extends Application {
	
	public Document createDocument() {
		return new CsvDocument();
	}
}
