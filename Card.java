package week6Final;

public class Card {
  
//Initialize instance variables:
  private String suit;
  private String rank;
  private int value;

//Initialize constructor
  public Card(){
}

//Another constructor that creates a 'Card' object with the attributes based on user input:
  public Card(String suit, String rank){
    this.suit = suit;
    this.rank = rank;

//The following if-statements below will determine the value of the card based on the card's rank:
  if(rank.equals("2")){
  value = 2;
}
  else if(rank.equals("3")){
    value = 3;
}
  else if(rank.equals("4")){
    value = 4;
}
  else if(rank.equals("5")){
    value = 5;
}
  else if(rank.equals("6")){
    value = 6;
}
  else if(rank.equals("7")){
    value = 7;
}
  else if(rank.equals("8")){
    value = 8;
}
  else if(rank.equals("9")){
    value = 9;
}
  else if(rank.equals("10")){
    value = 10;
}
  else if(rank.equals("Jack")){
    value = 11;
}
  else if(rank.equals("Queen")){
    value = 12;
}
  else if(rank.equals("King")){
    value = 13;
}
  else if(rank.equals("Ace")){
    value = 14;
}
}

//Initialize getter methods:
  public String getSuit(){
  return suit;
}

  public String getRank(){
  return rank;
}

  public int getValue(){
   return value;
}

//Initialize setter methods:
  public void setSuit(String suit){
    this.suit = suit;
}

  public void setRank(String rank){ 
    this.rank = rank;
}

  public void setValue(int value){
    this.value = value;
}


  public String toString(){ //print out a Card object's attributes
    return rank + " " + suit;
}

  public Card copy(Card card){ //copies the attributes of a Card object to another created Card object
    Card temp = new Card (card.getSuit(), card.getRank());
    return temp;
}

  public int isGreater(Card card){ //compare the value of 2 different Card objects.
    int temp;
    if (value > card.getValue()){ 
      temp = 1;
}
    else if (value < card.getValue()){ 
      temp = 2;
}
    else { 
      temp = 3;
}
    return temp; 
 }
}

