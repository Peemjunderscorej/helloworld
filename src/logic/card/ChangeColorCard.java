package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class ChangeColorCard extends EffectCard{
    //@Override
    //Constructor
    public ChangeColorCard(){
        super(null, CardSymbol.CHANGE_COLOR);
    }

    //Method
    public String toString(){
        if(this.getColor() == null){
            return "CHANGE COLOR";
        }
        else{
            return "CHANGE COLOR " +"(" + this.getColor().toString() + " color selected)";
        }
    }
    public boolean canPlay(){
        return true;
    }

    public String performEffect(){
        if(GameLogic.getInstance().getCurrentPlayerHand().get(0) instanceof ChangeColorCard || GameLogic.getInstance().getCurrentPlayerHand().get(0) instanceof DrawFourCard || GameLogic.getInstance().getCurrentPlayerHand().isEmpty()  ){
            CardColor changeColor = CardColor.RED;
            setColor(changeColor);
            return "Set color to " + changeColor.toString();
        }
        else{
            CardColor changeColor = GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor();
            setColor(changeColor);
            return "Set color to " + changeColor.toString();
        }
    }
}
