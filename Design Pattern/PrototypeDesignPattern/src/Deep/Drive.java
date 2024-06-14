package Deep;

public class Drive {

    public static void main(String[] args) {
        
        Font font1 = new Font("Arial", 12);
        
        Rectangle rectangle1 = new Rectangle();
        rectangle1.borderSize = 2;
        rectangle1.color = "Red";
        rectangle1.height = 4;
        rectangle1.width = 7;
        rectangle1.font = font1;
        
        System.out.println("Red Rectangle:\n" + rectangle1);
        
        Rectangle copyRectangle1 = (Rectangle) rectangle1.clone();
        
        System.out.println("Clone of Red Rectangle:\n" + copyRectangle1);
        
        System.out.println("Green Rectangle creating using clone");
        
        Rectangle copyRectangle2 = (Rectangle) rectangle1.clone();
        copyRectangle2.color = "Green";
        copyRectangle2.font.setFontName("Times New Roman");
        
        System.out.println("Red Rectangle:\n" + rectangle1);
        System.out.println("Green Clone of Red Rectangle:\n" + copyRectangle2);
    }
}
