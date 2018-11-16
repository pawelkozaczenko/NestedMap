import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DevicesOperator {
	
	public void printAggregateSet(Map<String, Map<Device,Integer>> aggreateSet){
		System.out.println("*******PRINTING AGGREGATE SET*********");
		int numberOfDevices = 0;
		for(Map.Entry<String, Map<Device, Integer>> aggreateSetEntry : aggreateSet.entrySet()){
	    	String primaryKey = aggreateSetEntry.getKey(); 
	        Map<Device,Integer> subSet = aggreateSetEntry.getValue(); 
	        System.out.println("===ROW IN AGGREATE SET====");
	        for(Map.Entry<Device,Integer> subSetEntry : subSet.entrySet()){
	        	printEntryOfAggregateSet(subSetEntry, primaryKey);
	        }
	        numberOfDevices += subSet.size();
	        System.out.println("==========================");
	    }
		String numberOfDevicesOutPut = 
        		String.format("*****NUMBER OF ALL DEVICES IS: %d ****", numberOfDevices);
		System.out.println(numberOfDevicesOutPut);
		System.out.println("**************************************");
	}
	
	private void printEntryOfAggregateSet(Map.Entry<Device,Integer> subSetEntry, String primaryKey){
		Device device = subSetEntry.getKey();
    	Integer numberOfDevices = subSetEntry.getValue();
    	String entryOutPut 
    		= String.format("Device %s, numberOfDevices: %s, primaryKey: %s", 
    				device.toString(), numberOfDevices, primaryKey);
    	System.out.println(entryOutPut);
	}
	
	public List<ExtendedDevice> transformAggregateSetToFlatSet(Map<String, Map<Device,Integer>> aggreateSet){
		List<ExtendedDevice> result = new LinkedList<>();
		for(Map.Entry<String, Map<Device, Integer>> aggreateSetEntry : aggreateSet.entrySet()) {
	    	String subSetKey = aggreateSetEntry.getKey(); 
	        Map<Device,Integer> subSet = aggreateSetEntry.getValue(); 
	        for(Map.Entry<Device,Integer> subSetEntry : subSet.entrySet()){
	        	ExtendedDevice extendedDevice 
	        			= createExtendedDeviceOfSubsetEntry(subSetEntry, subSetKey);
	        	result.add(extendedDevice);
	        }
	    }
		return result;
	}
	
	private ExtendedDevice createExtendedDeviceOfSubsetEntry(Map.Entry<Device,Integer> subSetEntry, String subSetKey){
		Device device = subSetEntry.getKey();
    	Integer numberOfDevices = subSetEntry.getValue();
    	return new ExtendedDevice(device, numberOfDevices, subSetKey);
	}
	
	public void printFlatSet(List<ExtendedDevice> flatSet) {
		System.out.println("*********PRINTING FLAT SET************");
		for(ExtendedDevice item: flatSet){
			String itemOutPut 
    			= String.format("ExtendedDevice %s", item.toString());
			System.out.println(itemOutPut);
	    }
		int numberOfDevices = flatSet.size();
		String numberOfDevicesOutPut = 
        		String.format("*****NUMBER OF ALL DEVICES IS: %d ****", numberOfDevices);
		System.out.println(numberOfDevicesOutPut);
		System.out.println("**************************************");
	}

}
