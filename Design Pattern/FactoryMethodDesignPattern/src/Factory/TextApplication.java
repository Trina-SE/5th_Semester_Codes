package Factory;
import Product.*;

public class TextApplication extends Application {
	public Document createDocument() {
		return new TextDocument();
	}
}
