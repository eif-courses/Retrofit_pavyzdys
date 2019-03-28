import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cards {

    @SerializedName("Basic")
    public List<Card> cardList;

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cardList=" + cardList +
                '}';
    }
}