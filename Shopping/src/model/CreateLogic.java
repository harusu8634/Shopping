package model;

public class CreateLogic {
	public void execute(Item item) {
	ItemDao dao = new ItemDao();
	dao.insertOne(item);
	}
}
