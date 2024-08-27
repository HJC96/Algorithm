import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Garage> garageList = new ArrayList<>();
        int maxH = 0; // 가장 높은 기둥
        int maxHL = 0;
        for(int i=0;i<N;i++){
            String[] line = br.readLine().split(" ");
            garageList.add(new Garage(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
            if(maxH < Integer.parseInt(line[1])){
                maxH = Math.max(maxH, Integer.parseInt(line[1]));
            }

        }

        Collections.sort(garageList, new Comparator<Garage>(){
            @Override
            public int compare(Garage o1, Garage o2){
                return o1.getL() - o2.getL();
            }
        });

        int answer = 0;

        int a1 = 0, b1 = 0;
        // 현재 기둥 높이
        int curH = 0;

        // 가장 높은 기둥이 될때까지, 현재 기둥보다 값이 높을때만 업데이트 해준다
        for(int i=0;i<N;i++){
            if(garageList.get(i).getH() == maxH) {
                a1 = garageList.get(i).getL();
                break;
            }
            if(curH < garageList.get(i).getH()){
                curH = garageList.get(i).getH();
            }
            answer += (garageList.get(i+1).getL()-garageList.get(i).getL())*curH;

        }

        curH=0;
        // 가장 높은 기둥이 될때까지, 현재 기둥보다 값이 높을때만 업데이트 해준다
        for(int i= garageList.size()-1;i>=maxHL;i--){
            if(garageList.get(i).getH() == maxH) {
                b1 = garageList.get(i).getL();
                break;
            }
            if(curH < garageList.get(i).getH()){
                curH = garageList.get(i).getH();
            }
            answer += (garageList.get(i).getL()-garageList.get(i-1).getL())*curH;
        }

        answer += (b1-a1+1)*maxH;

        System.out.println(answer);





    }
}

class Garage{
    private int L;
    private int H;

    public Garage(int L, int H){
        this.L = L;
        this.H = H;
    }

    public int getL() {
        return L;
    }

    public int getH() {
        return H;
    }

}



