package structures;

import javax.swing.JOptionPane;

public class User {
	public String name;
	public int[] hand;
	public int handCards = 0;
	public int reserve = 0;
	
	public int cardCount() {
		int count = 0;
		boolean ace = false;
		boolean mono = false;
		
		for(int card: hand) {
			if(card != -1) {
				switch(Deck.ranks[card%(int)13]) {
					case "ACE":
						count += 11;
						ace = true;
						break;
					case "2":
						count += 2;
						break;
					case "3":
						count += 3;
						break;
					case "4":
						count += 4;
						break;
					case "5":
						count += 5;
						break;
					case "6":
						count += 6;
						break;
					case "7":
						count += 7;
						break;
					case "8":
						count += 8;
						break;
					case "9":
						count += 9;
						break;
					case "10":
						count += 10;
						break;
					case "J":
						count += 10;
						mono = true;
						break;
					case "Q":
						count += 10;
						mono = true;
						break;
					case "K":
						count += 10;
						mono = true;
						break;
					default:
						break;
				}
			}
		}
		return ace && mono ? -1:count;
	}
	
	
	public int bet(int apuesta) {
		this.reserve -= apuesta;
		return apuesta;
	}
	
	public int payment(int payment) {
		this.reserve += payment;
		return 0;
	}
	
	
	public static User newUser() {
		User user = new User();
		user.name = "Ricardo";
		user.reserve = 600;
		user.hand = new int[5];
		user.hand[0] = -1;
		user.hand[1] = -1;
		user.hand[2] = -1;
		user.hand[3] = -1;
		user.hand[4] = -1;
		return user;
	}
	
	public static User newHouse() {
		User house = new User();
		house.name = "House";
		house.reserve = 100000;
		house.hand = new int[5];
		house.hand[0] = -1;
		house.hand[1] = -1;
		house.hand[2] = -1;
		house.hand[3] = -1;
		house.hand[4] = -1;
		return house;
	}
	
	public int showHand(String nombre) {
		String texthand = nombre+" tiene en la mano:\n";
		int points = cardCount();
		for(int card:hand) {
			if(card != -1) {
				texthand += Deck.ranks[card%(int)13] + " de "+ Deck.suits[card/(int)13]+ "\n";				
			}
		}
		texthand += "Puntaje: " + points+ "\n¿Deseas pasar?";
		
		int seguir = JOptionPane.showOptionDialog(null, texthand, "Ronda", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		return seguir;
	}
	
	public void showHouseHand(String nombre) {
		String texthand = nombre+" tiene en la mano:\n";
		int points = cardCount();
		for(int card:hand) {
			if(card != -1) {
				texthand += Deck.ranks[card%(int)13] + " de "+ Deck.suits[card/(int)13]+ "\n";				
			}
		}
		texthand += "Puntaje: " + points;
		JOptionPane.showMessageDialog(null, texthand, null, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void addCard(int card) {
		for(int i=0;i<52;i++) {
			if(this.hand[i] == -1) {
				this.hand[i] = card;
				this.handCards++;
				break;
			}
		}
	}
	
}
