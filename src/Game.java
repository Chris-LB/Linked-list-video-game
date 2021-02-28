
public class Game implements Comparable<Game> {
	private String game;
	private int copies;
	
	public Game(String game, int copies) {
		this.game = game;
		this.copies = copies;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	@Override
	public String toString() {
		return "Game [game=" + game + ", copies=" + copies + "]";
	}
	
	public boolean equals(Game other) {
		if(game.equalsIgnoreCase(other.getGame())&& copies == other.getCopies()) {
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public int compareTo(Game other) {
		int value = 0;
		int compareInt = game.compareTo(other.game);
		if(compareInt<0) {
			value = -1;//original game comes before other game
		}
		else if(compareInt>0) {
			value = 1; //other game comes before original game 
		}
		else if(compareInt==0) {
			if(copies == other.copies) {
				value = 0;//They are equal
			}
			else if(copies < other.copies) {
				value = -1;//year comes before other year
			}
			else if(copies > other.copies) {
				value = 1;//other year comes before year
			}
			value = 0;
		}
		return value;
	}

}
