public class Card implements Comparable {

    private Suit suit;
    private int cardNum;
    private int points;

    public Card (Suit s, int num) {
        suit = s;
        cardNum = num;
        points = setPoints(suit, num);
    }

    public int compareTo(Object obj) {      // Assumes the suit of Card
        Card that = (Card) obj;             // referenced by "this" is the
                                            // leading suit
        if (suit.equals(that.suit)) {
            if (cardNum < that.cardNum) {
                return -1;
            }
            else if (cardNum > that.cardNum) {
                return 1;
            }
            else return 0;
        }
        else {
            return 1;
        }
    }

    public int setPoints(Suit suit, int num) {
        int points = 0;

        if (suit == Suit.HEARTS) {
            points = 1;
        }

        else if (suit == Suit.SPADES && num == 12) {
            points = 13;
        }

        return points;
    }

    @Override
    public String toString() {
        String aString = "";
        Suit suit;
        String num;

        suit = this.getSuit();
        num = "" + this.getCardNum();

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

        aString = "Winning Card: " + num + " of " + suit + "\n";
        return aString;

    }

    public int getPoints() {
        return points;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getCardNum() {
        return cardNum;
    }
}