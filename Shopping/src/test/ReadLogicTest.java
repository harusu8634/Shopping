package test;

import java.util.List;

import model.Item;
import model.ReadLogic;

public class ReadLogicTest {
	public static void main(String[] args) {
		testReadLogic();
	}
	
	public static void testReadLogic() {
		ReadLogic readLogic = new ReadLogic();
		List<Item> result = readLogic.execute();
		
		if(result != null) {
			for(Item item : result) {
				System.out.println(item.getName());
			}
		} else {
			System.out.println("SQLException");
		}
	}
}