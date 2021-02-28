
public class GameLinkedBagDriver {
	public static void main(String[] args) {
	Game godOfWar = new Game("God of War", 23);
	Game witcher = new Game("The Witcher", 45);
	Game uncharted = new Game("Uncharted", 56);
	Game batman = new Game("Batman Arkham Knight", 45);
	Game ghost = new Game("Ghost of Tushima", 78);
	Game horizon = new Game("Horizon zero dawn", 25);
	Game mincraft = new Game("Mincraft", 100);
	GameLinkedBag first = new GameLinkedBag();
	
	first.add(godOfWar);
	first.add(witcher);
	first.add(0, uncharted);
	first.add(ghost);
	first.add(mincraft);
	first.display();
	System.out.println(first.size());
	first.removeLast();
	first.display();
	System.out.println(first.grab(2));
	System.out.println(first.positionOf(witcher));
	first.set(2, batman);
	first.display();
	System.out.println(first.remove(witcher));
	first.display();
	System.out.println(first.remove(2));
	first.display();
	System.out.println(first.getMax());
	System.out.println(first.totalValue());
	first.removeLast();
	first.display();
	first.addLast(horizon);
	first.display();
	first.removeLast();
	first.display();
	
	
	
	
	}

}
