import java.util.ArrayList;

public class Trick {

    public ArrayList<Card> cards;
    public int trickPoints;

    public Trick(ArrayList<Card> a) {
        cards = a;
        trickPoints = setTotalPoints();
    }

    public int setTotalPoints() {
        int totalPoints = 0;
        Card aCard;

        for (int i = 0; i < cards.size(); i++) {
            aCard = cards.get(i);
            totalPoints += aCard.getPoints();
        }

        return totalPoints;
    }

    public String toString() {
        String aString = "";
        Card aCard;
        Suit suit;
        String num;

        for (int i = 0; i < cards.size(); i++) {
            aCard = cards.get(i);
            suit = aCard.getSuit();
            num = "" + aCard.getCardNum();

            if (num.equals("11")) {
                num = "Jack";
            }
            else if (num.equals("12")) {
                num = "Queen";
            }
            else if (num.equals("13")) {
                num = "King";
            }
            else if (num.equals("1")) {
                num = "Ace";
            }

            aString += num + " of " + suit + "\n";
        }

        return aString;
    }

    public Card getWinner() {           // Assume that the ArrayList is
        Card winning = cards.get(0);    // in the order of cards played

        Suit nextSuit;
        Suit currentSuit;

        int currentNum;
        int nextNum;

        for (int i = 1; i < cards.size(); i++) {
            currentSuit = winning.getSuit();         // Suit of the current winning card
            nextSuit = cards.get(i).getSuit();       // Suit of the next-played card

            currentNum = winning.getCardNum();       // Number of current winning card
            nextNum = cards.get(i).getCardNum();     // Number of next-played card

            if (currentSuit == nextSuit) {
                if (currentNum < nextNum) {
                    if (currentNum != 1) {
                        winning = cards.get(i);
                    }
                }
                else if (nextNum == 1) {
                    winning = cards.get(i);
                }
            }
        }

        return winning;
    }
}
