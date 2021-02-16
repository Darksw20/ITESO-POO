package structures;

import java.util.Random;

public class Deck {
	public static String[] suits = { "Spades", "Hearths", "Diamonds", "Clubs" };
	public static String[] ranks = { "ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	//Definimos la baraja (un arreglo de enteros del 0 al 51)
	public int deck[] = new int[52];
	
	//Inicializa los valores del deck
	public void Init() {
		for(int i=0;i < 52;i++) {
			this.deck[i] = i;
		}
	}
	
	//Imprime el deck
	public void Print() {
		for(int i=0;i<52;i++) {
			System.out.println(ranks[this.deck[i]%(int)13]+" of " + suits[this.deck[i]/(int)13]);			
		}
	}
	
	//Barajea las cartas con el metodo Fisher-Yates
	public void Shuffle() {
		Random rnd = new Random();
		for(int i=51;i>0;i--) {
			int index = rnd.nextInt(i+1);
			int temp = this.deck[index];
			this.deck[index] = this.deck[i];
			this.deck[i] = temp;
		}
	}
	public static Deck newDeck() {
		Deck deck = new Deck();
		deck.Init();
		//deck.Print();
		deck.Shuffle();
		//System.out.println("\n\nBaraja Revuelta\n\n");
		//deck.Print();
		return deck;
	}

	public int getCard() {
		for(int i=0;i<52;i++) {
			int card = this.deck[i];
			if(card != -1) {
				this.deck[i] = -1;
				return card;	
			}
		}
		return -1;
	}
}
