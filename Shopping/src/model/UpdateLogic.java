package model;

public class UpdateLogic {
	public void execute(Item item) {
		ItemDao dao = new ItemDao();
		dao.updateOne(item);
	}
}
