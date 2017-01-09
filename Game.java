import javax.swing.*;
import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Suit[] possibilities = {Suit.CLUBS,Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};

        ArrayList<Card> someCards = new ArrayList<>();
        Card aCard;
        Suit aSuit;
        String numInput;
        int aNum;

        for (int i = 0; i < 5; i++) {
            numInput = (String) JOptionPane.showInputDialog(frame, "Card Number (or J, Q, K, A): ", "What is the card number?", JOptionPane.PLAIN_MESSAGE, null, null, null);
            aSuit = (Suit) JOptionPane.showInputDialog(frame, numInput + " of ", "What is the suit?", JOptionPane.PLAIN_MESSAGE, null, possibilities, "Suit.Hearts");

            if (numInput.equals("J") || numInput.equals("11")) {
                aNum = 11;
            }
            else if (numInput.equals("Q") || numInput.equals("12")) {
                aNum = 12;
            }
            else if (numInput.equals("K") || numInput.equals("13")) {
                aNum = 13;
            }
            else if (numInput.equals("A") || numInput.equals("1") || numInput.equals("14")) {
                aNum = 1;
            }
            else aNum = Integer.parseInt(numInput);

            aCard = new Card(aSuit, aNum);
            someCards.add(aCard);
        }

        Trick aTrick = new Trick(someCards);
        JOptionPane.showMessageDialog(frame, "Trick:\n" + aTrick.toString() + "\nSummary:\n" + (aTrick.getWinner()).toString() + "Trick points: " + aTrick.trickPoints);
    }

}
