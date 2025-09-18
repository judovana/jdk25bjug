import java.lang.classfile.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class Main1 {

  private static final String greeting = "hello!";
  private static final String original = "Main1.class";
  private static final String target = "Main2.class";

  public void hello() {System.out.println(greeting);}

  public static void main(String... args) throws Exception {
    new Main1().hello();
    new Main1().readItself();
    Main1.writeItself();
  }

  public void readItself() throws Exception {
    ClassFile cf = ClassFile.of();
//    ClassModel classModel = cf.parse(Files.readAllBytes(Paths.get(original)));
    ClassModel classModel = cf.parse(Files.readAllBytes(Paths.get(this.getClass().getName()+".class")));
    for (ClassElement e : classModel) {
        if (e instanceof MethodModel) {
		  System.out.println(e.getClass()+ " - " + ((MethodModel)e).methodName());
        } else  if (e instanceof FieldModel) {
    	  System.out.println(e.getClass()+ " - " + ((FieldModel)e).fieldName());
        } else {
          System.out.println(e.getClass());
        }
    }
  }
  public static void writeItself() throws Exception {
    ClassFile cf = ClassFile.of();
    ClassModel classModel = cf.parse(Files.readAllBytes(Paths.get(original)));
    byte[] newBytes = cf.build(classModel.thisClass().asSymbol(),
        classBuilder -> {
            for (ClassElement ce : classModel) {
                if (!(ce instanceof MethodModel mm
                        && mm.methodName().stringValue().startsWith("writeItself"))) {
                    classBuilder.with(ce);
                }
            }
        });
    //ClassFile cf2 = ClassFile.of();
    //ClassModel classModel2 = cf.parse(newBytes);
    Files.write(Paths.get(target), newBytes);
  }
}

