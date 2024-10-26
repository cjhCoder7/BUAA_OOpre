import java.util.ArrayList;

public class Expr {
    private final ArrayList<Term> terms = new ArrayList<>();

    public void addTerm(Term term) {
        terms.add(term);
    }

    @Override
    public String toString() {
        /*TODO(1/8): 可以参考 Term.toString() 实现相应功能*/
    }

    public void print() {
        System.out.println("Expr " + this);
    }

}
