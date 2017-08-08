/*
public class DotComTestDrive{
  static int[][] boat1 = new int[3][2];
  static int[][] boat2 = new int[3][2];


  public static void main(String[] args){
    boat1[0][0] = 1;    boat1[0][1] = 1;
    boat1[1][0] = 1;    boat1[1][1] = 2;
    boat1[2][0] = 1;    boat1[2][1] = 3;

    boat2[0][0] = 1;    boat2[0][1] = 3;
    boat2[1][0] = 2;    boat2[1][1] = 3;
    boat2[2][0] = 3;    boat2[2][1] = 3;

    DotCom dotCom = new DotCom();
    dotCom.initDotCom(boat1, boat2);
    String userGuess = "";
    String[] boatsStatusArr = new String[2];
    String caseResult = "";

    // # CASE1
    userGuess = "1 1";
    caseResult = "failed";
    boatsStatusArr = dotCom.checkYourself(userGuess);
    if(boatsStatusArr[0].equals("hit") && boatsStatusArr[1].equals("")){
      caseResult = "passed";
    }
    System.out.println("Case 1 : " + caseResult + "\n");

    // # CASE2
    userGuess = "0 0";
    caseResult = "failed";
    boatsStatusArr = dotCom.checkYourself(userGuess);
    if(boatsStatusArr[0].equals("") && boatsStatusArr[1].equals("")){
      caseResult = "passed";
    }
    System.out.println("Case 2 : " + caseResult + "\n");

    // # CASE3
    userGuess = "2 3";
    caseResult = "failed";
    boatsStatusArr = dotCom.checkYourself(userGuess);
    if(boatsStatusArr[0].equals("") && boatsStatusArr[1].equals("hit")){
      caseResult = "passed";
    }
    System.out.println("Case 3 : " + caseResult + "\n");

    // # CASE4
    userGuess = "1 3";
    caseResult = "failed";
    boatsStatusArr = dotCom.checkYourself(userGuess);
    if(boatsStatusArr[0].equals("hit") && boatsStatusArr[1].equals("hit")){
      caseResult = "passed";
    }
    System.out.println("Case 4 : " + caseResult + "\n");

    // # CASE5
    userGuess = "1 2";
    caseResult = "failed";
    boatsStatusArr = dotCom.checkYourself(userGuess);
    if(boatsStatusArr[0].equals("kill") && boatsStatusArr[1].equals("")){
      caseResult = "passed";
    }
    System.out.println("Case 5 : " + caseResult + "\n");

    // # CASE6
    userGuess = "3 3";
    caseResult = "failed";
    boatsStatusArr = dotCom.checkYourself(userGuess);
    if(boatsStatusArr[0].equals("") && boatsStatusArr[1].equals("kill")){
      caseResult = "passed";
    }
    System.out.println("Case 6 : " + caseResult + "\n");

    // # CASE7
    userGuess = "1 3";
    caseResult = "failed";
    boatsStatusArr = dotCom.checkYourself(userGuess);
    if(boatsStatusArr[0].equals("") && boatsStatusArr[1].equals("")){
      caseResult = "passed";
    }
    System.out.println("Case 7 : " + caseResult + "\n");
  }
}

*/
