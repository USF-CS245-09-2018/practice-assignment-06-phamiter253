public class Assert {
    public static void not_false(boolean expression){
        if(!expression){
            throw new IllegalArgumentException();
        }
    }
}
