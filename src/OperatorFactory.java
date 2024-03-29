import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    static Map<String, Class> ops = new HashMap<>();

    static {
        ops.put("PRINT", Print.class);
        ops.put("LET", Let.class);
        ops.put("IF", If.class);
        ops.put("GOTO", GoTo.class);
    }

    public static Operator createOperator(String opName, String substring) {
        Class opClass = ops.get(opName);
        try {
            return (Operator) opClass.getConstructor(String.class).newInstance(substring);
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
