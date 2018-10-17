import java.util.*;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;

public class Filestuff{

public ArrayList<Team> decodeFile(String s){
File doc = new File(s);
try{
   Scanner sc = new Scanner(doc);
   String line = "";
   ArrayList<Team> teamList = new ArrayList<Team>();
   while(sc.hasNextLine()){
      line = sc.nextLine();
      Team t = decodeString(line);
      teamList.add(t);
   }
   return teamList;
}catch(Exception e){System.out.println("Error: " + e); return new ArrayList<Team>();
}
}

public Team decodeString(String input){
String[] sA = input.split(",");
Team t = new Team(Integer.parseInt(sA[0]));

for(int i = 1; i<sA.length; i++){
String[] a = sA[i].split("\\s");
Match match = new Match(Integer.parseInt(a[0]));
int[] data = new int[a.length - 1];
for(int k = 1; k<a.length; k++){
data[k-1] = Integer.parseInt(a[k]);
}
match.addData(data);
t.addMatch(match);
}
return t;
}


public void encode(ArrayList<Team> tL, String fileName){
try{
File doc = new File(fileName);

BufferedWriter out = new BufferedWriter(new FileWriter(doc, false));
for(Team t:tL){
out.append(t.encode() + "\n");
}
out.close();
}catch(IOException e){System.out.println("Error: " + e);}
}        

public String[] getLabelsFromConfig(){
File config = new File("../config.txt");
try{
Scanner fileScanner = new Scanner(config);
fileScanner.nextLine();
String lablesString = fileScanner.nextLine();
return lablesString.split(",");
}catch(Exception e){
System.out.println("Config not found. Error: " + e);
return new String[1];
}
}

public String getListNameFromConfig(){
File config = new File("../config.txt");

try{
Scanner fileScanner = new Scanner(config);
fileScanner.nextLine();
fileScanner.nextLine();
return fileScanner.nextLine();
}catch(Exception e){
System.out.println("Config not found. Error: " + e);
return "ERROR";
}
}


public ArrayList<Team> decodeUpload(File f){
try{
Scanner sc = new Scanner(f);
String string = sc.nextLine();
ArrayList<Team> tL = new ArrayList<Team>();
String[] tLT = string.split("\\|");

for(int i=1;i<tLT.length;i++){
String[] mA = tLT[i].split(",");
Team t = new Team(Integer.parseInt(mA[0]));
Match m = new Match(Integer.parseInt(mA[1]));
int[] data = new int[mA.length-2];
for(int k=2; k<mA.length;k++){
data[k-2] = Integer.parseInt(mA[k]);
} 
m.addData(data);
t.addMatch(m);
tL.add(t);
}

return tL;


}catch(Exception e){System.out.println("Error: " + e);return new ArrayList<Team>();}
}

}












