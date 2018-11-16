import java.util.Date;

public class ExtendedDevice {
	
	private Device device;
	//hashCode from Device
	private int deviceId;
	//value from subcollection of Devices 
	private long numberOfDevices;
	//key from aggregate collection of Devices
	private String deviceSubsetSetId;
	
	public ExtendedDevice(Device device, long numberOfDevices, String deviceSubsetSetId){
		this.device = device;
		this.deviceId = device.hashCode();
		this.numberOfDevices = numberOfDevices;
		this.deviceSubsetSetId = deviceSubsetSetId;
	}

	public int getMf(){
		return device.getMf();
	}

	public int getType() {
		return device.getType();
	}

	public long getDate(){
		return device.getDate();
	}

	public int getDeviceId(){
		return deviceId;
	}

	public String getDeviceSubsetSetId(){
		return deviceSubsetSetId;
	}

	public long getNumberOfDevices(){
		return numberOfDevices;
	}
	
	@Override
	public String toString(){
		//Look at overshadowin local field date :)!!!
		return String.format("%s, deviceId: %s, numberOfDevices: %s, deviceSubsetSetId: %s", 
				device.toString(), deviceId, numberOfDevices, deviceSubsetSetId);
	}
	
}
