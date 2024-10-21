import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main() {
        // 模拟输入数据
        String inputData = "9\n" + // 第一行：读取行数
                "1 988244353 adv1\n" +
                "2 988244353 1 bottle 50 AtkBottle 1000\n" +
                "3 988244353 2 equipment 50 Axe 2000\n" +
                "6 988244353 1\n" +
                "6 988244353 2\n" +
                "1 1000000007 adv2\n" +
                "11 988244353 1000000007\n" +
                "12 988244353\n" +
                "7 988244353 1\n";

        // 将模拟的输入数据转换为InputStream
        InputStream stdin = System.in;
        try {
            // 使用ByteArrayInputStream模拟用户输入
            System.setIn(new ByteArrayInputStream(inputData.getBytes()));

            // 调用Main类的main方法
            Main.main(null);

            // 在这里可以添加断言来检查是否正确执行了各个命令
            // 例如，如果CommandUtil类有一个用于记录执行日志的地方，你可以在这里检查结果
            // assertEquals(expectedValue, actualValue);

        } finally {
            // 恢复System.in到它的原始状态
            System.setIn(stdin);
        }
    }
}