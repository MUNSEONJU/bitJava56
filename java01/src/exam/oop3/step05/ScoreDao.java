// Entity역할
//	- 데이터의 저장과 조회, 변경, 삭제 관리.
//	- 데이터의 지속성(Persistence)을 관리
//	- Data Access Object(DAO)

package exam.oop3.step05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreDao {
	ArrayList<Score> scores = new ArrayList<>();
	int cursor;

	public ScoreDao() {

	}

	public void insert(Score score) {
			scores.add(score);
			cursor = scores.size();
	}

	public Score nextScore() {
		if ( cursor >= scores.size() - 1 ) {
			return null;
		}
		return scores.get(++cursor);
	}

	public Score previousScore() {
		if (cursor <= 0) {
			return null;
		}
		return scores.get(--cursor);
	}

	public Object[] toArray() {
		return scores.toArray();
	}

	public void save() throws IOException{		
		File data = new File("f:\\test.csv"); // 상대경로(프로젝트)
		//System.out.println(data.getAbsolutePath());
			FileWriter out = new FileWriter(data);
		for(Score score : scores){
			
		}
  }
}
