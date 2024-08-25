// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.
package problem1;
public class DeckOfCardsTest
{
   // execute application
   public static void main( String args[] )
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order
      
      // print all 52 Cards in the order in which they are dealt
//      for ( int i = 0; i < 13; i++ )
//      {
//         // deal and print 4 Cards
//         System.out.printf( "%-20s%-20s%-20s%-20s\n",
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
//      } // end for

      Card[] leftHand = myDeckOfCards.dealHand();
      Card[] rightHand = myDeckOfCards.dealHand();
      System.out.printf("%-20s%-20s\n", "Left hand:", "Right hand:");
      for(int i = 0; i< leftHand.length; i++) {
         System.out.printf("%-20s%-20s\n", leftHand[i], rightHand[i]);
      }

      int leftHandStrength = myDeckOfCards.handStrength(leftHand);
      int rightHandStrength = myDeckOfCards.handStrength(rightHand);
//TO DO: print strength with text(with switch)

      if(leftHandStrength > rightHandStrength) {
         System.out.println("Result: left hand is better");
      }
      else if(rightHandStrength > leftHandStrength) {
         System.out.println("Result: right hand is better");
      } else {
         System.out.println("Result: left and right hands are equal");
      }
   } // end main
} // end class DeckOfCardsTest

