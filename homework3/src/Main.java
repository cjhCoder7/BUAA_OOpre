import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final ArrayList<ArrayList<String>> inputInfo =  new ArrayList<>();
        CommandUtil.initCommandUtil();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
        }
        for (ArrayList<String> strings : inputInfo) {
            int command = Integer.parseInt(strings.get(0));
            CommandUtil.getCommandMap()
                    .get(command)
                    .accept(strings);
        }
    }
}
