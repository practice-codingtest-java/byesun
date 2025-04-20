package 개인;

// https://www.acmicpc.net/problem/10799
/**
 * 1. ( 가 들어오면 스택에 추가
 * 2. ) 가 들어오면 스택에서 pop 하지만 스택이 비어 있으면 에러
 * 3. ) 가 들어와서 팝을 진행하고 왼쪽에 ( 가 몇개인지를 파악
 * 4. ( 의 개수에 맞게 count를 증가 시켜 파이프 개수를 저장
 */

import java.io.BufferedReader;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쇠막대기10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		String[] str = br.readLine().split("");
		int count = 0;
		for(int i=0; i<str.length; i++) {
			if(str[i].equals("(")) {
				stack.push("(");
			} else if(str[i].equals(")")) {
				stack.pop();
				if(str[i-1].equals("(")) {
					count += stack.size();
				} else {
					count++;
				}
			}
		}
//		for (String p : str) {
//			if (p.equals("(")) {
//				stack.push("(");
//			} else if (p.equals(")")) {
//				stack.pop();
//				if (stack.peek().equals("(")) {
//					count += stack.size();
//				} else {
//					count++;
//				}
//			}
//		}
		System.out.println(count);
	}
}