package Devices;

public interface Device {
	
	boolean isEnabled();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();

}
