// Subject: Study of Algorithm with SSAFY
// ProblemNo: B4949
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static boolean solve(){
        ArrayDeque<Character> stack = new ArrayDeque();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c  == '[') stack.push(c);
            else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }
            else if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String s;
    
    public static void main(String[] args) throws Exception{
        while(true){
            s = br.readLine();
            if(s.equals(".")) break;
            sb.append(solve()? "yes\n":"no\n");
        }
        System.out.print(sb);
    }
}