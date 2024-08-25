// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
package problem1;

import java.util.Random;

public class DeckOfCards {
   private Card deck[]; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator

   private final String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
           "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
   private final String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};

   // constructor fills deck of Cards
   public DeckOfCards() {
      deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for (int count = 0; count < deck.length; count++)
         deck[count] =
                 new Card(faces[count % 13], suits[count / 13]);
   } // end DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard

      // for each Card, pick another random Card and swap them
      for (int first = 0; first < deck.length; first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current Card with randomly selected Card
         Card temp = deck[first];
         deck[first] = deck[second];
         deck[second] = temp;
      } // end for
   } // end method shuffle

   // deal one Card
   public Card dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length)
         return deck[currentCard++]; // return current Card in array
      else
         return null; // return null to indicate that all Cards were dealt
   } // end method dealCard

   public Card[] dealHand() {
      Card[] hand = new Card[5];
      for (int i = 0; i < hand.length; i++) {
         hand[i] = dealCard();
      }
      return hand;
   }

   //помощните методи обикновено са private
   private int[] numbers(Card[] hand) {
      int[] numbers = new int[faces.length];
      for (int i = 0; i < hand.length; i++) {
         for (int j = 0; j < faces.length; j++) {
            if (hand[i].getFace().equals(faces[j])) {
               numbers[j]++;
            }
         }
      }

      return numbers;
   }

   private int countPairs(Card[] hand) {
      int[] numbers = numbers(hand);

      int countPairs = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] == 2) {
            countPairs++;
         }
      }
      return countPairs; //pair == две еднакви по сила
   }

   private boolean hasThree(Card[] hand) {
      int[] numbers = numbers(hand);
      for(int i = 0; i < numbers.length; i++) {
         if(numbers[i] == 3) {
            return true;
         }
      }
      return false;
   }
   public boolean hasPair(Card[] hand) {
//      int count = countPairs(hand);
//      boolean countThree = hasThree(hand);
//      if(count == 1 && !countThree) {
//         return true;
//      }
//      return false;
      return countPairs(hand) == 1 && !hasThree(hand);
   }

   public boolean hasTwoPairs(Card[] hand) {
      return countPairs(hand) == 2;
   }

   public boolean hasThreeOfAKind(Card[] hand) {
      return countPairs(hand) == 0 && hasThree(hand);
   }

   public boolean hasFullHouse(Card[] hand) {
      return countPairs(hand) == 1 && hasThree(hand);
   }

   public boolean hasFourOfAKind(Card[] hand) {
      int[] numbers = numbers(hand);
      for(int i = 0; i < numbers.length; i++) {
         if(numbers[i] == 4) {
            return true;
         }
      }
      return false;
   }

   public boolean hasStraight(Card[] hand) {
      int[] numbers = numbers(hand);
      int consecutive = 0;
      for(int i = 0; i < numbers.length; i++) {
         if(numbers[i] == 1) {
            consecutive++;
         } else {
            consecutive = 0;
         }
         if(consecutive == 5) {
            return true;
         }
      }
      return consecutive == 4 && numbers[0] == 1;
//      return numbers[0] == 1 &&
//              numbers[numbers.length - 1] == 1 &&
//              numbers[numbers.length - 2] == 1 &&
//              numbers[numbers.length - 3] == 1 &&
//              numbers[numbers.length - 4] == 1;
   }

   public boolean hasFlush(Card[] hand) {
      String color = hand[0].getSuit();
              for(int i = 0; i < hand.length; i++) {
                 if(!hand[i].getSuit().equals(color)) {
                    return false;
                 }
              }
              return true;
   }

   public int handStrength(Card[] hand) {
      if(hasPair(hand))
         return 1;
      if(hasTwoPairs(hand))
         return 2;
      if(hasThreeOfAKind(hand))
         return 3;
      if(hasStraight(hand))
         return 4;
      if(hasFlush(hand))
         return 5;
      if(hasFullHouse(hand))
         return 6;
      if(hasFourOfAKind(hand))
         return 7;

      return 0;
   }
} // end class DeckOfCards