package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.PlayDirection;

//You CAN modify the first line
public class ReverseCard extends EffectCard {
    //Constructor
    public ReverseCard(CardColor color){
        super(color, CardSymbol.REVERSE);
    }

    //Method
    public String toString(){return this.getColor().toString() + " " + this.getSymbol().toString();}
    public boolean canPlay(){
        if(this.getColor() == GameLogic.getInstance().getTopCard().getColor() || this.getSymbol() == GameLogic.getInstance().getTopCard().getSymbol()){
            return true;
        }
        else{
            return false;
        }
    }

    public String performEffect(){
        PlayDirection direction = GameLogic.getInstance().getPlayDirection();
        direction = direction.getOpposite();
        GameLogic.getInstance().setPlayDirection(direction);
        return "Set direction to " + direction.toString();
    }

}
