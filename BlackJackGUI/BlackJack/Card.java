package BlackJack;

public class Card {

	private int cardID;
	final int maxSuit = 13;
	private String suit;
	private String rank;
	private int cardValue=0;
	private String cardFullName;
	
	
	public Card(int x){
		cardID=x;
		rank = getRank();
		suit = getSuit();
		cardValue=getInitialValue();
		
	}
	
	public int getInitialValue(){
		int rankMod = cardID % maxSuit;
		
		switch (rankMod)
		{
		case 0:	cardValue=11;	break;
		case 1:	cardValue=2;	break;
		case 2:	cardValue=3;	break;
		case 3:	cardValue=4;	break;
		case 4:	cardValue=5;	break;
		case 5:	cardValue=6;	break;
		case 6:	cardValue=7;	break;
		case 7:	cardValue=8;	break;
		case 8:	cardValue=9;	break;
		case 9:	cardValue=10;	break;
		case 10:cardValue=10;	break;
		case 11:cardValue=10;	break;
		case 12:cardValue=10;	break;
		}
		return cardValue;
	}	
	
	public String getRank(){ //gets String rank and sets int cardValue
		int rankMod = cardID % maxSuit;
		String tempRank = null;
		switch (rankMod)
		{
		case 0:		tempRank = "Ace";	break;
		case 1:		tempRank = "Two";	break;
		case 2:		tempRank = "Three";	break;
		case 3:		tempRank = "Four";	break;
		case 4:		tempRank = "Five";	break;
		case 5:		tempRank = "Six";	break;
		case 6:		tempRank = "Seven";	break;
		case 7:		tempRank = "Eight";	break;
		case 8:		tempRank = "Nine";	break;
		case 9:		tempRank = "Ten";	break;
		case 10:	tempRank = "Jack";	break;
		case 11:	tempRank = "Queen";	break;
		case 12:	tempRank = "King";	break;
		}
		return tempRank;
	}
	public String getSuit(){
		String tempSuit = null;
		if ((cardID>=0)&&(cardID<=12))
			tempSuit = "Clubs";
		else if ((cardID>=13)&&(cardID<=25))
			tempSuit = "Diamonds";
		else if ((cardID>=26)&&(cardID<=38))
			tempSuit = "Hearts";
		else if ((cardID>=39)&&(cardID<=51))
			tempSuit = "Spades";
		return tempSuit;
	}
	public int getValue21(){
		if (cardValue>0)
			return cardValue;
		else if (cardValue==0)
			cardValue = getInitialValue();
			return cardValue;
	}
	public int changeAce(){
		if ((cardValue==11)&&(rank.equalsIgnoreCase("Ace")))
			cardValue=1;
		return cardValue;
	}
	public String getFQN(){
		
		cardFullName = rank+" of "+suit+" with a value of "+cardValue;
		return cardFullName;
	}
}

