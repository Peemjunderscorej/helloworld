package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;
import logic.game.GameLogic;

//You CAN modify the first line
public class NumberCard extends BaseCard {
    //Constructor
    public NumberCard(CardColor color, CardSymbol symbol){
        super(color,symbol);
    }

    //Method
    public String toString(){
        return this.getColor().toString() + " " + this.getSymbol().toString();
    }
    public boolean canPlay(){
        if(this.getColor() == GameLogic.getInstance().getTopCard().getColor() || this.getSymbol() == GameLogic.getInstance().getTopCard().getSymbol()){
            return true;
        }
        else{
            return false;
        }
    }
    public String play(){
        GameLogic.getInstance().setTopCard(GameLogic.getInstance().getCurrentPlayerHand().get(0));
        GameLogic.getInstance().getCurrentPlayerHand().remove(GameLogic.getInstance().getCurrentPlayerHand().get(0));
        return null;
    }


}
