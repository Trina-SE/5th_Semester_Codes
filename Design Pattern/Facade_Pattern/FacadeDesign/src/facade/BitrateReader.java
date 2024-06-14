package facade;

public class BitrateReader {
	public static videoFile read(videoFile file, Codec codec) {
		System.out.println("BitrateReader: reading file...");
		return file;
	}
	
	public static videoFile convert(videoFile buffer, Codec codec) {
		System.out.println("BitrateReader: writing file...");
		return buffer;
	}
}
