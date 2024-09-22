从第二次作业开始，oopre 就开始每周迭代开发啦，请注意让你的代码更**规范**哦！😮

## Part 0. 提交要求🤣

请保证提交项目的顶层目录至少存在两个文件夹：`src` 和 `test`（命名需严格与此保持一致），请将作业的 **功能代码** 存放于 `src` 文件夹下，同时将相关 **junit 测试类代码** 文件存放于 `test` 文件夹下，以保证评测的正常进行（评测时 **只会** 针对 `src` 目录下的文件进行程序 **功能** 的评测以及代码风格检测，也就是说，`test` 目录下的 junit 测试代码风格不会被检测）。参考目录结构如下：

```
|-src
  |- Bottle.java
  |- Equipment.java
  |- ...
|-test
  |- BottleTest.java
  |- EquipmentTest.java
  |- ...
```

## Part 2. 训练目标 😘

- **学会构建构造方法**

  Java 类使用变量定义数据状态，使用方法定义行为。除此之外，类还提供了一种称为构造方法 (constructor) 的特殊方法，用于创建新对象。作为类的方法，构造方法虽然可以完成任何动作，但是构造方法的目标是为了完成初始化，因此构造方法的实现代码具有显著的特征，即对类中定义的成员变量进行初始化。按照变量的类型要区分两种情况：

  - 基本数据类型的成员变量：一般是直接使用编程语言内置的数据类型所声明的变量，如 int ，boolean 等。这种成员变量一般可以直接赋值，如 `int price = 10`。
  - 复合类型的成员变量：一般是使用编程语言类库或用户自定义的类(class)来声明的成员变量，如 `ArrayList myList` 。这种成员变量一般通过`new`一个新对象的方式来进行初始化，如 `myList = new ArrayList()` 。

- **对类进行封装，理解封装的作用**

  封装是面向对象方法的一个重要特征，强调对外隐藏对象的内部属性和实现细节，仅对外提供有特定功能的访问方法。这样做的优点是提高类的可复用性、安全性。

  关键字 private 、protected 和 public 可以进一步对类的成员（包括变量和方法）的可见范围，被 private 修饰的成员只能在本类中使用；protected 修饰的成员可以在本类及其直接子类使用；public 修饰的成员可以在任意类中直接使用。一般而言，根据封装原则，如果没有特别的针对性考虑，建议对所有的成员变量使用 private 进行限定。

- **建立一个对象的集合，实现向集合中增加对象和访问集合中对象的操作，学习简单容器 ArrayList 的使用，熟悉对容器的操作**

