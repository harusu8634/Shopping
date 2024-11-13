package model;

import java.util.List;

public class ReadLogic {
//	public boolean execute() {
//	ItemDao dao = new ItemDao();
//	List<Item> itemList = dao.findAll();
//	return itemList != null || itemList.size() != 0;
//	}
	
	public List<Item> execute() {
		ItemDao dao = new ItemDao();
		List<Item> itemList = dao.findAll();
		return itemList;
	}
}