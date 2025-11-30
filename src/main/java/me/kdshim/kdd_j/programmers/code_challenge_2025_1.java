package me.kdshim.kdd_j.programmers;

//ㄹㅇ 2시간은 쓴듯..
public class code_challenge_2025_1 {

    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = n/w + 1;

        int[][] boxList = new int[h][w];

        for(int i=(h-1); i>=0; i--){
            int index = 0;
            if(((h-1)-i)%2 == 0){
                for(int j=0; j<w; j++){
                    index = w*i + (j+1);
                    boxList[i][j] = index > n ? 0 : index;
                }
            }

            if(((h-1)-i)%2 == 1){
                for(int j=(w-1); j>=0; j--){
                    index = w*i + (w-j);
                    boxList[i][j] = index > n ? 0 : index;
                }
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(boxList[i][j] == num){
                    for(int k=i; k<h; k++){
                        if(boxList[k][j] !=0) {
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) throws Exception{
        code_challenge_2025_1 sol = new code_challenge_2025_1();
        int n = 13;
        int w = 3;
        int num = 6;
        int ret = sol.solution(n, w, num);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}