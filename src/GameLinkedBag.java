/**
 * Will be a collection class that will store game element in a linked list.
 * @author chris Lara-Betancourt 
 * 
 *
 */
public class GameLinkedBag {
	private GameNode head;
	private int manyItems;
	
	public GameLinkedBag() {
		head = null;
		manyItems = 0;
	}
	/**
	 * Finds the size of a linked list.
	 * @return the size of a linked list.
	 */
	public int size() {
		return manyItems;
	}
	/**
	 * Will the display the element in a linked list.
	 */
	public void display() {
		GameNode temp = head;
		while (temp !=null) {
			System.out.println(temp.getData().toString());
			temp = temp.getLink();
		}
	}
	/**
	 * Will add new element into the linked list.
	 * @param game is the new element the user wants to add.
	 */
	public void add(Game game) {
		if(manyItems == 0) {
		head = new GameNode(game);
		manyItems++;
		}
		else {
            GameNode temp = head;

            while(temp.getLink() != null) {
                temp = temp.getLink();
                
            }
            temp.setLink(new GameNode(game));
            manyItems++;
            
        }
	}
	
//	public void add(int position, Game game) {
//		GameLinkedBag newLinked;
//		if(manyItems < position) {
//			add(game);
//		}
//		else if(position < 0 ) {
//			return;
//		}else {
//			GameNode temp = head;
//			for(int i = 0; i< position; i++) {
//				temp = temp.getLink();
//			}
//			GameNode currentSpot = temp.getLink();
//			temp.setLink(new GameNode(game));
//			temp = temp.getLink();
//			
//			while(temp.getLink()!= null) {
//				temp.setLink(currentSpot);
//				temp = currentSpot;
//			}
//			
//		}
//	}
	/**
	 * A second add method that will overload the first add method by taking in two parameters.
	 * @param position the place at which the user wants to store the new element in the linked  list.
	 * @param game is the game object the user wants to add.
	 */
	public void add(int position, Game game) {
		if(manyItems < position) {
			add(game);
			manyItems++;
		}
		else if(position < 0 ) {
			return;
	}else {
		GameNode temp = head;
		for(int i = 0; i< position; i++) {
			temp = temp.getLink();
		}
		GameNode add = new GameNode(game);
		GameNode current = temp.getLink();
		
		add.setLink(current);
		temp.setLink(add);
		manyItems++;
		}
		
	}
	/**
	 * Will a game to the end of the linked list.
	 * @param game is the game object the user wants to add.
	 */
	public void addLast(Game game) {
		GameNode temp = head;
		GameNode add = new GameNode(game);
		while(temp.getLink()!= null) {
			temp = temp.getLink();
		}
		temp.setLink(add);
		manyItems++;
	}
	/**
	 * Will remove a element from the linked list.
	 * @param game is the game object the user wants to remove.
	 * @return Will return true or false if the element was removed.
	 */
	public boolean remove(Game game) {
		GameNode temp = head;
		GameNode previous = null;
		boolean isTrue = false;
		while(temp.getLink()!= null) {
			if(temp.getData().equals(game)) {
				previous.setLink(previous.getLink().getLink());
				isTrue = true;
				manyItems--;
				return isTrue;
			}
			previous = temp;
			temp = temp.getLink();
		}
		return isTrue;
	}
	/**
	 * This method will remove a element from a linked list based on the position the user entered.
	 * @param index is the position at which the user wants to remove a element at.
	 * @return Will return true or false based on if the element was removed.
	 */
	public boolean remove(int index) {
		GameNode temp = head;
		GameNode previous = null;
		boolean isTrue = false;
		for(int i = 1; i<= index; i++) {
			if(i== index) {
				previous.setLink(temp.getLink());
				isTrue = true;
				manyItems--;
			}
			previous = temp;
			temp = temp.getLink();
		}
		return isTrue;
	}
	/**
	 * Will remove the last element in the linked list.
	 */
	public void removeLast() {//needs work
		if(head == null|| head.getLink()== null) {
			head = null;
			manyItems = 0;
		}else {
		
		GameNode last = head.getLink();
		GameNode secondToLast = head;
		while(last.getLink()!= null) {
			secondToLast = last;
			last = last.getLink();
		}
		secondToLast.setLink(null);
	      manyItems--;
	      
		}  
	}
	/**
	 * Will grab a element at position the user wants.
	 * @param position is the place the user wants to grab the element at.
	 * @return Will return the element stored at the position.
	 */
	public Game grab(int position) {
		GameNode temp = head;
		int i = 0;
		Game atPosition = null;
		while(temp!= null && i < position) {
			atPosition = temp.getData();
			temp = temp.getLink();
			i++;
		}
		
		return atPosition;
	}
	/**
	 * Will return the position at which the element is stored.
	 * @param game is the game object the user wants to find.
	 * @return will return the position of the game.
	 */
	public int positionOf(Game game) {
		int index = 0;
		boolean isTrue = false;
		GameNode temp = head;
		int i = 0;
		
		while(temp!= null) {
			isTrue = temp.getData().equals(game);
			if(isTrue) {
				index = i;
			}
			i++;
			temp = temp.getLink();
		}
		return index;
	}
	/**
	 * Will replace a game element with a different game element based on the position the user passed in.
	 * @param num is the position the user passed in.
	 * @param game is the game that will replace the current game.
	 */
	public void set(int num, Game game) {
		GameNode temp = head;
		for(int i = 1; i< num; i++) {
			temp = temp.getLink();
		}
		temp.setData(game);
	}
	/**
	 * Will return the total number of copies of the whole linked list.
	 * @return will return the sum.
	 */
	public int totalValue() {
		GameNode temp = head;
		int sum = 0;
		while(temp!=null) {
			sum += temp.getData().getCopies();
			temp = temp.getLink();
		}
		return sum;
	}
	/**
	 * Will return the max element in the linked list.
	 * @return Will return the max element in the linked list.
	 */
	public Game getMax() {
		GameNode temp = head, max = head;
		
		while(temp.getLink()!= null) {
			if(max.getData().compareTo(temp.getData())>0){
				max = temp;
			}
			temp = temp.getLink();
		}
		return max.getData();
	}
	
	
	
	

}