- **学习 git 版本管理工具的基础知识**

  [Git Pro](https://www.progit.cn/) 是 Git 官方推荐的资料，其中介绍了 git 工具的基本用法和原理。本单元要求大家阅读前三章（起步、Git 基础、Git 分支），并根据从中学到的知识完成测验题目。

  本次作业中，我们希望大家可以阅读 [Git 基础 - 撤销操作](https://www.progit.cn/#_undoing) 一节及其之前的内容，以及 [Git 工具 - 重置揭秘](https://www.progit.cn/#_git_reset) 一节，并完成测试题目。

- **阅读官方文档** JDK 提供了官方文档 [JDK Document](https://docs.oracle.com/en/java/javase/18/docs/api/)，大家可以从中找到所有 Java 提供的类的详细介绍。该文档右上角提供了搜索框，输入想要查询的类或方法名，即可找到相关介绍。

## Part2. 预备知识 😶‍🌫️

在第一次作业中，我们初步了解了 Java 的基本语法。那么在本次作业中，我们要聚焦的重点则是类和类的关系，管理层次，这也引入了本次作业最重要的一个知识点————容器。

### 容器

在C语言中，我们经常使用（静态）数组来管理数据，比如

```c
struct Dog {
    char name[30];
    char type[30];
    int age;
    double price;
    int isBought; //0 for on sale, 1 for saled
} dogs[5];
```

在这里 `dogs[5]` 就管理了五个小狗结构体。 回忆上次作业 C 语言结构体和 Java 类的关联关系，是否也有类似的语法能够让我们管理这些类呢？

假设我们现在有两个类：**冒险者**， **药水**。这两个类的关系是：一个冒险者拥有不定个数的药水。
比如当冒险者获得了医疗包，那么恢复药水就会增加；又或者是冒险者被怪兽攻击，就又会消耗一定量的恢复药水……那么冒险者应该怎么管理这些药水呢？(该假设与本次作业题目内容无关)

在这里，我们引入一个比 C 语言中的 `a[]` 更强大的“数组”，也是本次作业希望同学们的初步掌握的———— **容器**。目前，你可以把它理解为一个有弹性的动态数组，同时具有更强大的功能。

```java
class Adventurer {
    private int id;
    private String name;
    private ArrayList<Bottle> bottleArray;
}
```

> 容器中的元素实际上是对象（也就是说，容器其中的元素类型不能是int char等这样的基本类型），一些常见的基本类型可以使用它的包装类。
> 基本类型对应的包装类表如下：

| 基本类型 | 引用类型  |
| -------- | --------- |
| boolean  | Boolean   |
| int      | Integer   |
| char     | Character |
| float    | Float     |
| double   | Double    |

接下来我们将通过代码样例来介绍两种容器的用法：`ArrayList`（介绍容器的示例代码中的Bottle类及其对应的类方法，并不是java自带的，是一个用来解释容器操作的自定义类，该类的具体含义可以参考本次作业题目中涉及到的Bottle类）

> 除了 `ArrayList` 外，还有`HashMap`、`TreeMap`、`HashSet`、`TreeSet` 等常用容器。这部分内容在课程后续内容会进行介绍，同学们也可以提前自行了解！

##### ArrayList

ArrayList 类是一个可以动态修改的数组，与普通数组的区别就是它是没有固定大小的限制，我们可以添加或删除元素。

```java
/* ArrayList 类位于 java.util 包中，使用前需要引入它，语法格式如下：*/
import java.util.ArrayList; // 引入 ArrayList 类

public class ArrayListSample {
    public void sample() {
        /* 1. 创建ArrayList */
        /* ArrayList<类名ClassName> 数组名ArrayName = new ArrayList<> */ 
        ArrayList<Bottle> bottles = new ArrayList<>();

        Bottle bottle1 = new Bottle(/*parameters*/);
        Bottle bottle2 = new Bottle(/*parameters*/);

        /* 2. 向ArrayList内加入一个元素(此外, 还可以向任意位置插入元素, 在add方法中新增参数即可) */
        /* 数组名ArrayName.add(元素名elementaryName) */
        bottles.add(bottle1);
        bottles.add(bottle2);

        /* 3. 访问ArrayList中下标为i的元素 */
        /* 数组名ArrayName.get(i) */
        Bottle bottle = bottles.get(0); // == bottle1

        /* 4. 判断元素是否在容器内 */
        if (bottles.contains(bottle)) { // true
            System.out.println("We have such a bottle!");
        }

        /* 5. ArrayList大小 */
        /* 数组名ArrayName.size() */
        int size = bottles.size();

        /* 6. 遍历ArrayList中的所有元素 */
        for (Bottle item : bottles) {
            System.out.println(item.getName()); // getName方法是Bottle类中用于获取其name属性的方法
        }

        for (int i = 0; i < bottles.size(); i++) {
            System.out.println(bottles.get(i).getName());
        }

        /* 7. 删除一个元素 */
        /* 数组名ArrayName.remove(对象名) */
        bottles.remove(bottle1); 
        /* 数组名ArrayName.remove(i) */
        bottles.remove(0); // 删除了bottle2

    }
}
```

## Part3. 题目描述 😁

### 背景

在接下来的若干次作业中，同学们将进行以本次作业为基础的迭代开发，因此在具体的代码实现中，希望同学们可以考虑到每一次所写代码的可扩展性和可维护性，从而减少下一次的工作量。

在接下来的几次作业中，请想象你是一个穿越到魔法大陆上的冒险者，在旅途中，你需要收集各种道具，使用各种装备，招募其他冒险者加入队伍，提升自己的攻击力和防御力并体验各种战斗。

在本次作业中，你要做的是：

- 实现冒险者类 `Adventurer` 、药水瓶类 `Bottle` 、装备类 `Equipment`
- 利用容器，管理所有冒险者，并管理每一个冒险者所拥有的药水瓶和装备

你可能需要实现的类和它们要拥有的属性

- Adventurer ：ID，名字，药水瓶和装备各自的容器
- Bottle：ID，名字，容量(capacity)
- Equipment：ID，名字，耐久度(durability)

**请注意，在作业中，可能会存在 ID 不同但名字相同的情况，请同学们在设计代码的时候考虑这一点**

其中，Bottle 的容量属性在本次作业中不会被测试，但是却是后续作业的重要部分，请同学们不要忽略。

在本次作业中，初始时，你没有需要管理的冒险者，我们通过若干条操作指令来修改当前的状态：

1. 加入一个需要管理的冒险者（新加入的冒险者不携带任何药水瓶和装备）
2. 给某个冒险者增加一个药水瓶
3. 给某个冒险者增加一个装备
4. 给某个冒险者的某个装备提升一点耐久度
5. 删除某个冒险者的某个药水瓶
6. 删除某个冒险者的某个装备

其中，提升耐久度的意思是，新耐久度 = 原有耐久度 + 1

### 输入格式

第一行一个整数 *n*，表示操作的个数。

接下来的 *n* 行，每行一个形如 `{type} {attribute}` 的操作，`{type}` 和 `{attribute}` 间、若干个 `{attribute}` 间使用**若干**个空格分割，操作输入形式及其含义如下。同时，为了方便测评，我们需要在需要执行一些指令后进行相关输出。具体要求也在下面的表中列出：

| type | attribute                               | 意义                                                         | 输出格式（每条对应的占一行）                                 |
| ---- | --------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | `{adv_id} {name}`                       | 加入一个 ID 为 `{adv_id}`、名字为 `{name}` 的冒险者          | 无                                                           |
| 2    | `{adv_id} {bot_id} {name} {capacity}`   | 给 ID 为 `{adv_id}` 的冒险者增加一个药水瓶，药水瓶的 ID、名字、容量分别为 `{bot_id}`、`{name}`、`{capacity}` | 无                                                           |
| 3    | `{adv_id} {equ_id} {name} {durability}` | 给 ID 为 `{adv_id}` 的冒险者增加一个装备，装备的 ID、名字、耐久度分别为 `{equ_id}`、`{name}`、`{durability}` | 无                                                           |
| 4    | `{adv_id} {equ_id}`                     | 将 ID 为 `{adv_id}` 的冒险者的 id 为 `{equ_id}` 的装备提升一点耐久度 | `{一个字符串} {一个整数}`（解释：字符串为装备的 **name**，整数为 **装备提升耐久后的耐久度**） |
| 5    | `{adv_id} {bot_id}`                     | 将 ID 为 `{adv_id}` 的冒险者的 id 为 `{bot_id}` 的药水瓶删除 | `{一个整数} {一个字符串} {一个整数}`（解释：第一个整数为删除后冒险者 **药水瓶数目**，字符串为删除的药水瓶的 **name**，第二个整数为删除的药水瓶的 **容量**） |
| 6    | `{adv_id} {equ_id}`                     | 将 ID 为 `{adv_id}` 的冒险者的 id 为 `{equ_id}` 的装备删除   | `{一个整数} {一个字符串} {一个整数}`（解释：第一个整数为删除后冒险者 **装备数目**，字符串为删除的装备的 **name**，第二个整数为删除的装备的 **耐久度**） |

输出数值时，你的输出数值需要和正确数值相等。

#### 输入输出样例

##### 输入1

```
4
1 700917 i$KdS=1n
3 700917 829431 ?TE/G1 3 
4 700917 829431
6 700917 829431
```

##### 输出1

```
?TE/G1 4
0 ?TE/G1 4
```

##### 输入2

```
3
1 700917 i$KdS=1n
2 700917 829431 ?TE/G1 3 
5 700917 829431
```

##### 输出2

```
0 ?TE/G1 3
```

### 数据限制

##### 变量约束

| 变量         | 类型   | 说明                                   |
| ------------ | ------ | -------------------------------------- |
| `id`         | 整数   | 取值范围：0 - 2147483647               |
| `name`       | 字符串 | 保证不会出现空白字符，长度区间: (0,40) |
| `capacity`   | 整数   | 取值范围：0 - 2147483647               |
| `durability` | 整数   | 取值范围：1 - 2147483647               |

##### 操作约束

1. **保证所有的冒险者、药水瓶、装备 id 均不相同**
2. 保证删除了的药水瓶/装备的 id 不会再次出现
3. 2-6 保证所有冒险者均已存在
4. 4-6 保证该冒险者拥有操作中提到 id 的药水瓶/装备
5. 保证增加的装备和药水瓶原本不存在
6. 操作数满足1 ≤ *n* ≤ 2000

### junit 测试

我们在 gitlab 上准备了一份 **junit 使用示例代码**（基于hw1程序）以及一份 **junit使用文档** 供大家参考，推荐各位同学在课下测试时使用 junit 单元测试来对自己的程序进行测试

- junit 是一个单元测试包，**可以通过编写单元测试类和方法，来实现对类和方法实现正确性的快速检查和测试**。还可以查看测试覆盖率以及具体覆盖范围（精确到语句级别），以帮助编程者全面无死角地进行程序功能测试。
- 此外，Junit 对主流 Java IDE（Idea、eclipse 等）均有较为完善的支持，具体的配置和使用方法可以参考 gitlab 上的使用文档。

#### 要求

本次作业要求同学们需要自行编写 junit 测试代码对自己的代码进行测试。在本次作业中，检测到**存在junit测试方法**并可以**成功编译** 即视为通过 junit 评测。

### 提示

考虑到正课尚未讲解有关输入解析的内容，我们在此提供一份输入解析代码，同学们可以将其复制到自己代码中的适当位置直接使用，当然，同学们也可以自行设计代码来进行输入解析。

```java
ArrayList<ArrayList<String>> inputInfo = new ArrayList<>(); // 解析后的输入将会存进该容器中, 类似于c语言的二维数组
Scanner scanner = new Scanner(System.in);
int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
for (int i = 0; i < n; ++i) {
    String nextLine = scanner.nextLine(); // 读取本行指令
    String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
    inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
}
```

经过这段代码，输入的信息会按照顺序被存入`inputInfo`这个"二维数组"中，遍历该容器即可取出各行指令及其各个部分。

## 总结 💕❤️😍

本次作业是冒险者任务的开始，要求就是建立对应的几个类，然后实现一下输入输出，本身不具有太大的难度

我主要创建的是这几个类

```
Adventure.java
Bottle.java
Equipment.java
Main.java
```

**关键点是如何管理输入的内容**，因为 BUAA 给的 `checkstyle` 要求一个方法的行数不能超过 60 行，所以我们需要考虑后面的作业当操作数变多的时候管理输入的命令。

本人主要使用的是 ***HashMap + Consumer 的思路实现了一个 commandMap 来管理要执行的命令***

```java
public static void initCommandMap() {
        commandMap.put(1, Main::addAdventure);
        commandMap.put(2, Main::addAdventureBottle);
        commandMap.put(3, Main::addAdventureEquipment);
        commandMap.put(4, Main::increaseDurability);
        commandMap.put(5, Main::deleteAdventureBottle);
        commandMap.put(6, Main::deleteAdventureEquipment);
        }
```

```java
for (ArrayList<String> strings : inputInfo) {
            int command = Integer.parseInt(strings.get(0));
            commandMap.get(command).accept(strings);
        }
```

这样在主函数中就可以简单的使用循环来对应要执行的命令啦！😁🎮

Tips ：当然使用 `switch` 也是可以的哦