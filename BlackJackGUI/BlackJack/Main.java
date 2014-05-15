package BlackJack;

public class Main {

	public static void main(String[] args) {
		
		//test1();test2();test3();
		GUI game =new GUI();
		game.setVisible(true);
	}
	private static void startGame(){
		//new Game();
	}

	private static void test1(){
		System.out.println("Test 1");
		System.out.println("Creates cards and then has the cards show their names");
		for (int i=10;i<22;i++)
		{
			Card c = new Card(i);
			System.out.println(c.getFQN());
		}
		System.out.println();
	}
	private static void test2(){
		Dealer dealer = new Dealer(17);
		Player p = new Player(17);
		System.out.println("Test 2");
		System.out.println("Deals random cards to a player's hand and then shows the hand");
		for (int i=10;i<16;i++)
		{
			p.addCardtoHand(dealer.DealCard());
			
		}
		System.out.println(p.stringHand());
		System.out.println();
	}
	private static void test3(){
		Player p = new Player(16);
		System.out.println("Test 3");
		System.out.println("This one adds some cards to a players hand and then shows the hand and the value.");
		
		for (int i = 10; i<15;i++)
		{
			Card c = new Card(i);
			p.addCardtoHand(c);
		}
		System.out.print(p.stringHand());
		System.out.print(p.getHandCount());
	}
	private static void testX(){
		//Below was for testing an issue I had with creating ArrayList holding the deck of cards.
				//Apparently even when declared "private ArrayList<Integer> shuffledDeck = new ArrayList<>(52);" the size is still 0 until elements are added.
				//Dealer dealer = new Dealer(17);
				//for (int i=0;i<dealer.getDeck().size();i++)
				//	System.out.println(dealer.DealCard().getFQN());
	}
}
