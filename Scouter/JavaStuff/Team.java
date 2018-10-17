import java.util.*;
import java.io.*;

public class Team{

private int teamNumber;
private ArrayList<Match> matches = new ArrayList<Match>();

public Team(int number){
teamNumber = number;
}

public int getTeamNumber(){
return teamNumber;
}

public void addMatch(Match m){
matches.add(m);
}

public String toString(){
return "Team: " + teamNumber;
}

public String encode(){
String out = ""+teamNumber;
for(Match m:matches){
out += ","+ m.getMatchNumber();
for(int n:m.getData()){
out += " " + n;
}
}
return out;
}

public Match getMatch(int n){
if(n<matches.size()){
return matches.get(n);
}
return matches.get(0);
}

public ArrayList<Match> getMatches(){
return matches;
}

public int compareTo(Team t, int type){ //secodary int input for type of rating to call  0=by team num 1= by rating
double aRank = 0;
double bRank = 0;
if(type ==0){
aRank = getTeamNumber();
bRank = t.getTeamNumber();
}else{
aRank =1000 - rating();
bRank = 1000 - t.rating();
}
if(aRank > bRank){
return 1;
}else if(aRank < bRank){
return -1;
}else{
return 0;
}}

public int rating(){ //maybe have int input for type of rating
File file = new File("../../Scouter/config.txt");
int total =0;
try{
Scanner sc = new Scanner(file);

String line = sc.nextLine();
//int[] rank = new int[20];
String[] rank =line.split(",");

for(Match m:matches){
int[] mD = m.getData();
for(int i=0;i<mD.length;i++){
total += mD[i] *  Double.parseDouble(rank[i]);
}}
return total/matches.size();
}catch(Exception e){
System.out.println("ERROR FINDING CONFIG");
return -1;
}
}

public String toString(String[] l){
String s = "Team: " + teamNumber + "\n";
for(int i=0;i<matches.size();i++){
s += matches.get(i).toString(l);
}
return s;
} 

}