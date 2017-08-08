import java.util.*;

public class DotComMaster{

  int[][][] boats;
  String[] str;
  int[] numberOfHits;
  String[][] guessesedLocations;

  // array storing user guesses
  String[] usrGsArr = new String[49];
  int init = -1;

  // amoeba boat
  public int[][] makeAmoebaBoat(){
    int[][] amoebaBoat = new int[4][2];
    /*
            * - -
            * * -
            * - -
            - - -
    */
    amoebaBoat[0][0] = 0; amoebaBoat[0][1] = 0;
    amoebaBoat[1][0] = 1; amoebaBoat[1][1] = 0;
    amoebaBoat[2][0] = 2; amoebaBoat[2][1] = 0;
    amoebaBoat[3][0] = 1; amoebaBoat[3][1] = 1;

    return null;
  }

  public void initDotCom(int numberOfBoats){
    boats = new int[numberOfBoats][3][2];
    str = new String[numberOfBoats];
    numberOfHits = new int[numberOfBoats];
    guessesedLocations = new String[7][7];
    makeAllBoats();
  }

  // how to make each boat
  private void makeBoat(int[][] boat){
    int x, y;
    int bit = (int) (Math.random() * 2);
    if(bit == 0){
      x = (int) (Math.random() * 7);
      y = (int) (Math.random() * 5);
      boat[0][0] = x; boat[0][1] = y;
      boat[1][0] = x; boat[1][1] = y+1;
      boat[2][0] = x; boat[2][1] = y+2;
    } else {
        x = (int) (Math.random() * 5);
        y = (int) (Math.random() * 7);
        boat[0][0] = x; boat[0][1] = y;
        boat[1][0] = x+1; boat[1][1] = y;
        boat[2][0] = x+2; boat[2][1] = y;
    }
  }

  private void makeAllBoats(){
    // making 'n' boats
    for(int y = 0; y < boats.length; y++)
      makeBoat(boats[y]);

    // Comparison of 'n' boats
    for(int i = 0; i < boats.length-1; i++)
      for(int j = i+1; j < boats.length; j++)
        if(isSame(boats[i], boats[j]))
          makeAllBoats();
  }

  public String[] checkYourself(String userGuess){
    // String[] boatsStatusArr = {"", "", ""};
    for(int i = 0; i < str.length; i++)
      str[i] = "";

    int[][] userGuessIntArr = new int[1][2];
    int i = 0;


    if(init == -1){
      init++;
      usrGsArr[init] = userGuess;
    }
    else{
      for(int x = 0; x <= init; x++){
        if(usrGsArr[x].equals(userGuess)){
          System.out.println("! Already guessed !");
          // return new String[]{"", "", ""};
          return str;
        } // end if
      } // end for
      init++;
      usrGsArr[init] = userGuess;
    } // end else


    // parsing and storing userGuess
    for(String s : userGuess.split(" "))
      userGuessIntArr[0][i++] = Integer.parseInt(s);

    for(int z = 0; z < boats.length; z++){
      if(numberOfHits[z] < 3){
        for(int x = 0; x < boats[0].length; x++){
          int y = 0;
          if(userGuessIntArr[0][0] == boats[z][x][y]){
            if(userGuessIntArr[0][1] == boats[z][x][y+1]){
              // updating guessesedLocations
              guessesedLocations[userGuessIntArr[0][0]][userGuessIntArr[0][1]] = " H ";
              numberOfHits[z]++;
              if(numberOfHits[z] == 3){
                System.out.println("boat" + (z+1) + " killed.");
                str[z] = "kill";
              } else {
                System.out.println("boat" + (z+1) + " hit");
                str[z] = "hit";
                break;
              } // end else
            } // end if
          } // end if
        } // end for

        if(!str[z].equals("kill") && !str[z].equals("hit")){
          // updating guessesedLocations
          guessesedLocations[userGuessIntArr[0][0]][userGuessIntArr[0][1]] =
          (!guessesedLocations[userGuessIntArr[0][0]][userGuessIntArr[0][1]].equals(" H "))? " X " : guessesedLocations[userGuessIntArr[0][0]][userGuessIntArr[0][1]];
          System.out.println("boat" + (z+1) + " missed");
          str[z] = "miss";
        } // end if
      } // end if
    } // end for

    return str;
  } // end checkYourself()

  public boolean isSame(int[][] boat1, int[][] boat2){
    boolean b = true;

    for(int r = 0; r<boat1.length; r++){
      for(int c = 0; c<boat1[0].length; c++){
        if(boat1[r][c] != boat2[r][c]){
          b = false;
          return b;
        }
      } // end inner for
    } // end outer for
    return b;
  }

  @Override
  public String toString(){
    StringBuffer buffer = new StringBuffer();
    boolean toggle = true;
    buffer.append("+---+---+---+---+---+---+---+\n");
    for(int r = 0; r <= 13; r++){
      if(toggle){
        for(int c = 0; c <= 6; c++){
          if(guessesedLocations[r/2][c] != null){
            buffer.append("|" + guessesedLocations[r/2][c]);
            continue;
          }
          buffer.append("|   ");
        }
        buffer.append("|\n");
      }
      else {
        for(int c = 1; c <= 7; c++)
          buffer.append("+---");
        buffer.append("+\n");
        }
      toggle = !toggle;
    }
    return buffer.toString();
  }
}
