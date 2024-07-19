package reflection;

import java.lang.reflect.Field;

public class ReflectionTest {
    public static void main(String[] args) throws Exception{
        MyClass myClass = new MyClass();
        System.out.println(myClass.theField);
        Field field1 = myClass.getClass().getDeclaredField("theField");
        field1.setAccessible(true);
        System.out.println(field1.get(myClass)); // no exception
        Field field2 = myClass.getClass().getDeclaredField("theField2");
        field2.setAccessible(false);
        System.out.println(field2.get(myClass)); // IllegalAccessException

    }

        public static class MyClass {
            private String theField = "hi";
            private String theField2 = "how";
        }

}
