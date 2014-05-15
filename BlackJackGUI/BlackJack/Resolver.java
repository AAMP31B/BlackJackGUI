package BlackJack;

public class Resolver {

private Boolean dealerWin;
private Boolean playerWin;
private Player storage;
private Boolean playerBust;
private Boolean dealerBust;

public Resolver(Dealer deal, Player play){
	decideWinner(deal, play);//This method decides the winner when the class is constructed
}
	
public void decideWinner(Dealer deal, Player play)
//This could be done with a switch statement might change it over later
{
	deal.runLogic();play.runLogic();
	setDealerBust(deal.checkBust());
	setPlayerBust(play.checkBust());
	storage=play;
	
	if ((deal.checkBust())&&(play.checkBust()))
	{
		setDealerWin(false);
		setPlayerWin(false);
	}
	else if ((!deal.checkBust())&&play.checkBust())
	{
		setDealerWin(true);
		setPlayerWin(false);
	}
	else if ((deal.checkBust())&&!play.checkBust())
	{
		setDealerWin(false);
		setPlayerWin(true);
	}
	else if ((!deal.checkBust())&&!play.checkBust())
		{
			if (deal.getHandCount()>=play.getHandCount())
		
			{
				setDealerWin(true);
				setPlayerWin(false);
			}
			else if (deal.getHandCount()<play.getHandCount())
			{
				setDealerWin(false);
				setPlayerWin(true);
			}
		}
	}

public String getWinner(){
	String winner = "";
	if (dealerWin)
		winner = "Dealer wins";
	if (playerWin)
		winner = "Player wins";
	//can add in additional conditions for broadcasting busts.
	if (((!playerWin)&&(!dealerWin))&&((playerBust)&&(dealerBust)))
		winner="Both player and dealer busted!";
	return winner;
}

public Boolean getDealerWin() {
	return dealerWin;
}

public Boolean setDealerWin(Boolean dealerWin) {
	this.dealerWin = dealerWin;
	return dealerWin;
}

public Boolean getPlayerWin() {
	return playerWin;
}

public Boolean setPlayerWin(Boolean playerWin) {
	this.playerWin = playerWin;
	return playerWin;
}
public Player returnPlayer(){
	return storage;
}
public void setPlayerBust(boolean x){
	playerBust=x;
}
public void setDealerBust(boolean x){
	dealerBust=x;
}
}
