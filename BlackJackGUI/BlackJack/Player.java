package BlackJack;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
ArrayList<Card> hand= new ArrayList<>(2);
private int hold=17;
private boolean ace;
private boolean hit;
private boolean AI;
private boolean bust;
private int aceindex;
Boolean acechecked=false;

public Player(int staylvl){
	setHold(staylvl);
	AIorPlayer();
	
}
public Player(){
	AI=false;
}

public boolean AIorPlayer(){
	if (getHold()>21)
		AI=true;
	else
		AI=false;
	return AI;
}
public void runLogic(){
	checkAces();
	hitMe();
	bust =checkBust();
	
}
public void addCardtoHand(Card x){
	hand.add(x);
}
public void showHand(){
	for (int i=0;i<hand.size();i++)
		System.out.println(hand.get(i).getFQN());
}
public String stringHand(){
	String sHand="";
	for(int i=0;i<hand.size();i++)
		sHand+=hand.get(i).getFQN()+", \n";
	return sHand;
}
public Boolean checkBust(){
	int check = getHandCount();
	
	if (check<=21)
		bust=false;
	else if ((check>21)&&(!acechecked)&&(ace))
		{
		checkAces();
		hand.get(aceindex).changeAce();
		acechecked = true;
		checkBust();
		}
	else if(check>21)
		bust=true;
	return bust;
}
public int getHandCount(){
	int total=0;
	for (int i=0;i<hand.size();i++)
		total+=hand.get(i).getValue21();
	return total;
}
public void checkAces(){
	for (int i=0;i<hand.size();i++)
		if (hand.get(i).getRank().equals("Ace"))
			{
			ace = true;
			aceindex=i;
			}
}

public boolean hitMe(){
	if (getHandCount()<getHold())
		hit = true;
	else
		hit = false;
	return hit;
}
public void addHit(Card x){
	if (hit)
	{
		addCardtoHand(x);
		//Request card from dealer or dealer checks if player wants to hit I suppose.
		//Add card to hand
		runLogic();
	}
	else if (!hit)
	{
		System.out.println("Error: Can't call addHit() if !hit! I'm not supposed to run!");
	}
}

public int getHold() {
	return hold; //added to manipulate hold value for dealer class 
}

public void setHold(int hold) {
	this.hold = hold;
}
public void requestHold(){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter player hold limit: ");
	hold = input.nextInt();
	input.close();
	;
	
	
}
public boolean getHit(){
	return hit;
}

}
