import java.util.ArrayList;
public class Mergesort
{
    /**
     * Sorts an ArrayList of "StudentInfo" classes using the mergesort 
     * algorithm.
     * 
     * @author Hans Hoelzer
     * @version 4/16/2018
     * @param an ArrayList of "StudentInfo" classes
     * @return a sorted list of "StudentInfo" classes
     */
    public ArrayList<Team> sort(ArrayList<Team> tL,int type)
    {
        ArrayList<Team> a = new ArrayList<Team>();
        ArrayList<Team> b = new ArrayList<Team>();
        int cut = (int) (tL.size()/2+.5);
        for(int i=0;i<cut;i++){
            a.add(tL.get(i));
        }
        for(int i=cut;i<tL.size();i++){
            b.add(tL.get(i));
        }
         //MADE BY HANS HOELZER
        if(a.size()>1){
            a = sort(a,type);
        }
        if(b.size()>1){
            b = sort(b,type);
        }
        return merge(a,b,type); 
    }
    
    /**
     *A private method used by the sort method. Combines two ArrayLists of 
     *"StudentInfo" classes with atleast one containing a value. 
     *
     *@param a One ArrayList of "StudentInfo" 
     *@param b A second ArrayList of "StudentInfo"
     *@return A combined list in acesening order of "StudentInfo"
     */
    private ArrayList<Team> merge(ArrayList<Team> a,ArrayList<Team> b,int type)
    {
        int n = a.size()+b.size();
        ArrayList<Team> c = new ArrayList<Team>();
        for(int i=0;i<n;i++){
            if(a.size()< 1){
                c.add(b.get(0));
                b.remove(0);
                 //MADE BY HANS HOELZER
            } else 
            if(b.size()< 1){
                c.add(a.get(0));
                a.remove(0);
            } else
            if(1 == a.get(0).compareTo(b.get(0),type) || 0 == a.get(0).compareTo(b.get(0),type)){
                c.add(b.get(0));
                b.remove(0);
                 //MADE BY HANS HOELZER
            } else 
            if(-1 == (a.get(0).compareTo(b.get(0),type))){
               c.add(a.get(0));
               a.remove(0); 
            }
        }
        return c;
    }
}
