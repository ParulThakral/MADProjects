/**
 * Created by parulthakral on 5/24/17.
 */
public class OuterClass {

    String message;

    static class NestedClass{

        public void printMessage(String msg){
            System.out.println(msg);
        }
    }

    class InnerClass{
        public void printMessage(){
            System.out.println(message);
        }
    }
}
