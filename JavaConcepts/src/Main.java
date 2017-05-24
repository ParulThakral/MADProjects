/**
 * Created by parulthakral on 5/24/17.
 */
public class Main {

    public static void main(String[] args){

        OuterClass.NestedClass objStaticClass = new OuterClass.NestedClass();
        objStaticClass.printMessage("hello there");

        OuterClass objOuterClass = new OuterClass();
        objOuterClass.message = "What is up with u , this is the difference btwn static nested class and inner class";
        objOuterClass.new InnerClass().printMessage();

        new Annonymous(){
            @Override
            public void calculateNothing() {
                System.out.println("What are you looking, it calculates nothing ,just using abstract interface");
            }
        }.calculateNothing();

        new AbstractAnonymous() {
            @Override
            void printMessage() {
                System.out.println("Definition");
            }
        }.hello();

    }
}
