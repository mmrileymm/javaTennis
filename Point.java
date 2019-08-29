package tennis;

import java.util.Arrays;

import java.util.Random;



/**
 * @author SIST174
 * @data 2019. 2. 8. - 오후 12:15:28
 * @subject 듀스 + AD와 공백 출력 + 전광판 출력
 */
public class Point {
	int [] score = new int [2];
	int [][] setScore;
	int [] total = new int [2];
	int gameSize;
	static boolean [] win = new boolean [2];
	Random rnd = new Random(System.currentTimeMillis());
	static boolean flage = false; // 전이 듀스인가 아닌
	
	Point() {} // 디폴트생성자
	
	Point(int gameSize) {
		setScore = new int [2][gameSize];
		this.gameSize = gameSize;
	} // 생성자
	
	protected void printTotal(int [] score,int [][] setScore, int [] total) {
		int time = 100;
		try {
			Thread.sleep(time);
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("Team\t");
			System.out.printf("Point\t");
			for (int i = 0; i < setScore[0].length; i++) {
				System.out.printf("%dSet\t", i+1);
			}
			System.out.println("Total"); // 여기까지 갹 항목 제목 출력
			System.out.println("--------------------------------------------------------------------------");
			for (int i = 0; i < 2; i++) {
				System.out.printf("%c\t", i==0?'A':'B');
				System.out.printf("%s\t", changeScore(score[i], flage, win[i])); // 점수 출력
				for (int j = 0; j < setScore[i].length; j++) { // 게임 출력
					System.out.printf("%d\t", setScore[i][j]);
				}
				System.out.printf("%d", total[i]);
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------");
			System.out.println();
			System.out.println();
			System.out.println(); // 보기 편하게 개행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // 전광판 출력하는 함수
	
	public void runGamePoint() { // 1게임 진행
		while(score[0]<3 && score[1] <3 ) { // 한 쪽이 3이 되기까지 진행
			randomWin(score);
			printTotal(score, setScore,total);
		}

		do {
			if(score[0] == score[1]) { // 듀스
				while(true) { // 둘의 차이가 2점이 되면 끝
					flage = !flage;
					randomWin(score);
					if(Math.abs(score[0] - score[1]) == 2) break;
					printTotal(score, setScore,total);
				}
				break;
			} else { // 듀스가 아닐 경우
				randomWin(score);
				if(score[0] == 4 || score[1] == 4) break; // 한 쪽이 4점이 되면 끝
			}
			printTotal(score, setScore,total);
		} while (true);
		
		
	} // 게임 진행 클래스
	
	public void resetScore(int [] score) {
		Arrays.fill(score, 0);
		flage = false;
	} // 점수 리셋 함수
	
	public void randomWin(int [] score) { 
		int idx = 0;
		idx = rnd.nextInt(2);
		score[idx]++;
		Arrays.fill(win, false);
		win[idx] = true;
	} // 테스트를 위한 랜덤값 넣기 함수 -> 실제 프로그램에서는 값을 받는 함수로 수정
	
	
	
	protected static String changeScore(int score, boolean flage, boolean win) {
		if(flage) {
			if(win) return "AD";
			else return "　";
		} 
		
		switch (score) {
		case 0:
			return "0";
		case 1:
			return "15";
		case 2:
			return "30";
		case 3:
			return "40";
		default:
			return "40";
			
		}
	} // changeScore
	
	
} // setPoint class
