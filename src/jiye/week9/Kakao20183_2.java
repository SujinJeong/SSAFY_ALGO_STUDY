import java.util.*;
class Solution3_2 {//압축
    
    public int[] solution(String msg) {
        ArrayList<Integer> ans = new ArrayList<>();
        int N = msg.length();
        
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=1;i<27;i++)
        {
            char c = (char)(64+i);
            hm.put(Character.toString(c),i);
        }
        int index=27;
        
        int i=0;
        while(i<N)
        {
            String str = Character.toString(msg.charAt(i));//첫자리
            int j=i+1;
            while(hm.containsKey(str)==true)
            {
                j++;
                if(j>N)
                    break;
                str=msg.substring(i,j);
            }
            String str2 = msg.substring(i,j-1);
            ans.add(hm.get(str2));//존재하는 마지막 값
            
            //존재하지 않으면
            hm.put(str,index);//존재하지 않는 값
            // if(i<25)
            // System.out.println(str+" "+i+" - "+(j-1)+" "+index);
            index++;
            i=j-1;
        }
        
        // System.out.println(ans);
        int[] answer = new int[ans.size()];
        
        for(int ii=0;ii<ans.size();ii++)
            answer[ii] = ans.get(ii);
        return answer;
    }
}