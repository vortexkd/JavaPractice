
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Multiples();
		int teamAScore = 0;
		int teamBScore = 0;
		String[][] teamList = {
				{"山田","Aチーム"},
				{"田中","Aチーム"},
				{"鈴木","Bチーム"},
				{"中村","Bチーム"},
				{"伊藤","Bチーム"}
		};
		
		String[][] pointList = {
				{"山田","1"},
				{"山田","3"},
				{"山田","1"},
				{"伊藤","4"},
				{"山田","2"},
				{"中村","1"},
				{"中村","1"},
				{"山田","3"},
				{"鈴木","2"},
				{"山田","4"},
				{"伊藤","5"},
				{"山田","2"},
				{"鈴木","3"},
				{"山田","1"},
				{"田中","2"}
			};
		//if teamList[i][1]==pointList[j][1] 
		for(String[] point : pointList) {
			for(String[] teams : teamList) {
				if(point[0]==teams[0]) {
					//matched player
					//そんなにきれいな方法ではないんですが、チームげ二つ以上の場合にはもう一つの配列を使ってやって法がいいと思ういます。
					//もう一つの方法はチームクラスを作って、メンバーリストの配列をそのクラスに入れたらもっときれいにできます。
					if(teams[1].contains("A")) {
						teamAScore += Integer.parseInt(point[1]);
					}
					else {
						teamBScore += Integer.parseInt(point[1]);
					}
				}
			}
		}
		System.out.println("Aチームの合計得点は、"+teamAScore+"です");
		System.out.println("Bチームの合計得点は、"+teamBScore+"です");
	}

}
