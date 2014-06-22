package exam.oop3.step03;

import java.awt.Frame;
import exam.oop3.step03.ScoreFrame;

public class ScoreApp01 extends Frame{

	public static void main(String[] args) {
		ScoreFrame f = new ScoreFrame();
		ScoreDao scoreDao = new ScoreDao();
		f.setScoreDao( scoreDao );
		f.setVisible(true);
	}

}

