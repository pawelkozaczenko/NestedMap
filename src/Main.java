import java.util.List;
import java.util.Map;

public class Main {
	//this should be injected in Spring Controller!!!!!
	private static DevicesGenerator generator = new DevicesGenerator();
	private static DevicesOperator operator = new DevicesOperator();
	
	public static void main(String[] args) {
		Map<String, Map<Device,Integer>> aggreateSet = generator.generateAggreteSet(); 
		operator.printAggregateSet(aggreateSet);
		List<ExtendedDevice> flatSet = operator.transformAggregateSetToFlatSet(aggreateSet);
		operator.printFlatSet(flatSet);
	}
}