package Factory;
import Product.*;

public abstract class Application {
	
	public void operation() {
		
		Document doc = createDocument();
		doc.open();
		doc.save();
		doc.close();
	}
	
	public abstract Document createDocument();

}
