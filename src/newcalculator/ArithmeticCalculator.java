package newcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private T number;

    private ArrayList<Double> results = new ArrayList<Double>();

    public double calculate(T num1, T num2, OperatorType math) {
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();
        double result = 0;

        switch (math) {
            case ADD:
                result = n1 + n2;
                break;
            case SUB:
                result = n1 - n2;
                break;
            case MUL:
                result = n1 * n2;
                break;
            case DIV:
                if (n2 == 0) {
                    // 리턴 값을 0 대신 오류로 표현해야 한다.
//                    System.out.println("0으로 나눌 수 없습니다.");
//                    return 0;
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = n1 / n2;
                break;
            default:
                // 리턴 값을 0 대신 오류로 표현해야 한다.
//                System.out.println("잘못된 연산 기호입니다");
//                return 0;
                throw new IllegalArgumentException("잘못된 연산 기호입니다.");
        }
        results.add(result);
        return result;
    }

    // Getter 메서드
    public ArrayList<Double> getResults() {
        return results;
    }

    // Setter 메서드
    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    // 람다 스트림
    public List<Double> big(double value) {
        List<Double> box = results.stream()
                .filter(num -> num > value)
//                .map(num -> "결과: " + num)
                .collect(Collectors.toList());

        return box;
    }

}

