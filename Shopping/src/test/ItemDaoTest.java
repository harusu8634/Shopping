package test;

import java.util.List;
import model.Item;
import model.ItemDao;

public class ItemDaoTest {
 public static void main(String[] args) {
	//itemが見つからない場合と見つかる場合のテスト
	//データベースの要素を追加したり空にしたりして行う
	 testFindAll(); 
 }

 	public static void testFindAll() {
 		ItemDao dao = new ItemDao();
  		List<Item> result = dao.findAll();
  		if(result == null) { 
  			System.out.println("SQLException");
  		} else if(result.size() == 0){
  			System.out.println("リストはからっぽ！");
  		} else {
  			for (Item item : result) {
  			System.out.println(item.getName());
  			}
  		}
 	}

}
