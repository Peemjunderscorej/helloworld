package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class SkipCard extends EffectCard {
    //Constructor
    public SkipCard(CardColor color){
        super(color, CardSymbol.SKIP);
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
        GameLogic.getInstance().goToNextPlayer();
        int SkipPlayer = GameLogic.getInstance().getCurrentPlayer();
        while(true){
            if(GameLogic.getInstance().getCurrentPlayerHand().isEmpty()){
                GameLogic.getInstance().goToNextPlayer();
                SkipPlayer = GameLogic.getInstance().getCurrentPlayer();
            }
            else{
                break;
            }
        }
        return "Skipped player " + SkipPlayer;
    }



}
