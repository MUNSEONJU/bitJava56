package exam.oop3.step03;

/* 성적 등록 폼 만들기
 * - Panel 사용 
 *   > 여러 개의 UI 컴포넌트를 묶을 때 사용하는 윈도우 
 */

import java.awt.Button;
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

public class MyScoreFrame  extends Frame {
	/*
	TextField[] tf = new TextField[]
	{ new TextField(20),new TextField(5),new TextField(5),new TextField(5) };
	*/
	int tfLength = 4;
	TextField[] tf = new TextField[tfLength];
	
	public MyScoreFrame() {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(400, 300);
		
		this.addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
			  System.exit(0);
		  }
		});
		
		for(int i=0;i<tfLength;i++){
			if(i==0)
				tf[i] = new TextField(20);
			else tf[i] = new TextField(5);
		}
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add( createTextInputPanel("이름", 0) );
		this.add( createTextInputPanel("국어", 1) );
		this.add( createTextInputPanel("영어", 2) );
		this.add( createTextInputPanel("수학", 3) );
		
		
		Button btn = new Button("score");
		btn.setPreferredSize(new Dimension(80, 40));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(tf[0].getText() + tf[1].getText() 
						+ tf[2].getText() + tf[3].getText());
			}
		});
		
		this.add(btn);
	}
	
	
	private Panel createTextInputPanel(String title, int index) {
		/*
		// Panel의 기본 레이아웃 매니저 => FlowLayout(FlowLayout.CENTER)
		Panel panel = new Panel(); 
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		*/
		
		// Panel의 생성자중에는 Layout Manager를 받는 생성자도 있다
		Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		
		panel.setPreferredSize(new Dimension(300, 25));
		
		Label label = new Label(title);
		label.setPreferredSize(new Dimension(50, 25));
		panel.add(label);
		panel.add(tf[index]);
		
		return panel;
	}

}



















