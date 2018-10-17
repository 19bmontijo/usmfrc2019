import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class main{

public static void main(String[] args){
//String[] l = {"Swtch","Scl","Ato"};
Driver d = new Driver();
Scanner sc = new Scanner(System.in);




//--Scout ID lable? Died/Failure Lable
//--Balanced sort that takes off bad games
//--config.txt sets labels and list names for ease of use
//d.addTeamManual();
//d.addTeamPhone();
//d.uploadFile();
//d.sortTeams();
//d.printTeams();
//d.writeTeams("list.txt");
//d.searchTeams();
boolean exit = false;
while(!exit){
System.out.println();
System.out.println();
System.out.println("-----------------------------------");

System.out.println("Select a command: \n1: d.addTeamManual(); \n2: d.addTeamPhone(); \n3: d.uploadFile(); \n4: d.sortTeams(); \n5: d.printTeams(); \n6: d.writeTeams(\"list.txt\")(); \n7: d.searchTeams(); \n8: Save and Exit \n9: DO NOT Save and Exit" );
int s = sc.nextInt();
System.out.println("-----------------------------------");

switch(s){
   case 1 :
      d.addTeamManual();
      break;
   case 2 :
      d.addTeamPhone();
      break;
   case 3 :
      d.uploadFile();
      break;
   case 4 :
      d.sortTeams();
      System.out.println("Teams sorted");
      break;
   case 5 :
      d.printTeams();
      break;
   case 6 :
      d.writeTeams();
      System.out.println("All saved");
      break;
   case 7 :
      d.searchTeams();
      break;
   case 8 :
      d.writeTeams();
      exit = true;
      break;
   case 9:
      System.out.println("Are you sure? No uploads will be saved unless done so before. (Y/N)");
      if(sc.next().equals("Y"))
      exit = true;
      break;
   default : 
      System.out.println("Unknown command, plz enter one of the listed");
}}
System.out.println("Scouter is now closed");
}
}