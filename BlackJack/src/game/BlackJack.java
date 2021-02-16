package game;

import javax.swing.JOptionPane;

import structures.Deck;
import structures.User;

public class BlackJack {
	public static boolean turn = true;
	public static int apuesta = 0;
	public static Deck deck;
	public static User user;
	public static User house;
	public static boolean exit = true;
	public static boolean exitGame = true;
	
	public static void main(String[] args) {
		do {
			initilize();
			int election = JOptionPane.showOptionDialog(null, 
					"¿Desea iniciar el juego?\nTu saldo es de: "+user.reserve, 
					"Ronda", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, null, 
					null, null);
			if(election == 1) {
				exit = false;
				exitGame = false;
			}else {
				String[] botones = {"50","100"};
				int betInTurn = JOptionPane.showOptionDialog(null, 
						"¿Cuanto deseas apostar?", 
						"Menu", 
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, 
						botones, botones[0]);
				bet(betInTurn == 0?50:100);
			}
			while(exit) {
				turn();
			}
			System.out.println("Apuesta: "+apuesta);
			reset();
		}while(exitGame);
	}
	
	public static void reset() {
		user.hand = new int[5];
		user.hand[0] = -1;
		user.hand[1] = -1;
		user.hand[2] = -1;
		user.hand[3] = -1;
		user.hand[4] = -1;
		house.hand = new int[5];
		house.hand[0] = -1;
		house.hand[1] = -1;
		house.hand[2] = -1;
		house.hand[3] = -1;
		house.hand[4] = -1;
		deck = Deck.newDeck();
	}
	
	public static void initilize() {
		exit = true;
		deck = Deck.newDeck();
		house = User.newHouse();
		user = User.newUser();
		user.addCard(deck.getCard());
		user.addCard(deck.getCard());
		house.addCard(deck.getCard());
		house.addCard(deck.getCard());
	}
	
	public static void bet(int dineros) {
		apuesta += user.bet(dineros);
		apuesta += house.bet(dineros);
		System.out.println("Apuesta: "+apuesta);
	}
	
	public static void turn() {
		if(turn) {
			//le va al usuario
			int points = user.cardCount();
			if(points > 21) {
				//pierde
				JOptionPane.showMessageDialog(null, user.name + " perdio con "+points+ " puntos", null, JOptionPane.ERROR_MESSAGE);
				exit = false;
			}else if(points == house.cardCount()) {
				//empate
				int BJ = apuesta/2;
				apuesta = user.payment(BJ);
				apuesta = house.payment(BJ);
				JOptionPane.showMessageDialog(null, "Quedaron en empate", null, JOptionPane.ERROR_MESSAGE);
				exit = false;
			}else if(points == -1) {
				//Gano por regla del BlackJack
				int BJ = apuesta/2;
				apuesta += house.bet(BJ*4);
				apuesta = user.payment(apuesta);
				JOptionPane.showMessageDialog(null, "Ganas por BlackJack", null, JOptionPane.INFORMATION_MESSAGE);
				exit = false;
			}else if(points < 21 && user.handCards == 5) {
				//Gana
				apuesta = user.payment(apuesta);
				JOptionPane.showMessageDialog(null, "Ganaste", null, JOptionPane.INFORMATION_MESSAGE);
				exit = false;
			}else if(points == 21) {
				//Gana
				apuesta = user.payment(apuesta);
				JOptionPane.showMessageDialog(null, "Ganaste", null, JOptionPane.INFORMATION_MESSAGE);
				exit = false;
			}else {
				int pass = user.showHand(user.name);
				if(pass == 1) {
					user.addCard(deck.getCard());										
				}
			}
		}else {
			//le va a la casa
			int points = house.cardCount();
			if(points > 21) {
				//pierde
				JOptionPane.showMessageDialog(null, house.name + " perdio con "+ points + " puntos", null, JOptionPane.ERROR_MESSAGE);
				exit = false;
			}else if(points == user.cardCount()) {
				//empate
				int BJ = apuesta/2;
				apuesta = user.payment(BJ);
				JOptionPane.showMessageDialog(null, "Quedaron en empate", null, JOptionPane.ERROR_MESSAGE);
				apuesta = house.payment(BJ);
				exit = false;
			}else if(points == -1) {
				//Gano por regla del BlackJack
				apuesta = house.payment(apuesta);
				JOptionPane.showMessageDialog(null, "Gano house por BlackJack", null, JOptionPane.INFORMATION_MESSAGE);
				exit = false;
			}else if(points < 21 && house.handCards == 5) {
				//Gana
				apuesta = house.payment(apuesta);
				JOptionPane.showMessageDialog(null, "Gano house", null, JOptionPane.INFORMATION_MESSAGE);
				exit = false;
			}else if(points == 21) {
				//Gana
				apuesta = house.payment(apuesta);
				JOptionPane.showMessageDialog(null, "Gano house", null, JOptionPane.INFORMATION_MESSAGE);
				exit = false;
			}else {
				house.showHouseHand(house.name);				
			}
			if(points <= 15) {
				house.addCard(deck.getCard());				
			}
		}
		turn = !turn;
	}
}
