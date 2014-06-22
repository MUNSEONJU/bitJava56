package exam.oop3.step03;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * 성적 등록 폼 만들기
 * - Panel 사용
 * 	 > 여러개의 UI 컴포넌트를 묶을 때 사용하는 윈도우
 */
public class MinsuScoreFrame extends Frame
{
	public MinsuScoreFrame()
  {
		this.setTitle("비트 성적관리 시스템");
		this.setSize(240, 200);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// 패널 배열 생성(size : 4)
		Panel[] parr = new Panel[4];
		// TextField 4개 생성'
		final TextField[] tfarr = createTextField();
		// Label 4개 생성
		Label[] lbarr = createLabel();
		// frame에 Panel add
		for (int i = 0; i < parr.length; i++)
    {
	    this.add(parr[i] = createPanel(lbarr[i], tfarr[i]));
    }
		Button btn = new Button("추가");
		btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e)
      {
      	if(!(tfarr[0].getText().equals(""))) {
      		System.out.println(tfarr[0].getText() + ", " +
						      				tfarr[1].getText()	+ ", " +
						      				tfarr[2].getText()	+ ", " +
						      				tfarr[3].getText());
      	}
      }
		});
		
		this.add(btn);
		this.setVisible(true); 
  }
	
	private Label[] createLabel()
  {
		Label[] lbarr = new Label[4];
		lbarr[0] = new Label("이름");
		lbarr[1] = new Label("국어");
		lbarr[2] = new Label("영어");
		lbarr[3] = new Label("수학");
	  return lbarr;
  }
	private TextField[] createTextField()
	{
		TextField[] tfarr = new TextField[4];
		tfarr[0] = new TextField(20);
		tfarr[1] = new TextField(5);
		tfarr[2] = new TextField(5);
		tfarr[3] = new TextField(5);
		
		return tfarr;
	}
	
	// Label과 TextField를 인자로 받고 임시Panel에 add,
	// 임시 Panel 주소 리턴
	private Panel createPanel(Label lb, TextField tf) 
	{
		Panel p = new Panel();
		p.add(lb);
		p.add(tf);
		return p;
	}
}