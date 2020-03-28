import java.util.Random;

// This is a stack for storing the deck of cards
// The hand is drawn by using pop() method 7 times.
class Stack {
    static final int MAX = 324;
    public int top;
    Card[] a = new Card[MAX];

    Stack() {
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(Card c) {
        if (top <= MAX - 1) {
            a[++top] = c;
        }
    }

    Card pop() {
        if (top == -1) return null;
        return a[top--];
    }
}

// Enter Description Here
public class Deck {
    public int num_decks;
    public boolean action_cards;
    boolean shuffle_together;

    Deck(int num_decks, boolean action_cards, boolean shuffle_together) {
        this.num_decks = num_decks;
        this.action_cards = action_cards;
        this.shuffle_together = shuffle_together;
    }

    Card[] populate_deck() throws Exception {
        int num_cards;
        if (action_cards) {
            num_cards = num_decks * 108;
        } else {
            num_cards = num_decks * 76;
        }

        Card[] raw_deck = new Card[num_cards];
        int n = 0;

        for (int j = 0; j < num_decks; j++) {
            Card a = new Card((Integer) null, "Push Ups");

            for (int i = 0; i < 10; i++) {
                a.repNum = i;
                raw_deck[n++] = a;
            }
            for (int i = 1; i < 10; i++) { // Add 9
                a.repNum = i;
                raw_deck[n++] = a;
            }

            Card b = new Card((Integer) null, "Squat");

            for (int i = 0; i < 10; i++) { // Same
                b.repNum = i;
                raw_deck[n++] = b;
            }
            for (int i = 1; i < 10; i++) { // Same
                b.repNum = i;
                raw_deck[n++] = b;
            }

            Card c = new Card ((Integer) null, "Sit Ups");

            for (int i = 0; i < 10; i++) { // Same
                c.repNum = i;
                raw_deck[n++] = c;
            }
            for (int i = 1; i < 10; i++) { // Same
                c.repNum = i;
                raw_deck[n++] = c;
            }

            Card d = new Card((Integer) null, "Lounges");

            for (int i = 0; i < 10; i++) { // Same
                d.repNum = i;
                raw_deck[n++] = d;
            }
            for (int i = 1; i < 10; i++) { // Same
                d.repNum = i;
                raw_deck[n++] = d;
            }

            if (action_cards) {
                Card e = new Card((String) null, "Push Ups");

                for (int i = 0; i < 2; i++) { // Add 8
                    e.action = "SKIP";
                    raw_deck[n++] = e;
                    e.action = "DRAW TWO";
                    raw_deck[n++] = e;
                    e.action = "REVERSE";
                    raw_deck[n++] = e;
                }

                Card f = new Card((String) null, "Squat");

                for (int i = 0; i < 2; i++) { // Same
                    f.action =  "SKIP";
                    raw_deck[n++] = f;
                    f.action = "DRAW TWO";
                    raw_deck[n++] = f;
                    f.action = "REVERSE";
                    raw_deck[n++] = f;
                }

                Card g = new Card((String) null, "Sit Ups");

                for (int i = 0; i < 2; i++) { // Same
                    g.action = "SKIP";
                    raw_deck[n++] = g;
                    g.action = "DRAW TWO";
                    raw_deck[n++] = g;
                    g.action = "REVERSE";
                    raw_deck[n++] = g;
                }

                Card h = new Card((String) null, "Lounges");

                for (int i = 0; i < 2; i++) { // Same
                    h.action = "SKIP";
                    raw_deck[n++] = h;
                    h.action = "DRAW TWO";
                    raw_deck[n++] = h;
                    h.action = "REVERSE";
                    raw_deck[n++] = h;
                }

                Card k = new Card((String) null, "Rainbow");

                for (int i = 0; i < 4; i++) {
                    k.action = "Wild";
                    raw_deck[n++] = k;
                    k.action = "Wild Draw 4";
                    raw_deck[n++] = k;
                }
            }
        }
        return raw_deck;
    }


    Stack shuffle(Card[] raw_deck) throws Exception {
        Stack draw_deck = new Stack();
        Random rand = new Random();
        int num_cards;

        if (action_cards) {
            num_cards = 108;
        } else {
            num_cards = 76;
        }

        if (!shuffle_together) {
            switch (num_decks) {
                case 1:
                    for (int i = 0; i < num_cards; i++) {
                        int r = i + rand.nextInt(num_cards - i);

                        Card temp = raw_deck[r];
                        raw_deck[r] = raw_deck[i];
                        raw_deck[i] = temp;
                    }
                    break;
                case 2:
                    for (int i = 0; i < num_cards; i++) {
                        int r = i + rand.nextInt(num_cards - i);

                        Card temp = raw_deck[r];
                        raw_deck[r] = raw_deck[i];
                        raw_deck[i] = temp;
                    }
                    for (int i = num_cards; i < (2 * num_cards); i++) {
                        int r = i + rand.nextInt((2 * num_cards) - i);

                        Card temp = raw_deck[r];
                        raw_deck[r] = raw_deck[i];
                        raw_deck[i] = temp;
                    }
                    break;
                case 3:
                    for (int i = 0; i < num_cards; i++) {
                        int r = i + rand.nextInt(num_cards - i);

                        Card temp = raw_deck[r];
                        raw_deck[r] = raw_deck[i];
                        raw_deck[i] = temp;
                    }
                    for (int i = num_cards; i < (2 * num_cards); i++) {
                        int r = i + rand.nextInt((2 * num_cards) - i);

                        Card temp = raw_deck[r];
                        raw_deck[r] = raw_deck[i];
                        raw_deck[i] = temp;
                    }
                    for (int i = (2 * num_cards); i < (3 * num_cards); i++) {
                        int r = i + rand.nextInt((3 * num_cards) - i);

                        Card temp = raw_deck[r];
                        raw_deck[r] = raw_deck[i];
                        raw_deck[i] = temp;
                    }
                    break;
            }
        }
        else {
            for (int i = 0; i < num_cards * num_decks; i++) {
                int r = i + rand.nextInt((num_cards * num_decks) - i);

                Card temp = raw_deck[r];
                raw_deck[r] = raw_deck[i];
                raw_deck[i] = temp;
            }
        }

        for (int i = 0; i < num_cards * num_decks; i++) {
            draw_deck.push(raw_deck[i]);
        }

        return draw_deck;
    }


    Card[] drawNextHand(Stack draw_deck) throws Exception {
        Card[] hand = new Card[7];
        for (int i = 0; i < 7; i++) {
            if (!(draw_deck.isEmpty())) hand[i] = draw_deck.pop();
        }
        return hand;
    }
}
