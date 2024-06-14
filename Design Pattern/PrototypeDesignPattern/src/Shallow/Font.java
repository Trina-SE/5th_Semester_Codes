package Shallow;

public class Font {
	
	private String fontName;
	private int fontSize;
	
	public Font(String fontName,int fontSize) {
		
		this.fontName = fontName;
		this.fontSize = fontSize;		
	}
	
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public double getFontSize() {
		return fontSize;
	}
	public void setFontSize(int forntSize) {
		this.fontSize = forntSize;
	}
	
	public String toString() {
		return "Font Name:"+fontName+",Font Size:"+fontSize;
	}

}
