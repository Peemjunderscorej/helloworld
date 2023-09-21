package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawFourCard extends EffectCard {
    //Constructor
    public DrawFourCard(){
        super(null , CardSymbol.DRAW_FOUR);
    }

    //Method
    public String toString(){
        if(this.getColor() == null){
            return this.getSymbol().toString();
        }
        else{
            return this.getSymbol().toString() + " (" + this.getColor().toString() + " color selected)" ;
        }
    }
    public boolean canPlay(){
        return true;
    }
    public String performEffect(){
        String messages = "";

        if(GameLogic.getInstance().getCurrentPlayerHand().get(0) instanceof ChangeColorCard || GameLogic.getInstance().getCurrentPlayerHand().get(0) instanceof DrawFourCard || GameLogic.getInstance().getCurrentPlayerHand().isEmpty()  ){
            CardColor changeColor = CardColor.RED;
            setColor(changeColor);
            messages += "Set color to " + changeColor.toString();
        }
        else{
            CardColor changeColor = GameLogic.getInstance().getCurrentPlayerHand().get(0).getColor();
            setColor(changeColor);
            messages +="Set color to " + changeColor.toString();
        }

        GameLogic.getInstance().incrementDrawAmount(4);
        GameLogic.getInstance().goToNextPlayer();

        while(true){
            if(GameLogic.getInstance().getCurrentPlayerHand().isEmpty()){
                GameLogic.getInstance().goToNextPlayer();
            }
            else {break;}
        }

        boolean CardExist = false;
        for(int i = 0; i < GameLogic.getInstance().getCurrentPlayerHand().size(); i++){
            if(GameLogic.getInstance().getCurrentPlayerHand().get(i) instanceof DrawFourCard){
                this.play();
                messages += "Player " + GameLogic.getInstance().getCurrentPlayer() + " played " + GameLogic.getInstance().getTopCard() + ". " + GameLogic.getInstance().getCurrentPlayerHand().size() + " cards remaining.";
                CardExist = true;
                break;
            }
        }

        if(!CardExist) {
            ArrayList<BaseCard> DrawCard = GameLogic.getInstance().draw(2);
            for (int j = 0; j < DrawCard.size(); j++){
                GameLogic.getInstance().getCurrentPlayerHand().add(DrawCard.get(j));
            }
            messages += "Player " + GameLogic.getInstance().getCurrentPlayer() +" drew " + DrawCard.size() + " cards. "+ GameLogic.getInstance().getDeck().size() + "cards remaining.";
        }

        GameLogic.getInstance().setDrawAmount(0);
        return messages;
    }


}
