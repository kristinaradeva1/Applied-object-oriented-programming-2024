package pr3;

import java.util.function.IntConsumer;

public class LambdaTest {
    public static void main(String[] args) {
        IntConsumer consumer = (value) -> System.out.printf("%d ", value);

        //(String s) -> {return s.toUpperCase();}
                //IntConsumer()
        //{
          //  public void accept(int value)
            //{
               // System.out.printf("%d ", value);
            //}
        //}
        StringInterface si = (String s) ->
        {
            return s.toUpperCase();
        };
    }
}