package entornos.rubrica29;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ejemplo1Test.class, ejemplo2Test.class, ejemplo3Test.class, ejemplo4Test.class, ejemplo5Test.class, ejemplo6Test.class })
public class AllTests {
	public static void main(String[] args) {
		Result resultados = JUnitCore.runClasses(Suite.class);
	      for (Failure failure : resultados.getFailures()) {
	          System.out.println(failure.toString());
	       }
	       System.out.println(resultados.wasSuccessful());
	}
}
