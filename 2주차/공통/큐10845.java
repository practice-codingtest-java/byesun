import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 큐10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]) {
                case "push":
                    queue.offer(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if(queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.poll()+"\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.peekFirst()+"\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.peekLast()+"\n");
                    }
            }
        }
        System.out.println(sb);
    }
}
