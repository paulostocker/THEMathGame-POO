import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class THEMathGame
{
  
  private static int option = 0;
  private static int tries = 5;
  private static int roundNum = 1;
  private static float correctAnswer = 0f;
  private static float answer = 0f;
  private static Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args)
  {
	while(drawMenu() != 2){
		initializeGame();
	}
	sc.close();
  }
  
  public static void initializeGame()
  {
	int stageNum = 1;
	while(stageNum <= 3){
		initializeStage(stageNum);
		stageNum++;
	}
	tries = 5;
  }
  
  public static void initializeStage(int stageNum)
  {
	roundNum = 1;
	while(roundNum <= 10 && tries > 0){
		drawStage(stageNum);
		roundNum++;
	}
  }
  
  public static int drawMenu()
  {
  	System.out.println("\n--------------------------");
  	System.out.println("| Welcome to THEMathGame |");
  	System.out.println("|        v1.0            |");
  	System.out.println("--------------------------");
  	System.out.println("> 1 - New Game");
  	System.out.println("> 2 - Exit Game");
    return getOption();
  } 
  
  public static int getOption()
  {	
  	System.out.println("--------------------------");
  	System.out.print(" - Enter the option: ");
    try{
      option = sc.nextInt();
    } catch(Exception ex){
  		System.out.println(" * Sorry, check if you entered the option number");
    }
	return option;
  }
  
  public static void drawStage(int stageNum)
  {
	int first = 0;
	int second = 0;
	String operator = "";
	Random rd = new Random();
	
  	System.out.println("\n-------------------------");
  	System.out.println(String.format("| 	** LEVEL #%d **   |", stageNum));
  	System.out.println(String.format("| 	   Round %d       |", roundNum));
  	System.out.println("-------------------------");
	first = rd.nextInt(50)+1;
	second = rd.nextInt(50)+1;
	switch(stageNum){
		case 1:
			int op = rd.nextInt(2);
			operator = (op>0?"+":"-");
			correctAnswer = (op>0? first+second : first-second);
		break;
		case 2:
			operator = "*";
			correctAnswer = first*second;
		break;
		case 3:
			operator = "/";
			correctAnswer = first/second;
		break;
	}
  	System.out.println(String.format("> %d %s %d",first,operator,second));
	getAnswer();
	checkAnswer();
  } 
  
  public static void getAnswer()
  {	
    Scanner sc = new Scanner(System.in);
  	System.out.println("\n--------------------------");
  	System.out.print("> Answer: ");
    try{
        answer = Float.parseFloat(sc.next());
    } catch(Exception ex){
  		System.out.println(" * Sorry, check if you entered the option number");
    }
  }
  
  public static void checkAnswer()
  {
	if(answer != correctAnswer){
		System.out.println("* Incorreta");
		tries--;
		roundNum--;
		System.out.println(String.format("- Você tem mais %d tentativas",tries));
	}else{
		System.out.println("* Correta");
	}
  }
  
}