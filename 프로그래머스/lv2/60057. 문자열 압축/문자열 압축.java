import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int min = length/2; int answer = length;
        Stack<String> stk = new Stack<String>();
        while(min>0){
            for(int i=0;i<length/min;i++){
                String tmp ;
                if(min*i + min >length)
                    tmp = s.substring(min*i,length);
                else
                    tmp = s.substring(min*i,min*i + min);
                stk.add(tmp);
            }
            String top = stk.pop();
            int tmp_answer = length;
            boolean flag = false; int cnt=0;
            while(!stk.isEmpty()){
                String tmp_top = stk.pop();
                if(top.equals(tmp_top)) {
                    // tmp_answer -= (min-1); // min-1 검토필요
                    flag = true;
                    cnt++;
                }else{
                    flag = false;
                    // if(cnt > 10)
                    if(cnt>=999)
                        tmp_answer -= (min*cnt-4);
                    else if(cnt>=99)
                        tmp_answer -= (min*cnt-3);
                    else if(cnt>=9)
                        tmp_answer -= (min*cnt-2);
                    else if(cnt>0)
                        tmp_answer -= (min*cnt-1);
                    cnt =0;
                }
                top = tmp_top;
            }
            if(flag){
                if(cnt>=999)
                        tmp_answer -= (min*cnt-4);
                else if(cnt>=99)
                        tmp_answer -= (min*cnt-3);
                else if(cnt>=9)
                        tmp_answer -= (min*cnt-2);
                else if(cnt >0)
                    tmp_answer -= (min*cnt-1);
            }
            
            answer = Math.min(answer, tmp_answer);
            
            min--;
        }

        return answer;
    }
}

// 2 a 2 b a 3 c

/*
    문자열을 어떻게 자르는게 좋을까?
    방법1)
        앞에서부터 카운트해서 자르는게 좋을것 같은데..
        그럼 모든 경우의 수를 구한다?
        1로 잘랐을때 결과, 2로 잘랐을때 결과 ...3으로 잘랐을때 결과...

        문자열은 제일 앞부터 정해진 길이만큼...

        1로 잘랐을때 어떻게 결과가 나오지?
        1. 전체 문자열을 가져온다.
        2. 다른 원소가 나올때까지 idx++카운트 한다.
            2.1 다른 원소가 나오면 result에 값을 2 증가 시킨다.
            2.2 같은 원소면 계속 카운트 증가
            2.3 만약 카운트가 0이다... 그러면 2증가가 아닌 1 증가

        2로 자르면 어떤 결과?
        1. 전체 문자열을 가져온다.
        2.




        * 근데 일단 이거 전제가 압축하는 단위가 크면 클수록 짧은 길이가 나온다 -> 이거에 대한 고려 필요
        만약 이 명제가 참이라면,
        * 그리고 1부터 자르는게 아니라 큰수부터 자르는게 더 효율적일수도?
        -> 길이의 절반부터 시작


        압축 알고리즘
        첫번째 원소, 두번째 원소 비교
        두번째 원소, 세번째 원소 비교
        ...
        n번째 원소 비교
        이때 다르면 idx를 옮김.

        abababab
        1. ab -> 4ab
        2. abab -> 2ab


        (dummy)
        잠시만.. 이거 자료구조 쓰면 될것 같은데..
        예제 3
        1. 맥스값 10을 가진다
        2. 2개로 묶어서 map에 넣는다.

        약수네.. 왜냐면 첫 문자를 반드시 포함해야하니까
        1. 각 문자열마다 약수-2의 후보가 있음.
        24 라는 길의의 문자열이 있으면
        1 24
        2 12
        3 8
        4 6

        해결 방법
        1. 문자열의 길이 계산
        2. 해당 약수를 첫번째 원소와 끝 원소를 제외하고 리스트 만듬
        3. 리스트에 끝 원소부터 내려가면서, 압축 알고리즘을 하고 길이를 구함.


        Map을 쓰면 안되는 이유
        - abdcab 이렇게 있으면 두개씩 잘랐을때 ab



*/