package exam.oop3.step03;

// << , >> 버튼 추가 및 이벤트 처리
// 	- 하나의 inner class가 모든 버튼의 이벤트를 처리

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

public class ScoreFrame04  extends Frame {
	private TextField tfName = new TextField(20);
	private TextField tfKor = new TextField(5);
	private TextField tfEng = new TextField(5);
	private TextField tfMath = new TextField(5);
	
	private Button btnAdd;
	private Button btnPrevious;
	private Button btnNext;
	
	//member inner class
	class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
    	// 이벤트 별 수행명령
	    if(e.getSource() == btnAdd){
	    	Score score = new Score();
				
				score.setName(tfName.getText());
				score.setKor( Integer.parseInt(tfKor.getText()) );
				score.setEng( Integer.parseInt(tfEng.getText()) );
				score.setMath( Integer.parseInt(tfMath.getText()) );
				
				scoreDao.insert(score); // Score Data Access Object 에게 저장
				
				//Refactor -> extract Method (메소드로 만들어줌)
				clearForm();		
	    } else if(e.getSource() == btnNext){
	    	System.out.println("Pressed Right Button");
				Score currentScore = scoreDao.nextScore();
				if(currentScore == null){
					System.out.println("Last Index");
				}else{
					setForm(currentScore);
				}
	    } else if(e.getSource() == btnPrevious){
	    	System.out.println("Pressed Left Button");
				Score currentScore = scoreDao.previousScore();
				if(currentScore == null){
					System.out.println("First Index");
				}else{
					setForm(currentScore);
				}
	    }
    }
	}
	
	private ScoreDao scoreDao;
	
	public ScoreFrame04() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		
		this.addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
			  System.exit(0);
		  }
		});
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add( createRowPanel("이름", tfName) );
		this.add( createRowPanel("국어", tfKor) );
		this.add( createRowPanel("영어", tfEng) );
		this.add( createRowPanel("수학", tfMath) );
		
		Panel toolbar = new Panel(new FlowLayout(FlowLayout.LEFT));
		
		MyActionListener btnListener = new MyActionListener();
		
		btnAdd = createToolbarButton("add");
		btnAdd.addActionListener(btnListener);
		toolbar.add(btnAdd);
		
		btnPrevious = createToolbarButton("<<");
		btnPrevious.addActionListener(btnListener);
		toolbar.add(btnPrevious);
		
		btnNext = createToolbarButton(">>");
		btnNext.addActionListener(btnListener);
		toolbar.add(btnNext);
		
		this.add(toolbar);
	}
	
	private Button createToolbarButton(String btnName){
		Button btn = new Button(btnName);
		btn.setPreferredSize(new Dimension(80, 30));
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
		tfMath.setText("");
		tfEng.setText("");
	}

	private void setForm(Score score){
		tfName.setText(score.getName());
		tfKor.setText(Integer.toString( score.getKor()) );
		tfEng.setText(Integer.toString( score.getEng()) );
		tfMath.setText(Integer.toString( score.getMath()) );
	}
	
}



















