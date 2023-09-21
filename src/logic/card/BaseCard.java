package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;

//You CAN modify the first line
public abstract class BaseCard {
    private CardColor color;
    private CardSymbol symbol;

    //Constructor
    public BaseCard(CardColor color, CardSymbol symbol){
        this.setColor(color);
        this.setSymbol(symbol);
    }

    //Method
    public abstract String toString();
    public abstract boolean canPlay();
    public abstract String play();

    //getter&setter
    public CardColor getColor(){
        return this.color;
    }
    public void setColor(CardColor color){
        this.color = color;
    }
    public CardSymbol getSymbol(){
        return this.symbol;
    }
    public void setSymbol(CardSymbol symbol){
        this.symbol = symbol;
    }

}
