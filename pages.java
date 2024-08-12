import javax.swing.*;

// import buttmgr.hangmgr;

import java.awt.*;
import java.util.*;
import java.time.LocalDate;

// import org.jdatepicker.JDatePicker;

// private JFrame window;

public class pages extends JFrame {
  static JFrame window;
  public static ArrayList<JButton> menuinputs = new ArrayList<JButton>();
  public static ArrayList<JComponent> inputs = new ArrayList<JComponent>();

  // private static void addinputs_al(ArrayList<JButton> inputs_al){
  //   // inputclear();
  //   for(int i  = 0; i < inputs_al.size(); i++){
  //     buttinputs.add(inputs_al.get(i));
  //   }
  // }
  // private static void addinputs_ar(JButton[] inputs_ar){
  //   // inputclear();
  //   for(int i  = 0; i < inputs_ar.size(); i++){
  //     inputs.add(inputs_ar.get(i));
  //   }
  // }
  

  public static void inputclear(){
    inputs.clear();
  }

  // private JComboBox cadences;
  private int dates[] = {
1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
  };

  // private static JComboBox cadences;
  private static String cadenceoptions[]= {
    "days", "weeks", "months"
  };

  public static void clear(){
    window.removeAll();
  }

  private static JTextField textfield(String name, int length, Container contpane, String lm){
    
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JLabel l1 = new JLabel(name);
    // l1.setLocation(100,100);
    panel.add(l1);

    JTextField t1 = new JTextField(length);
    // t1.setLocation(200,100);
    panel.add(t1);
    contpane.add(panel, lm);
    return t1;
  }

  private static Object[] cadencefield(Container contpane){
    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

    JLabel l2 = new JLabel("Cadence: ");
    // l2.setLocation(100,150);
    panel2.add(l2);
    JSpinner cadenceint = new JSpinner(new SpinnerNumberModel(1,1,99,1));
    // cadenceint.setLocation(200,150);
    // cadenceint.setBounds(x, y, width, height);
    panel2.add(cadenceint);

    JComboBox cadences = new JComboBox(cadenceoptions);
    // cadences.setLocation(300,150);
    panel2.add(cadences);
    contpane.add(panel2);
    Object[] ret = {cadenceint, cadences};
    return ret;
  }

