import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 덱10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]) {
                case "push_back":
                    deque.addLast(Integer.parseInt(input[1]));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    if(deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        Integer i1 = deque.removeFirst();
                        sb.append(i1+"\n");
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        Integer i1 = deque.removeLast();
                        sb.append(i1+"\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()+"\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekFirst()+"\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(deque.peekLast()+"\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
