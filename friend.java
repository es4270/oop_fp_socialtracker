import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDate;
import java.time.Period;

public class friend {
  String name;
  public int cadenceint; //int of days since last seen

  //format of cadencetime will be "M-W-D"
  public int[] cadencetime = {0,0,0}; //int of how often would I like to see them
  ArrayList<group> groups = new ArrayList<group>();
  ArrayList<hang> hangs = new ArrayList<hang>();
  public int count = 0;

  private int id;
  float avgscore = 0;
  

  static group allfriends = new group("allfriends");
  

  public friend(String nam){
      
    name = nam;
    allfriends.add(this);
    id = allfriends.count;
    
    
  }

  friend(friend fren){
    name = fren.name;
    cadenceint = fren.cadenceint;
    cadencetime = fren.cadencetime;
    for(int i = 0; i < fren.groups.size(); i++){
      groups.add(fren.groups.get(i));
    }
    for(int i = 0; i < fren.hangs.size(); i++){
      hangs.add(fren.hangs.get(i));
    }
    hangs = fren.hangs;
    count = fren.count;
    avgscore = fren.avgscore;
  }

  public static String[] allFriendsArray(){
    return allfriends.groupToArray();
  }

  public static Comparator<friend> comp_name = new Comparator<friend>(){
    public int compare(friend a, friend b){
      String sa = a.name.toUpperCase();
      String sb = b.name.toUpperCase();
      return sa.compareTo(sb);
    }
  };

  public static Comparator<friend> comp_count = new Comparator<friend>(){
    public int compare(friend a, friend b){
      int acount = a.count;
      int bcount = b.count;
      return acount - bcount;
    }
  };
  
  public static Comparator<friend> comp_cadenceint = new Comparator<friend>(){
    public int compare(friend a, friend b){
      int acount = a.cadenceint;
      int bcount = b.cadenceint;
      return acount - bcount;
    }
  };

  public void addToGroup(group grup){
    // String groupname = grup.name();
    // System.out.println("Friend adding to group: " + this.name);
    // System.out.println("Group being added to: " + grup.name);
    grup.members.add(this);
    grup.count++;
    groups.add(grup);
  }

  public void addHang(hang hangy){
    if(hangy.complete == true){
    count++;
    float temp = ((avgscore*(count-1))+hangy.score)/count;
    avgscore = temp;
    // hangy.complete = true;
    cadenceint = LocalDate.now().compareTo(hangy.date);}
    hangs.add(hangy);
  }

  public void updateScore(hang hangy){
    count++;
    float temp = ((avgscore*(count-1))+hangy.score)/count;
    avgscore = temp;
    // hangy.complete = true;
    // cadenceint = LocalDate.now().compareTo(hangy.date);
  }

  public LocalDate dateLastSeen(){
    if(hang.compl_seplist(this.hangs, true).size() == 0){
      return LocalDate.MIN;
    }
    return hang.listDateSort(hang.compl_seplist(this.hangs, true), false).get(0).date;
  }

  public String daysSinceLastSeen(){
    // System.out.println(LocalDate.now().toString());
    if(this.dateLastSeen().equals(LocalDate.MIN)){
      return "No Hangouts Completed";
    }
    String ret = "";
    Period temp = this.dateLastSeen().until(LocalDate.now());
    if(temp.getYears() != 0){
      ret += temp.getYears() + " years, ";
    }
    if(temp.getMonths() != 0){
      ret += temp.getMonths() + " months, ";
    }
    if(temp.getDays() != 0){
      ret += temp.getDays() + " days";
    }
    
    return ret;
  }
  public String cadenceString(){
    String ret = "";
    if(cadencetime[0] != 0){
      ret += cadencetime[0] + " months";
    }
    if(cadencetime[1] != 0){
      ret += cadencetime[1] + " weeks";
    }
    if(cadencetime[2] != 0){
      ret += cadencetime[2] + " days";
    }
    return ret;
  }
  public LocalDate nextDueDate(){
    // int ret = 0;
    if(this.dateLastSeen().equals(LocalDate.MIN)){
      return LocalDate.now();
    }
    LocalDate temp = this.dateLastSeen().plusMonths(cadencetime[0]);
    temp = temp.plusWeeks(cadencetime[1]);
    temp = temp.plusDays(cadencetime[2]);
    return temp;
  }

  public String nextDueDays(){
    
    Period temp = LocalDate.now().until(this.nextDueDate());
    String ret = "";
    int overdue = 1;

    if(temp.isNegative()){
      ret += "(OVERDUE) ";
      overdue = -1;
    }
    
    if(temp.getYears() != 0){
      ret += (overdue*temp.getYears()) + " years, ";
    }
    if(temp.getMonths() != 0){
      ret += (overdue*temp.getMonths()) + " months, ";
    }
    if(temp.getDays() != 0){
      ret += (overdue*temp.getDays()) + " days";
    }
    return ret;
  }

  public LocalDate nextHangDate(){
    ArrayList<hang> sorted =  hang.listDateSort(hang.compl_seplist(this.hangs, false), true);
    if(sorted.size() > 0){
      return sorted.get(0).date;
    }else{
      return LocalDate.MAX;
    }
  }

  public boolean hasScheduled(){
    if(hang.compl_seplist(this.hangs, false).size() == 0){
      return false;
    }else{
      return true;
    }
  }
  
  public boolean needsReminder(){
    if(this.nextHangDate().compareTo(this.nextDueDate()) > 0 || this.hasScheduled() == false){
      return true;
    }else{
      return false;
    }
  }

  

  
  
}