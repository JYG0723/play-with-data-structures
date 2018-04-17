/**
 * @author Ji YongGuang.
 * @date 14:21 2018/4/17.
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("String(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("ZhangSan", 17));
        studentArray.addLast(new Student("LiSi", 18));
        studentArray.addLast(new Student("WangWu", 19));
        System.out.println(studentArray);
    }
}
