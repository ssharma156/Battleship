// DotCom Changes
/*
  ** 3 boats generation and comparison for 3 boats through loop
  ** Visual look to the battlefield in the form of Cells
  ** Non identical but overlapped and intersected
*/

import java.util.*;
import java.util.Scanner;

public class DotCom extends DotComMaster{
  public static void main(String[] args) {
    int numberOfGuesses = 0;
    int numberOfBoats;
    Scanner scn = new Scanner(System.in);
    DotCom dotCom = new DotCom();
    System.out.println("[INFO] Game initialization in progress..");
    System.out.print("[PROMPT] Enter number of boats: ");
    numberOfBoats = scn.nextInt();
    dotCom.initDotCom(numberOfBoats);
    System.out.println("[INFO] Game initialized.\n\n");

    System.out.println(dotCom);
    int boatsKilled = 0;
    String[] boatsStatusArr;
    while(boatsKilled < numberOfBoats){
      System.out.print("[PROMPT] Enter your guess ");
      boatsStatusArr = dotCom.checkYourself(new Scanner(System.in).nextLine());
      numberOfGuesses++;

      System.out.println(dotCom);
      System.out.println();

      for(int z = 0; z < boatsStatusArr.length; z++)
        if(boatsStatusArr[z].equals("kill"))
          boatsKilled++;
    } // end while

    System.out.println("[INFO] Game Over.");
    System.out.println("[INFO] You took " + numberOfGuesses + " guesses.");
  }
}

// Adding a new comment