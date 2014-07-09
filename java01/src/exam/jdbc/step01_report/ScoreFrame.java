package exam.jdbc.step01_report;

/* [<], [>] 버튼 추가 및 이벤트 처리
 * - Frame 클래스가 ActionListener 역할을 겸한다.
 * - OOP입장에서는 바람직하지 않다.
 *   => Low coupling, High cohesion(하나의 클래스는 하나의 역할을 수행한다)
 *   
 * ActionListener 규칙
 * - 버튼을 클릭 이벤트를 처리하는 규칙
 * - TextField의 엔터 키 이벤트를 처리하는 규칙 
 * 
 * 버튼에 Action 이름을 설정한 후 이벤트 처리 시에 사용한다.
 */

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ScoreFrame  extends Frame implements ActionListener {
  private TextField tfName = new TextField(20);
  private TextField tfKor = new TextField(5);
  private TextField tfEng = new TextField(5);
  private TextField tfMath = new TextField(5);
  public static int currSno;  
  public static int count;
  public static int[] sno; 
  //public static int maxIndexSno;
  //public static int currIndexSno;
  
  private Connection con;
  private Statement stmt;
  static ResultSet rs;
  
  public void actionPerformed(ActionEvent e) {
    // 추가 버튼, < 버튼, > 버튼
    if (e.getActionCommand().equals("scoreAdd")) {
      Score score = new Score();
      score.setName(tfName.getText());
      score.setKor(Integer.parseInt(tfKor.getText()));
      score.setEng(Integer.parseInt(tfEng.getText()));
      score.setMath(Integer.parseInt(tfMath.getText()));

      scoreDao.insert(score);

      clearForm();
    } else if (e.getActionCommand().equals("scorePrevious")) {
      Score currScore = scoreDao.previousScore();
      if (currScore == null) {
        System.out.println("가져올 데이터가 없습니다!");
      } else {
        setForm(currScore);
      }
    } else if (e.getActionCommand().equals("scoreNext")) {
      Score currScore = scoreDao.nextScore();
      if (currScore == null) {
        System.out.println("가져올 데이터가 없습니다!");
      } else {
        setForm(currScore);
      }
    }

  }

  private ScoreDao scoreDao;

  public ScoreFrame() {
  	try{
	  	Class.forName("com.mysql.jdbc.Driver");
	  	con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bitdb","bit","1111");
			stmt = con.createStatement();
			
			ResultSet rsCount = stmt.executeQuery(
				"select count(sno) as countSno from scores"
			);
			rsCount.next();
			count = rsCount.getInt("countSno");
			rsCount.close();
			
			rs = stmt.executeQuery("select sno from scores");
			rs.next();
			
			currSno = count+1;
			sno = new int[count+1];
			
			for(int i=1;i<count+1;i++){
				sno[i] = rs.getInt("sno");
				rs.next();

				System.out.println(i + "번째행 sno : " + sno[i]);
			}
			
			
				//sno 확인하기
			/*
			for(int i=0;i<sno.length;i++){
				System.out.println(sno[i]);
			}
			*/
			
			
			/*
			ResultSet indexRow = stmt.executeQuery(
				//"select max(sno) as max_sno from scores");// 최대값을 뽑아서 중간에 값빠지면 안맞음
				//"select max(sno) as maxSno, count(sno) as countSno from scores");
				"select count(sno) as countSno from scores"
			);
			*/
			//this.maxSno = rowNo.getInt("countSno") + 1; 
			//this.currIndexSno = this.maxIndexSno;
			//this. = rs.getInt("maxSno");
			//this.currSno = this.maxSno;

			//indexRow.close();

			rs.close();
			stmt.close();
			con.close();
  	} catch(Exception e){
  		e.printStackTrace();
  	}
  	
    this.setTitle("비트 성적관리 시스템");
    this.setSize(400, 300);
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        
        System.exit(0); // 더이상 save필요없음
      }
    });

    this.setLayout(new FlowLayout(FlowLayout.LEFT));

    this.add( createRowPanel("이름", tfName) );
    this.add( createRowPanel("국어", tfKor) );
    this.add( createRowPanel("영어", tfEng) );
    this.add( createRowPanel("수학", tfMath) );

    Panel toolbar = new Panel(new FlowLayout(FlowLayout.LEFT));

    Button btn = createToolbarButton("추가");
    btn.setActionCommand("scoreAdd"); // 버튼에 액션 이름 설정
    btn.addActionListener(this);
    toolbar.add(btn);

    btn = createToolbarButton("<");
    btn.setActionCommand("scorePrevious"); // 버튼에 액션 이름 설정
    btn.addActionListener(this);
    toolbar.add(btn);

    btn = createToolbarButton(">");
    btn.setActionCommand("scoreNext"); // 버튼에 액션 이름 설정
    btn.addActionListener(this);
    toolbar.add(btn);

    this.add(toolbar);
  }

  private Button createToolbarButton(String title) {
    Button btn = new Button(title);
    btn.setPreferredSize(new Dimension(80,  30));
    return btn;
  }

  private Panel createRowPanel(String title, Component comp) {
    Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT)); 
    panel.setPreferredSize(new Dimension(300, 25));

    Label label = new Label(title);
    label.setPreferredSize(new Dimension(50, 25));
    panel.add(label);

    panel.add(comp);

    return panel;
  }

  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
  }

  private void clearForm() {
    tfName.setText("");
    tfKor.setText("");
    tfEng.setText("");
    tfMath.setText("");
  }

  private void setForm(Score score) {
    tfName.setText(score.getName());
    tfKor.setText(Integer.toString(score.getKor()));
    tfEng.setText(Integer.toString(score.getEng()));
    tfMath.setText(Integer.toString(score.getMath()));
  }

  
}



















