package Deep;

public class Font {

    private String fontName;
    private int fontSize;
    
    public Font(String fontName, int fontSize) {
        this.fontName = fontName;
        this.fontSize = fontSize;
    }
    
    @Override
    public Font clone() {
        return new Font(this.fontName, this.fontSize);
    }
    
    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    
    @Override
    public String toString() {
        return "Font Name: " + fontName + ", Font Size: " + fontSize;
    }
}
