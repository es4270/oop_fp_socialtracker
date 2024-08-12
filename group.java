import java.util.*;

public class group{
  String name;
  ArrayList<friend> members = new ArrayList<friend>();
  int count = members.size();

  public group(String inp){
    name = inp;
    allgroups.add(this);
  }

  group(group grup){
    name = grup.name;
    for(int i = 0; i < grup.count; i++){
      members.add(grup.members.get(i));
    }
    count = members.size();
  }

  private static ArrayList<group> allgroups = new ArrayList<group>();
  
  

  public void add(friend fren){
    this.members.add(fren);
    count++;
  }

  public static String[] allList(boolean none){

    //FOR TESTING PURPOSES
    // new group("THE BOYZ");
    // System.out.println(allgroups.size());

    
    String[] ret;
    if(none == true){
      ret = new String[allgroups.size() + 1];
      ret[0] = "None";
    }else{
      ret = new String[allgroups.size()];
    }
    if(!allgroups.isEmpty()){
      for(int i = 0; i < allgroups.size(); i++){
        if(none == true){
          ret[i+1] = allgroups.get(i).name;
        }else{
          ret[i] = allgroups.get(i).name;
        }
      }
    }
    
    return ret;
  }

  public group sort(int attr, boolean ascdsc){
    group ret = new group(this);
    Collections.sort(ret.members, friend.comp_count);
    
    String newname = this.name;
    if(ascdsc == true){
      Collections.sort(ret.members, friend.comp_count);
      newname += "_sort_a";
    }else{
      Collections.sort(ret.members, Collections.reverseOrder(friend.comp_count));
      newname += "_sort_d";
    }
    
    // ArrayList<friend> temp = new ArrayList<friend>();
    // temp = this.members;
    // group ret = new group(this);
    // Collections.sort(ret.members, friend.comp_count);
    ret.name = newname;
    // for(int i = 0; i < ret.members.size(); i++){
    //   System.out.println(ret.members.get(i).count);
    // }
    return ret;
    
  }
  public group sortb(int attr, boolean ascdsc){
    group ret = new group(this);
    Collections.sort(ret.members, friend.comp_cadenceint);

    String newname = this.name;
    if(ascdsc == true){
      Collections.sort(ret.members, friend.comp_cadenceint);
      newname += "_sort_a";
    }else{
      Collections.sort(ret.members, Collections.reverseOrder(friend.comp_cadenceint));
      newname += "_sort_d";
    }

    // ArrayList<friend> temp = new ArrayList<friend>();
    // temp = this.members;
    // group ret = new group(this);
    // Collections.sort(ret.members, friend.comp_count);
    ret.name = newname;
    // for(int i = 0; i < ret.members.size(); i++){
    //   System.out.println(ret.members.get(i).count);
    // }
    return ret;

  }

  public String[] groupToArray(){
    String[] ret = new String[this.members.size()];
    for(int i = 0; i < this.members.size(); i++){
      ret[i] = this.members.get(i).name;
    }
    return ret;
  }

  public static ArrayList<group> getAllGroups(){
    ArrayList<group> ret = new ArrayList<group>();
    for(int i = 0; i < allgroups.size(); i++){
      ret.add(allgroups.get(i));
    }
    return ret;
  }
  
}