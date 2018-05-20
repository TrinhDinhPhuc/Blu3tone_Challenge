import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Java {

    private static List<List<Integer>> adj;
    private static boolean[] visited;
    private static int count;

    private static int str2int(String s) {
        return Integer.parseInt(s.trim());
    }

    public static void main(String[] args) {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File("C:\\Users\\USER\\Documents\\Py_Project\\Blu3tone\\Java\\src\\sample_input.txt");
            FileReader fr = new FileReader(f);

            //Bước 2: Đọc dữ liệu
            BufferedReader br = new BufferedReader(fr);
            int q = str2int(br.readLine());//doc dong 1
            String line[];
            line = br.readLine().split(" ");//doc dong 2
            boolean notfirst= false;
            for (int a0 = 0; a0 < q; a0++) {
               if(notfirst){
                line = br.readLine().split(" ");
               }
               notfirst=true;
                int n = str2int(line[0]);
 
                adj = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    adj.add(new ArrayList<>());
                }
                visited = new boolean[n];
                int m = str2int(line[1]);
                int x = str2int(line[2]);
                int y = str2int(line[3]);
                for (int a1 = 0; a1 < m; a1++) {
                   line = br.readLine().split(" ");
                    int city_1 = str2int(line[0]);
                    int city_2 = str2int(line[1]);
                    adj.get(city_1 - 1).add(city_2 - 1);
                    adj.get(city_2 - 1).add(city_1 - 1);
                }
              
                System.out.println("kết qủa là ="+roadsAndLibraries(x, y)); //sao ko ra kết quả nhỉ?
                  
            }

            //Bước 3: Đóng luồng
            fr.close();
            br.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static long roadsAndLibraries(int x, int y) {
        long cost = 0;

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                count = 0;
                dfs(i);
                if (x > y) {
                    cost += x + y * (count - 1);
                } else {
                    cost += x * count;
                }
            }
        }

        return cost;
    }

    private static void dfs(int i) {
        visited[i] = true;
        count++;

        List<Integer> list = adj.get(i);
        for (int j = 0; j < list.size(); j++) {
            if (!visited[list.get(j)]) {
                dfs(list.get(j));
            }
        }
    }
}
