package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawTwoCard extends EffectCard{
    //Constructor
    public DrawTwoCard(CardColor color){
        super(color,CardSymbol.DRAW_TWO);
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
    public String performEffect(){
        GameLogic.getInstance().incrementDrawAmount(2);
        GameLogic.getInstance().goToNextPlayer();
        String message = null;
        while(true){
            if(GameLogic.getInstance().getCurrentPlayerHand().isEmpty()){
                GameLogic.getInstance().goToNextPlayer();
            }
            else {break;}
            }

        boolean CardExist = false;

        for(int i = 0; i < GameLogic.getInstance().getCurrentPlayerHand().size(); i++){
            if(GameLogic.getInstance().getCurrentPlayerHand().get(i) instanceof DrawFourCard || GameLogic.getInstance().getCurrentPlayerHand().get(i) instanceof DrawTwoCard){
                this.play();
                message = "Player " + GameLogic.getInstance().getCurrentPlayer() + " played " + GameLogic.getInstance().getTopCard() + ". " + GameLogic.getInstance().getCurrentPlayerHand().size() + " cards remaining.";
                CardExist = true;
                break;
            }

        }

        if(!CardExist) {
            ArrayList<BaseCard> DrawCard = GameLogic.getInstance().draw(2);
            for (int j = 0; j < DrawCard.size(); j++){
                GameLogic.getInstance().getCurrentPlayerHand().add(DrawCard.get(j));
            }
            message = "Player " + GameLogic.getInstance().getCurrentPlayer() +" drew " + DrawCard.size() + " cards. "+ GameLogic.getInstance().getDeck().size() + "cards remaining.";
        }

        GameLogic.getInstance().setDrawAmount(0);
        return message;
        }

}
