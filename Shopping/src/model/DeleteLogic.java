package model;

public class DeleteLogic {
	public void execute(int id) {
		ItemDao dao = new ItemDao();
		dao.deleteOne(id);
	}
}
