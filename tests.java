import java.util.*;
import java.time.LocalDate;

public class tests {

  static Random rand = new Random();
  private static String[] testhangtypes = {"cafe", "sports", "meal", "art", "date"};
  private static String[] testgroups = {"nyu", "high school", "vball", "misc", "doge"};
  private static String[] randnames = {"steph", "KD", "LEBRON JAMEZ", "edward", "naga", "ishikawa", "defalco", "mr pistacchi"};

  public static void makeGroups(){
    for(int i = 0; i < testgroups.length; i++){
      new group(testhangtypes[i]);
    }
  }

  public static ArrayList<friend> makeFriends(){
    // String[] format = {"M", "W", "D"};
    ArrayList<friend> ret = new ArrayList<friend>();
    for(int i = 0; i < randnames.length; i++){
      friend yep = new friend(randnames[i]);
      yep.cadenceint = rand.nextInt(31);
      yep.cadencetime[rand.nextInt(3)] = rand.nextInt(5);
      for(int j = 0; j < rand.nextInt(2) + 1; j++){
        // System.out.println(yep.name);
        // System.out.println(friend.allfriends.count);
        // System.out.println(group.getAllGroups().get(0).name);
        group toaddto = group.getAllGroups().get(rand.nextInt(group.getAllGroups().size()));
        if(!toaddto.name.equals("allfriends")){
          yep.addToGroup(toaddto);
        }
      }
      ret.add(yep);
    }
    return ret;
  }

  public static void makeHangs(){
    int fselect = rand.nextInt(friend.allfriends.count);
    boolean complstat = rand.nextBoolean();
    for(int i = 0; i < 25; i++){
      ArrayList<friend> attendees = new ArrayList<friend>();
      for(int j = 0; j < rand.nextInt(3) + 1; j++){
        if(!attendees.contains(friend.allfriends.members.get(fselect))){
          attendees.add(friend.allfriends.members.get(fselect));
        }
        fselect = rand.nextInt(friend.allfriends.count);
      }

      hang test = new hang(attendees, 0, testhangtypes[rand.nextInt(testhangtypes.length)]);
      if(complstat == true){
        test.score = rand.nextInt(11);
        test.date = LocalDate.now().minusDays(rand.nextInt(300));
        test.markComplete();
      }else{
        test.date =  LocalDate.now().plusDays(rand.nextInt(300));
      }
      
      complstat = rand.nextBoolean();
      
    }
    
  }

  public static void run(){
    makeGroups();
    makeFriends();
    makeHangs();
    
  }
  
}