package me.mkweb.techtalk.lambdas.m_method_references;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Mario Kunz
 */
public class ConstructorReference {
    public static void main(String[] args) {
        Function<String, IAmConstructable> constructableFunction = IAmConstructable::new;
        IAmConstructable instance = constructableFunction.apply("foo");
        System.out.println(instance.value);

        Supplier<StringBuilder> builderSupplier = StringBuilder::new;
        StringBuilder builder = builderSupplier.get();
        System.out.println(builder.append("Wuhu").toString());
    }

    private static class IAmConstructable {
        private String value;

        public IAmConstructable(String value) {
            this.value = value;
        }
    }
}
