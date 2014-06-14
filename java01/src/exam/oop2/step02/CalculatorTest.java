package exam.oop2.step02;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		
		c1.plus(5);
		c1.plus(7);
		c1.minus(3);
		System.out.println(c1.result);
		
		CalculatorPro c2 = new CalculatorPro();
		c2.plus(3); // Calculator#plus()
		c2.plus(5); // Calculator#plus()
		c2.minus(3); // Calcuator#mius()
		c2.multiple(5); // CalculatorPro#multiple()
		System.out.println(c2.result);
		
		CalculatorEnterprise c3 = new CalculatorEnterprise();
		c3.plus(3); // Calculator#plus()
		c3.plus(5); // Calculator#plus()
		c3.minus(3); // Calcuator#mius()
		c3.multiple(5); // CalculatorPro#multiple()
		c3.divide(2); // CalculatorEnterprise#divide()
		System.out.println(c2.result);
	}

}
