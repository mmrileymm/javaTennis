package tennis;

public class Tie extends Game {

	boolean tieBreaker;

	public Tie(int gameSize, Player p) {
		super(gameSize, p);
		// TODO Auto-generated constructor stub
	}

	// 6게임 == 6게임일 때 타이 브레이크 처리 함수 호출
	public void isTieBreak(int [][] setScore) {
		if((setScore[0][setidx] == 6) && (setScore[1][setidx] ==6)) tieBreaker = true;
		else tieBreaker = false;
	}
	
	
	
	@Override
	public void runGameSet() {
		XXX: do {
			runGamePoint();
			isTieBreak(setScore);
			if(tieBreaker) break;
			
			/*
			if((setScore[0][setidx] == 6) && (setScore[1][setidx] ==6)) {
				tieBreaker = true;
				break;
			}
			*/
			if(Math.abs(setScore[0][setidx] - setScore[1][setidx]) >= 2 && (setScore[0][setidx]==6||setScore[1][setidx]==6)) break;
			else if(Math.abs(setScore[0][setidx] - setScore[1][setidx]) == 1 && (setScore[0][setidx]==6||setScore[1][setidx]==6)) break;
			if((setScore[0][setidx] == 5) && (setScore[1][setidx] ==5)) {
				while(Math.abs(setScore[0][setidx] - setScore[1][setidx]) != 2 ) {
					runGamePoint();
					isTieBreak(setScore);
					if(tieBreaker) break XXX;
				}
			}
		} while (!(setScore[0][setidx]==7 || setScore[1][setidx]==7));
		

		
		if(!tieBreaker) {
			while (Math.abs(setScore[0][setidx] - setScore[1][setidx]) < 2) {
				resetScore(score);
				runGamePoint();
			}
		} else {

			do {
				if(Math.abs(setScore[0][setidx] - setScore[1][setidx]) >= 1) {
					tieBreaker = false;
					break;
				}
				resetScore(score);
				runGamePoint();
			} while (tieBreaker);
		}

		if(setScore[0][setidx] > setScore[1][setidx]) total[0]++;
		else total[1]++;
		setidx++;
		printTotal(score, setScore,total);
		createFileEnd();
	}

	private static String changeScore(int score) {
		return ""+score;
	} // changeScore 오버로딩


	@Override
	public void runGamePoint() {
		int gamelimit  = tieBreaker?7:4;
		printTotal(score, setScore,total);
		while(score[0]< gamelimit-1 && score[1] <gamelimit-1) { // 한 쪽이 3이 되기까지 진행
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
				if(score[0] == gamelimit || score[1] == gamelimit) break; // 한 쪽이 4점이 되면 끝
			}
			printTotal(score, setScore,total);
		} while (true);

		int winTeam = score[0]>score[1]? 0:1;
		setScore[winTeam][setidx] ++;
		resetScore(score);
	}

	@Override
	public void printTotal(int[] score, int[][] setScore, int[] total) {
		createFile(score, p);
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
				if(tieBreaker) System.out.printf("%s\t", changeScore(score[i])); // 점수 출력
				else System.out.printf("%s\t", changeScore(score[i], flage, win[i])); // 점수 출력
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
	} // 타이브레이커를 고려한 출력 함수


} // Tie class