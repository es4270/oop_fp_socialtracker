import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.time.*;

public class pagenav 
  extends pages 
  
  implements ActionListener{

  static int flag = 0;
  private static ArrayList<friend> tempfriends = new ArrayList<friend>();
    private static ArrayList<hang> temphangs = new ArrayList<hang>();
    private static ArrayList<group> tempgroups = new ArrayList<group>();
    private static ArrayList<String> tempstrings = new ArrayList<String>();
    private static ArrayList<JSpinner> spinners = new ArrayList<JSpinner>();
    private static ArrayList<JList> lists = new ArrayList<JList>();
    private static ArrayList<JComponent> comps = new ArrayList<JComponent>();
    private static ArrayList<Integer> ints = new ArrayList<Integer>();
    

    static void clearclear(){
      inputclear();
      tempfriends.clear();
      temphangs.clear();
      tempgroups.clear();
      tempstrings.clear();
      spinners.clear();
      lists.clear();
      comps.clear();
      ints.clear();
      flag = 0;
    }

    
    

  // static pages page = new pages();

  public void actionPerformed(ActionEvent e) { 
    // buttmgr test = new buttmgr();
    if(e.getSource() == menuinputs.get(0)){
      clear();
      homePage();
    }else if(e.getSource() == menuinputs.get(1)){
      clear();
      fP_all();
      for(int i = 0; i < inputs.size(); i++){
        if(e.getSource() == inputs.get(i)){
          friendInfoPage(tempfriends.get(i));
        }
      }
      
      // friendInfoPage(test.friends.get(indexOf(e.getSource())));
      
    }else if(e.getSource() == menuinputs.get(2)){
      clear();
      hangLogPage(hang.allhanglist());
    }else if(e.getSource() == menuinputs.get(3)){
      clear();
      addFriendPage();
    }else if(e.getSource() == menuinputs.get(4)){
      clearclear();
      addHang();
      
    }
    
    if(e.getSource() == inputs.get(0)&& flag ==2){
      hang newhang = new hang();
      newhang.date = LocalDate.now().plusMonths(ints.get(0)).plusWeeks(ints.get(1)).plusDays(ints.get(2));
      newhang.type = tempstrings.get(0);
      for(int i = 0; i < tempfriends.size(); i++){
        tempfriends.get(i).addHang(newhang);
        newhang.homies.add(tempfriends.get(i));
      }
      hang.allhangs.add(newhang);
      clear();
      hangLogPage(hang.allhanglist());


    }else if(e.getSource() == inputs.get(1)){
      homePage();
    }

    for(int i = 0; i < inputs.size(); i++){
      if(e.getSource() == inputs.get(i)){
        friendInfoPage(tempfriends.get(i));
      }
    }

    
    
    
    
     menuactions();
    
    // }else if(e.getSource() == menu[1]){
    //   clear();
    //   homePage();
    // }else if(e.getSource() == menu[2]){
    //   clear();
    //   homePage();
    // }else if(e.getSource() == menu[3]){
    //   clear();
    //   homePage();
    // }
  }

  private void menuactions(){
    menuinputs.get(0).addActionListener(this);
    menuinputs.get(1).addActionListener(this);
    menuinputs.get(2).addActionListener(this);
    menuinputs.get(3).addActionListener(this);
    menuinputs.get(4).addActionListener(this);
    // menuinputs.get(5).addActionListener(this);
    // menu[1].addActionListener(this);
    // menu[2].addActionListener(this);
    // menu[3].addActionListener(this);
  }

  

  public void run(){
    hP();
  }
    
  

  public void hP(){
    homePage();
    clearclear();
    menuactions();
    // friendPage(friend.allfriends);
  }

  public void fP_all(){
    clearclear();
    buttmgr inp = friendPage(friend.allfriends);
    
    frendPage_actions(inp);
    flag = 1;
    
    
  }

  private void frendPage_actions(buttmgr inp){
    for(int i = 0; i < inp.butts.size(); i++){
      
      inp.butts.get(i).addActionListener(this);
      inputs.add(inp.butts.get(i));
      tempfriends.add(inp.friends.get(i));
      System.out.println(inputs.size());
      System.out.println(tempfriends.size());
    }
  }

  private void addHang(){
    clearclear();
    buttmgr temp = schedHangPage();
    temp.butts.get(0).addActionListener(this);
    inputs.add(temp.butts.get(0));
    temp.butts.get(1).addActionListener(this);
    inputs.add(temp.butts.get(1));
    ints.add((Integer) temp.spinners.get(0).getValue());
    ints.add((Integer) temp.spinners.get(1).getValue());
    ints.add((Integer) temp.spinners.get(2).getValue());
    tempstrings.add((String) temp.lists.get(1).getSelectedValue());
    for(int i = 0; i < temp.lists.get(0).getSelectedValuesList().size(); i++){
      tempstrings.add((String)temp.lists.get(0).getSelectedValuesList().get(i));
    }
    for(int j = 1; j < tempstrings.size(); j++){
      for(int k = 0; k < friend.allfriends.members.size(); k++){
        if(tempstrings.get(j) == friend.allfriends.members.get(k).name){
          tempfriends.add(friend.allfriends.members.get(k));
        }
      }
    }
    flag = 2;
    
  }

  

  
  
}