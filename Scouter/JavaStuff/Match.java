public class Match{

int[] data;
int matchNumber;

public Match(int mN,int[] d){
matchNumber = mN;
data = d;
}

public Match(int mN){
matchNumber = mN;
}

public void addData(int[] d){
data = d;
}

public int getMatchNumber(){
return matchNumber;
}

public int[] getData(){
return data;
}

public String toString(){
return "Match: " + matchNumber + " Data: " + data;
}

public String toString(String[] l){
String s = "Match: " + matchNumber + "    ";
for(int i = 0;i<data.length;i++){
if(!(i>=l.length))
s += l[i] + ": " + data[i] + "   ";
}

return s+"\n";
}

}