import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class hang {
  LocalDate date;
  ArrayList<friend> homies = new ArrayList<friend>();
  ArrayList<group> groups = new ArrayList<group>();
  int score;
  String type;
  boolean complete = false;
  private static ArrayList<String> hangtypes = new ArrayList<String>();
  static ArrayList<hang> allhangs = new ArrayList<hang>();

  public hang(){}
  public hang(ArrayList<friend> fren, int scor, String typ){
    date = LocalDate.now();
    score = scor;
    
    for(int i = 0; i < fren.size(); i++){
      homies.add(fren.get(i));
      for(int j = 0; j < fren.get(i).groups.size(); j++){
        if(!groups.contains(fren.get(i).groups.get(j))){
          groups.add(fren.get(i).groups.get(j));
        }
      }
    }
    if(!hangtypes.contains(typ)){
      hangtypes.add(typ);
    }
    type = typ;
    for(int j = 0; j < homies.size(); j++){
      homies.get(j).addHang(this);
    }
    allhangs.add(this);
  }
  
  public static Comparator<hang> comp_date = new Comparator<hang>(){
    public int compare(hang a, hang b){
      LocalDate adate = a.date;
      LocalDate bdate = b.date;
      return adate.compareTo(bdate);
    }
  };
  public static Comparator<hang> comp_score = new Comparator<hang>(){
    public int compare(hang a, hang b){
      int ascore = a.score;
      int bscore = b.score;
      return ascore-bscore;
    }
  };

  

  //for testing purposes
  public static void hangtest(){
    Random rand = new Random();
    for(int i = 0; i < 10; i++){
      hangtypes.add("hangtype" + rand.nextInt(0,10));
    }
  }

  public static void printTypes(){
    for(int i = 0; i < hangtypes.size(); i++){
      System.out.println(hangtypes.get(i));
    }
  }

  hang(hang heng){
    date = heng.date;
    homies = new ArrayList<friend>();
    for(int i = 0; i < heng.homies.size(); i++){
      homies.add(heng.homies.get(i));
      heng.homies.get(i).addHang(this);
    }
    groups = new ArrayList<group>();
    for(int i = 0; i < heng.homies.size(); i++){
      groups.add(heng.groups.get(i));
    }
    score = heng.score;
    type = heng.type;
  }

  public static String[] typeList(){
    String[] ret = new String[hangtypes.size()];
    for(int i = 0; i< hangtypes.size();i++){
      ret[i] = hangtypes.get(i);
    }
    return ret;
  }

  public int daysFromHang(){
      return date.compareTo(LocalDate.now());
  }

  public void editDate(int y, int m, int d){
    // Random rand = new Random();
    // date = LocalDate.of(rand.nextInt(2) + 2023, rand.nextInt(12) + 1, rand.nextInt(30)+1);
    date = LocalDate.of(y, m, d);
  }

  public String getDateString(){
    if(this.complete == false){
      return "Scheduled for " + date.toString();
    }else{
      return date.toString();
    }
  }

  public static ArrayList<hang> hangListGroup(group grup, ArrayList<hang> hanglist){
    ArrayList<hang> ret = new ArrayList<hang>();
    for(int i = 0; i < hanglist.size(); i++){
      if(hanglist.get(i).groups.contains(grup)){
        ret.add(hanglist.get(i));
      }
    }
    return ret;
  }

  public static ArrayList<hang> hangListFriend(friend fren, ArrayList<hang> hanglist){
    ArrayList<hang> ret = new ArrayList<hang>();
    for(int i = 0; i < hanglist.size(); i++){
      if(hanglist.get(i).homies.contains(fren)){
        ret.add(hanglist.get(i));
      }
    }
    return ret;
  }

  public static ArrayList<hang> listDateSort(ArrayList<hang> hanglist, boolean ascdsc){
    ArrayList<hang> ret = new ArrayList<hang>();
    // System.out.println("hanglist inp size: " + hanglist.size());
    for(int i = 0; i < hanglist.size(); i++){
      ret.add(hanglist.get(i));
    }
    // System.out.println("ret len: " + ret.size());
    if(ascdsc == true){
      Collections.sort(ret, hang.comp_date);
    }else{
      Collections.sort(ret, Collections.reverseOrder(hang.comp_date));
    }
    // System.out.println("ret len: " + ret.size());
    return ret;
  }

  public static ArrayList<hang> listScoreSort(ArrayList<hang> hanglist, boolean ascdsc){
    ArrayList<hang> ret = new ArrayList<hang>(hanglist);
    if(ascdsc == true){
      Collections.sort(ret, hang.comp_score);
    }else{
      Collections.sort(ret, Collections.reverseOrder(hang.comp_score));
    }
    return ret;
  }

  public static ArrayList<hang> allhanglist(){
    ArrayList<hang> ret = new ArrayList<hang>(allhangs);
    return ret;
  }

  public static ArrayList<hang> compl_seplist(ArrayList<hang> hanglist, boolean compl){
    //true = complete
    //false = incomplete
    ArrayList<hang> ret = new ArrayList<hang>();
    for(int i = 0; i < hanglist.size(); i++){
      if(hanglist.get(i).complete == compl){
        ret.add(hanglist.get(i));
      }
    }
    return ret;
  }

  public void markComplete(){
    this.complete = true;
    for(int i = 0; i < homies.size(); i++){
      homies.get(i).updateScore(this);
    }
  }
  

  
  
  
}