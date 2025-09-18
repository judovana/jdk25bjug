import java.util.*;

// thank you https://www.baeldung.com/java-switch-pattern-matching
public class Main {

static void switchCase(String arg) {
  final String b = "B";
  switch (arg) {
    case "A" -> System.out.println("Parameter is A");
    case b -> System.out.println("Parameter is b");
    default -> System.out.println("Parameter is unknown");
  }
};


//Pattern matching, in general, was first introduced as a preview feature in Java SE 14
static void oldIsntanceOf(Object o) {
  if (o instanceof String s) {
      System.out.printf("Object is a string %s", s);
  } else if (o instanceof Number n) {
      System.out.printf("Object is a number %n", n);
  }
}

//Pattern matching for instanceof became a permanent feature in Java SE 16.
//Java SE 17 introduced pattern matching for the switch expressions and statements and Java SE 21 made it a permanent feature.
static double getDoubleUsingIf(Object o) {
    double result;
    if (o instanceof Integer) {
        result = ((Integer) o).doubleValue();
    } else if (o instanceof Float) {
        result = ((Float) o).doubleValue();
    } else if (o instanceof String) {
        result = Double.parseDouble(((String) o));
    } else {
        result = 0d;
    }
    return result;
}

static double getDoubleUsingSwitch1(Object o) {
    return switch (o) {
        case Integer i -> i.doubleValue();
        case Float f -> f.doubleValue();
        case String s -> Double.parseDouble(s);
        default -> 0d;
    };
}

// Guarded Pattern
static double getDoubleValueUsingIf(Object o) {
    return switch (o) {
        case String s -> {
            if (s.length() > 0) {
                yield Double.parseDouble(s);
            } else {
                yield 0d;
            }
        }
        default -> 0d;
    };
}

static double getDoubleValueUsingGuardedPatterns(Object o) {
    return switch (o) {
        case String s when s.length() > 0 -> Double.parseDouble(s);
        default -> 0d;
    };
}

//primitive type pattern in switch case labels as a preview feature in Java SE 24
static void  primitiveTypePatternExample() {
    Random r=new Random();
    switch (r.nextInt()) {
        case 1 -> System.out.println("int is 1");
        case int i when i > 1 && i < 100 -> System.out.println("int is greater than 1 and less than 100");
        default -> System.out.println("int is greater or equal to 100");
    }
}


//Covering All Values
static double getDoubleUsingSwitch2(Object o) {
    return switch (o) {
        case String s -> Double.parseDouble(s);
        default -> Double.NaN;
    };
}


//Ordering Subclasses
static double getDoubleUsingSwitch3(Object o) {
    return switch (o) {
        //case CharSequence c -> Double.parseDouble(c.toString());
        case String s -> Double.parseDouble(s);
        case CharSequence c -> Double.parseDouble(c.toString());
        default -> 0d;
    };
}

//Handling Null Values; In earlier versions of Java, each passing of a null value to a switch statement would result in a NullPointerException.
static double getDoubleUsingSwitch4(Object o) {
    return switch (o) {
        case String s -> Double.parseDouble(s);
        case null -> 0d;
        default -> 0d;
    };
}


  public static void main(final String... args) throws Exception {
    switchCase("B");
    oldIsntanceOf(Double.valueOf("50"));
    System.out.println("" + getDoubleUsingIf(Double.valueOf("51")));
    System.out.println("" + getDoubleUsingSwitch1(Double.valueOf("52")));
    System.out.println("" + getDoubleValueUsingIf(Double.valueOf("53")));
    System.out.println("" + getDoubleValueUsingGuardedPatterns("12345"));
    primitiveTypePatternExample();
    System.out.println("" + getDoubleUsingSwitch2("1"));
    System.out.println("" + getDoubleUsingSwitch3("2"));
    System.out.println("" + getDoubleUsingSwitch4("3"));

  }
}
