/**
 * 
 * @author chris Lara-Betancourt 
 * This class will be creating a link and data field to help the bag class store game data and link it to other data.
 * 
 *
 */
public class GameNode {
	private Game data;
	private GameNode link;
	
	public GameNode(Game data) {
		this.data = data;
		this.link = null;
	}
	
	public Game getData() {
		return data;
	}
	
	public void setData(Game data) {
		this.data = data;
	}
	
	public GameNode getLink() {
		return link;
	}
	
	public void setLink(GameNode link) {
		this.link = link;
	}
	
	public void addNodeAfter(Game element){
		this.link = new GameNode(element);	//maybe add link
	}
	
	public void removeNodeAfter(){
		this.link = this.link.link;
	}
	/**
	 * Will take a game node object and traverse it to print out the data to the user.
	 * @param list
	 */
	public static void display(GameNode list){
		GameNode cursor = list;
		while (cursor != null){
			System.out.println(cursor.data);
			cursor = cursor.getLink();
		}
	}
	/**
	 * 
	 * @param head is the object being passed in.
	 * @return Will return the length of the linked list.
	 */
	public static int listLength(GameNode head){
		GameNode cursor = head;
		int length = 0;
		
		while (cursor != null){
			length++;
			cursor = cursor.getLink();
		}
		return length;
	}
	
	/**
	 * This method will just search the linked list for a game element.
	 * @param head the game node object being passed in.
	 * @param target is the game object being passed in.
	 * @return will return game data if found or null.
	 */
	public static GameNode listSearch(GameNode head, Game target){
		GameNode cursor = head;
		while (cursor != null){
			if (cursor.getData() == target)
				return cursor;
			cursor = cursor.getLink();
		}
		return null;
	}
	/**
	 * This method will give the element stored at a certain position
	 * @param head is the game node being passed in.
	 * @param position the integer being passed in to look for the position.
	 * @return will return what is stored at certain position.
	 */
	public static GameNode listPosition(GameNode head, int position){
		GameNode cursor = head;
		int index = 1;
		while (cursor != null && index < position){
			index++;
			cursor = cursor.getLink();
		}
		return cursor;
	}






	
	

}
