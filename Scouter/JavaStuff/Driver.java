import java.util.*;
import java.io.*;

public class Driver{
private ArrayList<Team> tL;
private Filestuff fS = new Filestuff();
private Mergesort mS = new Mergesort();
private String[] l;
private String listName;
Scanner sc = new Scanner(System.in);

public Driver(){
listName = fS.getListNameFromConfig();
tL = fS.decodeFile(listName);
l = fS.getLabelsFromConfig();
}

public void updateTeam(Team t){
boolean addTeam =true;
for(int i=0;i<tL.size();i++){
if(tL.get(i).getTeamNumber()==t.getTeamNumber()){
ArrayList<Match> matches = t.getMatches();
for(Match m:matches)
tL.get(i).addMatch(m);
addTeam=false;
}
}
if(addTeam){
tL.add(t);
}
}


public void updateTeam(ArrayList<Team> t){
for(int i =0;i<t.size();i++){
updateTeam(t.get(i));
}
}

//Ask for a regular list file
public void uploadFile(){
System.out.println("File Name (including extension):");
updateTeam(fS.decodeFile("../Uploads/" + sc.next()));
}

public void sortTeams(){
System.out.println("Select sorting method: 0 = by team number, 1 = by rating.");
Scanner sc = new Scanner(System.in);
int type = sc.nextInt();
tL = mS.sort(tL,type);
}

public void printTeams(){
for(Team t:tL){
System.out.println(t.toString(l));
}
}

public void addTeamManual(){

System.out.println("Team Number:");
Team t = new Team(sc.nextInt());
System.out.println("Match Number:");
int mN = sc.nextInt();
int[] matchData = new int[l.length];
for(int i=0;i<matchData.length;i++){
   System.out.println("Points scored in " + l[i] + " :");
   matchData[i] = sc.nextInt();
}
Match m = new Match(mN,matchData);
t.addMatch(m);
updateTeam(t);
}

public void addTeamPhone(){
System.out.println("File name (including extension):");
File f = new File("../Uploads/" + sc.next());
updateTeam(fS.decodeUpload(f));
} 

public void writeTeams(){
fS.encode(tL,listName);
}

public void searchTeams(){
boolean found = false;
System.out.println("Team number to search for:");
int target = sc.nextInt();
for(int i =0;i<tL.size();i++){
   if(target == tL.get(i).getTeamNumber()){
      found = true;
      System.out.println(tL.get(i).toString(l));
   }
      }
if(!found)
System.out.println("Team " + target + " was not found.");
}

}