  private static JList selectmenu(String text, Container contpane, String[] array, int mode){
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    JLabel l1 = new JLabel(text);
    // l2.setLocation(100,150);
    panel.add(l1);

    JList ret = new JList(array);
    JScrollPane jcp = new JScrollPane(ret);
    if(mode == 1){
      ret.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION
      );
    }else{
      ret.setSelectionMode(
        ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
      );
    }
    panel.add(jcp);
    contpane.add(panel);
    return ret;
    
  }

  
  

  private static JButton[] buttons(String[] names, Container contpane){
    JButton[] ret = new JButton[names.length];
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)))
    for(int i = 0; i < names.length; i++){
      JButton test = new JButton(names[i]);
      panel.add(test);
      ret[i] = test;
    }
    contpane.add(panel);
    return ret;
    
  }


  //LEADERBOARD
  private static JButton[] leaderboard(group names, Container contpane, int attr, boolean ascdsc){

    JButton[] ret = new JButton[names.count];
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JLabel l1 = new JLabel(names.name);
    JLabel l11 = new JLabel("(Avg Score [Name] Count)");
    JPanel ldbtitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    ldbtitle.setLayout(new BoxLayout(ldbtitle, BoxLayout.X_AXIS));
    ldbtitle.add(l1);
    ldbtitle.add(l11);
    // JButton switchup = new JButton("^/v");
    // ldbtitle.add(switchup);
    
    
    // l1.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(ldbtitle);
    for(int i = 0; i < names.count; i++){
      JPanel testp = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JLabel l2 = new JLabel();
      JButton test = new JButton(names.members.get(i).name);
      JLabel l22 = new JLabel(String.valueOf(names.members.get(i).count));
      l2.setText(String.valueOf(names.members.get(i).avgscore));
      testp.add(l2);
      testp.add(test);
      testp.add(l22);
      panel.add(testp);
      ret[i] = test;
    }
    contpane.add(panel);
    return ret;
    
  }

  private static JButton[] menu(Container contpane){
    // JPanel temp1 = new JPanel();
    // JPanel temp2 = new JPanel();
    String[] menuops = {"Home", "Friends", "Hangout Log", "Add Friend", "Add Hangout"};
    JButton[] ret = buttons(menuops, contpane);
    menuinputs.clear();
    for(int i = 0; i < ret.length;i++){
      menuinputs.add(ret[i]);
    }
    // ret[0].addActionListener(new ActionListener() { 
    //   public void actionPerformed(ActionEvent e) { 
    //     homePage();
    //   } 
    // } );
    // JButton[] ret2 = buttons(menuops2, temp2);
    
    

    // JButton[] ret = new JButton[menuops.length];
    // JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    // for(int i = 0; i < menuops.length; i++){
    //   JButton test = new JButton(menuops[i]);
    //   panel.add(test);
    //   ret[i] = test;
    // }
    // contpane.add(panel);
    // return ret;
    
    return ret;
  }

  private static JSpinner score(Container contpane, int min, int max, int inc){
    JPanel ret = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JLabel l1 = new JLabel("Score on a scale of "+min+" to "+max +":");
    JSpinner scorespin = new JSpinner(new SpinnerNumberModel(min,min,max,inc));
    ret.add(l1);
    ret.add(scorespin);
    contpane.add(ret);
    return scorespin;
  }

  private static JSpinner[] datePicker(Container contpane, String title){
    JPanel ret = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JLabel l1 = new JLabel(title);
    JSpinner monthspin = new JSpinner(new SpinnerNumberModel(0,0,12,1));
    JLabel mlabel = new JLabel("months");
    JSpinner weekspin = new JSpinner(new SpinnerNumberModel(0,0,52,1));
    JLabel wlabel = new JLabel("weeks");
    JSpinner dayspin = new JSpinner(new SpinnerNumberModel(0,0,31,1));
    JLabel dlabel = new JLabel("days");
    ret.add(l1);
    ret.add(monthspin);
    ret.add(mlabel);
    ret.add(weekspin);
    ret.add(wlabel);
    ret.add(dayspin);
    ret.add(dlabel);
    JSpinner[] retspin = {monthspin, weekspin, dayspin};
    
    contpane.add(ret);
    return retspin;
  }

  private static JButton[] hangList(Container contpane, ArrayList<hang> hanglist, int attr, boolean ascdsc){
    JButton[] ret = new JButton[hanglist.size()];
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    // hanglist = hang.listDateSort(hanglist, ascdsc);

    JPanel hltitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    String titlestring = "";
    if(attr == 1){
      hanglist = hang.listScoreSort(hanglist, ascdsc);

    }else{
      hanglist = hang.listDateSort(hanglist, ascdsc);
      
    }
    titlestring += "Score|(type)Participants|Date";
    JLabel label = new JLabel(titlestring);
    hltitle.add(label);
    panel.add(hltitle);
 

    for(int i = 0; i < hanglist.size(); i++){
      JPanel temp = new JPanel(new FlowLayout(FlowLayout.LEFT));
      String buttlabel = "(" + hanglist.get(i).type + ") ";
      int j = 0;
      while(j < hanglist.get(i).homies.size()){
        buttlabel += hanglist.get(i).homies.get(j).name + ", ";
        j++;
      }
      buttlabel = buttlabel.substring(0, buttlabel.length()-2);
      JButton butt = new JButton(buttlabel);
      JLabel datelabe = new JLabel();
      JLabel scorelabe = new JLabel();
      if(hanglist.get(i).complete == true){
        datelabe.setText(String.valueOf(hanglist.get(i).score));
      }else{
         datelabe.setText("N/A");
      }
      scorelabe.setText(hanglist.get(i).getDateString());
      temp.add(datelabe);
      temp.add(butt);
      temp.add(scorelabe);
      ret[i] = butt;
      panel.add(temp);
    }
    contpane.add(panel);
    return ret;
    
  }
  private static JButton remind(friend fren){
    String temp;
    if(fren.dateLastSeen().equals( LocalDate.MIN)){
      temp = "N/A";
    }else{
      temp = fren.dateLastSeen().toString();
    }
    String twoLines = fren.name.toUpperCase() + "\nLast Hang: " + temp+"\n"+ " (" + fren.daysSinceLastSeen()+" ago)\n" + "Usual Cadence: " + fren.cadenceString();
    JButton b = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
    return b;
  }
  
  private static ArrayList<JButton> reminders(Container contpane, group grup){
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel title = new JLabel("Reminders:");
    ArrayList<JButton> ret = new ArrayList<JButton>();
    // ArrayList<hang> schedhangs;
    friend tempfren;
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(title);
    for(int i = 0; i < grup.count; i++){
      tempfren = grup.members.get(i);
      if(tempfren.needsReminder() == true){
        JButton temp = remind(tempfren);
        temp.setLayout(new FlowLayout(FlowLayout.LEFT));
        ret.add(temp);
        panel.add(temp);
      }
    }
    contpane.add(panel);
    return ret;
      
  }

  private static Container pagesetup(String title, int axis){
    inputclear();
    window = new JFrame();
    window.setTitle(title);
    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    window.setResizable(false);
    window.setLocationRelativeTo(null);
    window.setLayout(new FlowLayout(FlowLayout.CENTER));
    // window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
    Container overall = window.getContentPane();
    overall.setLayout(new BoxLayout(overall, BoxLayout.Y_AXIS));
    Container menupane = new JPanel();
    JButton[] menuops = menu(menupane);
    overall.add(menupane);
    Container contpane = new JPanel();
    if(axis == 1){
      contpane.setLayout(new BoxLayout(contpane, BoxLayout.X_AXIS));
    }else{
      contpane.setLayout(new BoxLayout(contpane, BoxLayout.Y_AXIS));
    }
    JScrollPane jcp = new JScrollPane(contpane);
    overall.add(jcp);
    // overall.add(contpane);
    
    
    
    return contpane;
  }
  
  public static void addFriendPage() {
    Container contpane = pagesetup("Add Friend", 0);

    JTextField name_field = textfield("Name: ", 30, contpane, "BorderLayout.PAGE_START");

    Object[] cadence = cadencefield(contpane);

    JList lists = selectmenu("Lists to add to: ", contpane, group.allList(true), 0);
    String[] butts = {"Submit", "Cancel"};
    JButton[] buttonz = buttons(butts, contpane);
    
    window.setVisible(true);
  }

  public static void addListPage() {

    Container contpane = pagesetup("Add Group", 0);

    JTextField name_field = textfield("Name: ", 30, contpane, "BorderLayout.PAGE_START");
    JList lists = selectmenu("Friends to add: ", contpane, friend.allFriendsArray(),0);
    String[] butts = {"Submit", "Cancel"};
    JButton[] buttonz = buttons(butts, contpane);
    

    
    window.setVisible(true);
  }

  public static buttmgr friendPage(group inp){

    Container contpane = pagesetup("Leaderboards", 1);
    // System.out.println("yep");
    ///FOR TESTING PURPOSES
    group test = new group(inp);
    // Random rand = new Random();
    // for(int i = 0; i < 10; i++){
    //   friend a = new friend("friend" + i);
    //   a.count = rand.nextInt(11);
    //   test.add(a);
    // }
    
    buttmgr ret = new buttmgr();
    // System.out.println("LDB1 RUNNIN");
    JButton[] ldb1 = leaderboard(test, contpane, 0, true);
    ret.add(ldb1, test.members);
    // System.out.println(ret.friends.size());
    // System.out.println(ret.butts.size());
    // System.out.println("yep");
    // System.out.println("LDB2 RUNNIN");
    group sorted = test.sortb(1,true);
    // System.out.println("yep");
    // for(int i = 0; i < sorted.members.size(); i++){
    //   System.out.println(sorted.members.get(i).count);
    // }
    JButton[] ldb2 =leaderboard(sorted, contpane, 0, true);
    ret.add(ldb2, test.members);
    // System.out.println(ret.friends.size());
    // System.out.println(ret.butts.size());
    // System.out.println("yep");
    // System.out.println("LDB3 RUNNIN");
    group sortedopp = test.sortb(1,false);
    JButton[] ldb3 = leaderboard(sortedopp, contpane, 0, true);
    ret.add(ldb3, test.members);
    // System.out.println(ret.friends.size());
    // System.out.println(ret.butts.size());
    // return ret;
    window.setVisible(true);
    return ret;
  }

  public static void reminderPage(){
    Container contpane = pagesetup("Schedule Hang", 0);
    ArrayList<JButton> reminders = reminders(contpane, friend.allfriends);
    window.setVisible(true);
  }

  public static void homePage(){
    inputclear();
    window = new JFrame();
    window.setTitle("HOME");
    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    window.setResizable(false);
    window.setLocationRelativeTo(null);
    window.setLayout(new FlowLayout(FlowLayout.CENTER));
    // window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
    Container overall = window.getContentPane();
    overall.setLayout(new BoxLayout(overall, BoxLayout.Y_AXIS));
    Container menupane = new JPanel();
    // String[] menuoptions = {"Friends", "Hangout Log", "Add Friend", "Add Group", "Schedule Hang", "Reminders"};
    // JButton[] menubutts = buttons(menuoptions, menupane);
    JButton[] menuops = menu(menupane);
    // menupane.add(menubutts);
    overall.add(menupane);
    Container contpane = new JPanel();
    contpane.setLayout(new BoxLayout(contpane, BoxLayout.X_AXIS));
    
    ArrayList<JButton> reminders = reminders(contpane, friend.allfriends);

    // addinputs_al(reminders);
    
    ArrayList<hang> testincomp = hang.compl_seplist(hang.allhanglist(), false);
    JPanel incomplete = new JPanel(new FlowLayout(FlowLayout.LEFT));
    incomplete.setLayout(new BoxLayout(incomplete, BoxLayout.Y_AXIS));
    JLabel incompllabel = new JLabel("All Scheduled Incomplete Hangouts");
    JPanel incomptitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    incomptitle.add(incompllabel);
    incomplete.add(incomptitle);
    JButton[] hangbutts2 = hangList(incomplete, testincomp, 1, false);
    contpane.add(incomplete);
    
    
    JScrollPane jcp = new JScrollPane(contpane);
    overall.add(jcp);
    window.setVisible(true);
    // String[] butts = {"LeaderBoards", "Cancel"};
  }

  public static buttmgr schedHangPage() {
    Container contpane = pagesetup("Schedule Hang", 0);
    JLabel livedate = new JLabel("Today's Date: " + LocalDate.now().toString());
    contpane.add(livedate);
    //LIVE DATE NEEDS TO BE IMPLEMENTED
    JSpinner[] date = datePicker(contpane, "Schedule in ");
    
    buttmgr ret= new buttmgr();
    for(int i = 0; i < date.length; i++){
      ret.spinners.add(date[i]);
    }

    // JSpinner scor = score(contpane,1,10,1);
    JPanel body = new JPanel();
    body.setLayout(new BoxLayout(body, BoxLayout.X_AXIS));
    JList fren = selectmenu("Friend: ", body, friend.allFriendsArray(), 0);
    
    ret.lists.add(fren);
    // hang.hangtest();
    // hang.printTypes();
    JList hangop = selectmenu("Hang Type: ", body, hang.typeList(), 1);
    ret.lists.add(hangop);
    contpane.add(body);
    String[] butts = {"Submit", "Cancel"};
    JButton[] buttonz = buttons(butts, contpane);
    ret.butts.add(buttonz[0]);
    ret.butts.add(buttonz[1]);
    

    window.setVisible(true);
    return ret;
  }

  public static void completeHangPage(hang hangy){
    Container contpane = pagesetup("Complete Hang", 0);

    JSpinner scor = score(contpane,1,10,1);
    // JPanel body = new JPanel();
    // body.setLayout(new BoxLayout(body, BoxLayout.X_AXIS));
    // JList fren = selectmenu("Friend: ", body, friend.allFriendsArray(), 1);
    // hang.hangtest();
    // hang.printTypes();
    // JList hangop = selectmenu("Hang Type: ", body, hang.typeList(), 1);
    // contpane.add(body);
    String[] butts = {"Submit", "Cancel"};
    JButton[] buttonz = buttons(butts, contpane);

    window.setVisible(true);
  }

  public static void friendInfoPage(friend fren) {
    Container contpane = pagesetup("FRIEND INFO HERE", 0);
    JPanel body = new JPanel(new FlowLayout(FlowLayout.LEFT));
    body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
    String[] infos = new String[6];
    infos[0] = fren.name.toUpperCase();
    infos[1] = "Set Cadence: " + fren.cadencetime[0] + " Months, " + fren.cadencetime[1] + " Weeks, " + fren.cadencetime[2] + " Days";
    infos[2] = "Last Time Seen: " + fren.dateLastSeen().toString() + " (" + fren.daysSinceLastSeen() + " ago)";
    infos[3] = "Next Appt Due: " + fren.nextDueDate().toString() + " (in " + fren.nextDueDays() + ")";
    infos[4] = "Total Times Seen: " + fren.count;
    infos[5] = "Avg Score: " + fren.avgscore;
    for(int i = 0; i < infos.length; i++){
      JLabel temp = new JLabel(infos[i]);
      JPanel temppanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      temppanel.add(temp);
      body.add(temppanel);
    }
    contpane.add(body);
    JPanel body2 = new JPanel();
    body2.setLayout(new BoxLayout(body2, BoxLayout.X_AXIS));
    JButton[] hangs = hangList(body2, fren.hangs, 0, false);
    JPanel grouplist = new JPanel();
    grouplist.setLayout(new BoxLayout(grouplist, BoxLayout.Y_AXIS));
    grouplist.add(new JLabel("Groups:"));
    for(int j = 0; j < fren.groups.size(); j++){
      JLabel groupname = new JLabel(fren.groups.get(j).name);
      grouplist.add(groupname);
    }
    // body2.add(hangs);
    body2.add(grouplist);
    contpane.add(body2);
    
    
    window.setVisible(true);
    
    
  }

  public static void hangLogPage(ArrayList<hang> hanglist){
    Container contpane = pagesetup("Hangout Log", 1);
    System.out.println(hang.allhanglist().size());
    ArrayList<hang> testcomp = hang.compl_seplist(hanglist, true);
    ArrayList<hang> testincomp = hang.compl_seplist(hanglist, false);
    JPanel completed = new JPanel(new FlowLayout(FlowLayout.LEFT));
    completed.setLayout(new BoxLayout(completed, BoxLayout.Y_AXIS));
    JPanel incomplete = new JPanel(new FlowLayout(FlowLayout.LEFT));
    incomplete.setLayout(new BoxLayout(incomplete, BoxLayout.Y_AXIS));
    
    JLabel compllabel = new JLabel("Past Completed Hangouts");
    JPanel comptitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    comptitle.add(compllabel);
    
    JLabel incompllabel = new JLabel("Scheduled Incomplete Hangouts");
    JPanel incomptitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
    incomptitle.add(incompllabel);
    
    completed.add(comptitle);
    incomplete.add(incomptitle);
    
    JButton[] hangbutts = hangList(completed, testcomp, 1, false);
    JButton[] hangbutts2 = hangList(incomplete, testincomp, 1, false);
    contpane.add(completed);
    contpane.add(incomplete);
    window.setVisible(true);
    
  }

  

  
  
  

  
}
