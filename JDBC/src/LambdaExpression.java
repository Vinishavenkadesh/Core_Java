//Single Abstract Method(SAM) => Functional interface
// From java 8 - if it is a functional interface then Lambda expressions can be used

public class LambdaExpression {
    public static void main(String[] args) {
        Adder add = (a,b) -> a+b;
        Adder sub = (a,b) -> a-b;
        System.out.println(add.add(3,5));//add.add => variableName.methodName

        ReverseString rs = (str) -> {
            String rev = "";
            for(int i = str.length() - 1; i >= 0 ; i--) {
                rev += str.charAt(i);
            }
            return rev;
        };
        System.out.println(rs.str("Ena"));
    }
}

@FunctionalInterface
interface Adder{
    double add(int a,int b);
}

@FunctionalInterface
interface Math{
    double add(int a,int b);
}

@FunctionalInterface
interface ReverseString{
    String str(String str);
}
