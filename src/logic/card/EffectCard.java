package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public abstract class EffectCard extends BaseCard {
    //Constructor
    public EffectCard(CardColor color, CardSymbol symbol){
        super(color,symbol);
    }

    //Method
    public abstract String performEffect();
    public String play(){
        GameLogic.getInstance().setTopCard(GameLogic.getInstance().getCurrentPlayerHand().get(0));
        GameLogic.getInstance().getCurrentPlayerHand().remove(GameLogic.getInstance().getCurrentPlayerHand().get(0));
        return performEffect();
    }


}
