import java.lang.foreign.*;
import java.lang.invoke.*;

public class FF {
  public static void main(final String... args) throws Throwable {
Linker linker = Linker.nativeLinker();
        SymbolLookup mathlib = SymbolLookup.libraryLookup(System.getProperty("user.dir") + "/libnative.so", Arena.ofAuto());
        MethodHandle addFunc = linker.downcallHandle(
            mathlib.find("add").orElseThrow(),
            FunctionDescriptor.of(ValueLayout.JAVA_DOUBLE,
                                   ValueLayout.JAVA_DOUBLE,
                                   ValueLayout.JAVA_DOUBLE)
        );
    double result = (double) addFunc.invoke(5.5, 2.3);
    System.out.println("Result: " + result);
  }
}
