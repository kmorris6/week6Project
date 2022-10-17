package week6Final;

import java.util.Scanner; 
import java.util.ArrayList; 

public class App {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

//Initialize String variables:
  String player1;
  String player2;
  String option;
  String roundwinner = "";
  String gamewinner = "";

//Initialize integer variables:
  int temp;
  int play = 1;

//Initialize Boolean variables:
  boolean winner;

  while (play != 0){ //This while-loop will run as long as the user decides to play (play value = 1)
    winner = false; //For the beginning of each game, winner values are set to false
    Deck deck = new Deck(); //Creates a new Deck object called deck
    deck.shuffle(); //Calls the method shuffle for the deck

//The lines below create 3 Array Lists of type Card for both players' Deck and the War Deck
  ArrayList<Card> Deck1 = new ArrayList<>(56);
  ArrayList<Card> Deck2 = new ArrayList<>(56);
  ArrayList<Card> warDeck = new ArrayList<>(9);
  divideDeck(Deck1, Deck2, deck); //Uses the method divideDeck to Divide the deck between the two players

//The lines take input from the user for and print out the expected results:
  System.out.println("Welcome to WAR! Let's Play!\n");
  System.out.print("Enter the first player's name: ");
  player1 = scan.nextLine();
  System.out.print("Enter the second player's name: ");
  player2 = scan.nextLine();
  System.out.println(player1 + "\t\t\t#Cards\t\t" + player2 + "\t\t\t#Cards\t\tWinner");
  

  while (!winner){ //This while-loop will run as long as no winner exists (winner value = false)
    System.out.print(Deck1.get(0) + " \t" + Deck1.size() + "\t\t" + Deck2.get(0) + " \t" + Deck2.size() + "\t\t"); //Prints out the first card of both players and their remaining card in each Deck
  int x = Deck1.get(0).isGreater(Deck2.get(0));
  if (x == 1){ //When Deck1's first card has more value than Deck 2's first card

//The lines below adds the first cards of both decks to the end and removes the first card of the deck:
  Deck1.add(Deck2.get(0));
  Deck1.add(Deck1.get(0));
  Deck1.remove(0);
  Deck2.remove(0);
  roundwinner = player1;
  }
  if (x == 2){ //When Deck2's first card has more value than Deck 1's first card
  
//The lines below adds the first cards of both decks to the end and removes the first card of the deck:
    Deck2.add(Deck1.get(0));
    Deck2.add(Deck2.get(0));
    Deck2.remove(Deck2.get(0));
    Deck1.remove(0);
    roundwinner = player2;
  }
  if (x == 3) //Otherwise, a war occurs
    roundwinner = "WAR";
    System.out.println(roundwinner);
  if (x == 3){ 
    roundwinner = "WAR";
    System.out.println(roundwinner);
    war();
    System.out.print(Deck1.get(0) + " \t" + Deck1.size() + "\t\t" + Deck2.get(0) + " \t" + Deck2.size() + "\t\t");
  if (Deck1.size() <= 4){ //When the first player has 4 cards or less, they do not have enough cards to go to war and the winner will automatically be the other player
    roundwinner = player2;
    System.out.println(roundwinner);
    endwar();
    gamewinner = player2;
    break; //Breaks out of the loop
  }
  else if (Deck2.size() <= 4){ //When the first player has 4 cards or less, they do not have enough cards to go to war and the winner will automatically be the other player
    roundwinner = player1;
    System.out.println(roundwinner);
    endwar();
    gamewinner = player1;
    break; //Breaks out of the loop
  }
  
  warDeckTransfer(Deck1, Deck2, warDeck); //warDeckTransfer is a method which adds 4 cards of both players to the warDeck
  temp = warDeck.get(3).isGreater(warDeck.get(7));

  //The lines below analyze which of the two players wins the War, the winner gains all cards from the War Deck:
  if(temp == 1){ //When player 1 wins..
    while (warDeck.size() != 0) {
      Deck1.add(warDeck.get(0));
      warDeck.remove(0);
      roundwinner = player1;
  }
 }
  else if (temp == 2){ //When player 2 wins..
    while (warDeck.size() != 0){
      Deck2.add(warDeck.get(0));
      warDeck.remove(0);
      roundwinner = player2;
  }
 }
 

  else{ //Otherwise, another War begins
    shift(warDeck); //Uses the method shift which move all the cards to the right
    temp = warDeck.get(3).isGreater(warDeck.get(7));

  //The lines below analyze which of the two players wins the second War, the winner gains all cards from the War Deck:
  if (temp == 1){ //When player 1 wins..
    while (warDeck.size() != 0){
      Deck1.add(warDeck.get(0));
      warDeck.remove(0);
      roundwinner = player1;
  }
 }
  else if (temp == 2){ //When player 2 wins..
    while (warDeck.size() != 0){
      Deck2.add(warDeck.get(0));
      warDeck.remove(0);
      roundwinner = player2;
  }
 }
  
}
  System.out.println(roundwinner);
  endwar();
  }
  if (Deck1.size() == 52){ //When Deck 1 has 52 cards, player 1 wins, loop terminates
    gamewinner = player1;
    winner = true;
  }
  
  if (Deck2.size() == 52){ //When Deck 2 has 52 cards, player 2 wins, loop terminates
    gamewinner = player2;
    winner = true;
  }
 }// The loop ends when there is a winner

//The lines below print out the expected results, and asks if the user wants to play again:
  System.out.println(gamewinner + " WINS! Congratulations");
  System.out.print("Play again (y/n)? ");

//The lines below scan for the user's response then proceeds to different options based on the response
  option = scan.nextLine().toLowerCase();
  option = "" + option.charAt(0);
  while (!(option.equals("y") || option.equals("n"))){ //This while-loop continuously runs until the user has provided a valid response
    System.out.print("Invalid option. Please enter y or n: ");
    option = scan.nextLine().toLowerCase();
    option = "" + option.charAt(0);
  }
  
  if (option.equals("y")){ //When the user decides to keep playing..
    play = 1;
    System.out.println();
  }
  else{ //When the user decides to terminate the game..
    play = 0;
  }
 }//Loop ends when user decides to stop playing (play = 0)
  System.out.print("Thanks for playing! ");
}

public static void war(){ //war is a method that prints out the War message
  System.out.println("************************************************WAR*******************************************");
  }

public static void endwar(){ //endwar is a method that prints out the End War message
  System.out.println("************************************************END WAR***************************************");
  }

public static void shift(ArrayList<Card> warDeck) { //shift is a method which moves all the cards in warDeck to the right
  warDeck.add(warDeck.get(3));
  warDeck.remove(3);
  warDeck.add(2, warDeck.get(7));
  warDeck.remove(7);
  }

public static void divideDeck(ArrayList<Card> Deck1, ArrayList<Card> Deck2, Deck deck){ //divideDeck is a method which divides the Deck evenly for both players
  for (int x = 0; x < 26; x++){
    Deck1.add(deck.getFromShuffledDeck(x));
    Deck2.add(deck.getFromShuffledDeck(x+26));
  }
 }

public static void warDeckTransfer(ArrayList<Card> Deck1, ArrayList<Card> Deck2, ArrayList<Card> warDeck){ //warDeckTransfer is a method that populates the war Deck by taking 4 cards from each players' deck
  for (int y = 0; y < 4 && Deck1.size() < 48; y++){
    warDeck.add(Deck1.get(0));
    Deck1.remove(0);
  }
  for (int y = 0; y < 4 && Deck2.size() < 48; y++){
    warDeck.add(Deck2.get(0));
    Deck2.remove(0);
  }
 }
} 

