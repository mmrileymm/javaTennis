package tennis;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Game extends Point {
	int setidx = 0;
	Player p;
	Calendar now = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String day = sdf.format(now.getTime());
	String player;
	String fileName;

	
	public Game(int gameSize, Player p) {
		super(gameSize);
		this.p = p;
	}
	
	public void runGameSet() {
		do {
			runGamePoint();
		} while (!(setScore[0][setidx]==6 || setScore[1][setidx]==6));
		
		while(true) {
			if(Math.abs(setScore[0][setidx]-setScore[1][setidx]) >= 2) break;
			runGamePoint();
		}
		if(setScore[0][setidx] > setScore[1][setidx]) total[0]++;
		else total[1]++;
		setidx++;
		printTotal(score, setScore,total);
		createFileEnd();
		
	} // 1세트 진행
	
	
	
	@Override
	public void runGamePoint() {
		printTotal(score, setScore,total);
		super.runGamePoint();
		int winTeam = score[0]>score[1]? 0:1;
		setScore[winTeam][setidx] ++;
		resetScore(score);
	}

	public void runGame() {
		for (int i = 0; i < this.gameSize; i++) {
			this.runGameSet();
			if(total[0]> this.gameSize/2 || total[1]> this.gameSize/2)
				break;
		}
	}
	
	public int howWin( ) {
		return total[0]>total[1]?0:1;
	}
	
	
	@Override
	protected void printTotal(int[] score, int[][] setScore, int[] total) {
		createFile(score, p);
		super.printTotal(score, setScore, total);
	}

	protected String[] getResultString() {
		String [] result = new String[2];
		char winTeam = howWin()==0?'A':'B';
		result[0] = String.format("A팀:B팀 결과 - %d:%d",total[0], total[1]);
		result[1] = String.format("%c팀이 이겼습니다.", winTeam); // 팀원 이름도 나오게 출력수정
		return result;
	}
	
	public void printResult() {
		String [] result = getResultString();
		for (int i = 0; i < 2; i++) {
			System.out.println(result[i]);
		}
	}
	
	protected void createFile(int[] score,  Player p) {
		String line = "--------------------------------------------------------------------------\r\n";
		if(p.gameOption) {
			player = String.format("%s-%s", p.singlePlayer1, p.singlePlayer2);
		} else {
			player = String.format("%s,%s-%s,%s", p.doublesPlayerA1, p.doublesPlayerA2, p.doublesPlayerB1, p.doublesPlayerB2);
		}
		fileName = String.format(".\\%s %s 테니스경기.txt", day, player);
		try (FileWriter fw = new FileWriter(fileName, true)) {
			try {
				if(total[0]> this.gameSize/2 || total[1]> this.gameSize/2) fw.write(String.format("테니스 경기 결과\r\n"));	
				else fw.write(String.format("%dSet %dGame\r\n", setidx+1,  setScore[0][setidx]+setScore[1][setidx]+1));		
			} catch (ArrayIndexOutOfBoundsException e) { 
				fw.write(String.format("테니스 경기 결과\r\n"));	
			}
			fw.write(line);
			fw.write("Team\tPoint\t");
			for (int i = 0; i < setScore[0].length; i++) {
				fw.write(String.format("%dSet\t", i+1));
			}
			fw.write("Total");
			fw.write("\r\n");
			fw.write(line);
			for (int i = 0; i < 2; i++) {
				fw.write(String.format("%c\t%d\t", i==0?'A':'B', score[i]));
				for (int j = 0; j < setScore[0].length; j++) {
					fw.write(String.format("%d\t", setScore[i][j]));
				}
				fw.write(String.format("%d\r\n", total[i]));
			}
			fw.write(line);
			fw.write("\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // createFile
	
	protected void createFileEnd() {
		try (FileWriter fw = new FileWriter(fileName, true)) {
			String [] result = getResultString();
			fw.write("\r\n");
			fw.write(result[0]);
			fw.write("\r\n");
			fw.write(result[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} // Game
