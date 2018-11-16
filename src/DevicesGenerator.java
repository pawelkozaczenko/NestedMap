import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class DevicesGenerator {
	
	public Map<String, Map<Device,Integer>> generateAggreteSet(){
		Map<String, Map<Device,Integer>> result = new HashMap<>();
		for (int entry = 0; entry < 14; entry++) {
			fillAggregateSetWithRandomEntry(result);
		}
		return result;
	}
	
	private void fillAggregateSetWithRandomEntry(Map<String, Map<Device,Integer>> aggreateSet){
		String subSetId = generateString();
		Map<Device,Integer> subSet = generateSubSet();
		aggreateSet.put(subSetId, subSet);
	}
	
	private String generateString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
	
	private Map<Device,Integer> generateSubSet(){
		Map<Device,Integer> result = new HashMap<>();
		int randomEntryNumber = getRandomIntTo10();
		for (int entry = 0; entry < randomEntryNumber; entry++) {
			fillSubSetWithRandomEntry(result);
		}
		return result;
	}
	
	private void fillSubSetWithRandomEntry(Map<Device,Integer> subset) {
		Device randomDevice = generateRandomDevice();
		Integer randomDeviceCount = getRandomIntTo100();
		subset.put(randomDevice, randomDeviceCount);
	}
	
	private Device generateRandomDevice(){
		int randomMf = getRandomIntTo100();
		int randomType = getRandomIntTo100();
		Date now = new Date();
		long nowInLong = now.getTime();
		return new Device(randomMf, randomType, nowInLong);
	}
	
	private int getRandomIntTo100(){
		Random random = new Random(); 
		return 1 + random.nextInt(100);
	}
	
	private int getRandomIntTo10(){
		Random random = new Random(); 
		return 1 + random.nextInt(10);
	}
	
	

}
