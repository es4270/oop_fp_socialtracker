import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.time.LocalDate;
public class buttmgr{

  ArrayList<JButton> butts = new ArrayList<JButton>();
  ArrayList<friend> friends = new ArrayList<friend>();
  ArrayList<hang> hangs = new ArrayList<hang>();
  ArrayList<JSpinner> spinners = new ArrayList<JSpinner>();
  ArrayList<JList> lists = new ArrayList<JList>();
  public buttmgr(){
    
  }
  public buttmgr(JButton[] intake, ArrayList<friend> frands){
    for(int i = 0; i<intake.length; i++){
      butts.add(intake[i]);
    }
    friends = frands;
  }

  public void add(JButton[] intake, ArrayList<friend> frand){
    for(int i = 0; i<intake.length; i++){
      butts.add(intake[i]);
    }
    for(int j = 0; j<frand.size(); j++){
      friends.add(frand.get(j));
    }
  }

  // public class hangmgr{
  //   ArrayList<JSpinner> spinners = new ArrayList<JSpinner>();
  //   ArrayList<JList> lists = new ArrayList<JList>();
  //   ArrayList<JButton> buttonz = new ArrayList<JButton>();
    
  //   public hangmgr(JSpinner[] inp){
  //     for(int i = 0; i < inp.length; i++){
  //       spinners.add(inp[i]);
  //     }
  //   }
  // }

  
}