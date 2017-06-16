package me.mkweb.techtalk.lambdas.b_syntax;

import java.io.File;
import java.util.function.Function;

/**
 * @author Mario Kunz
 */
@SuppressWarnings("ALL")
public class Syntax {
    public static void main(String[] args) {
        //Everything here is exactly equivalent
        Function<String, File> a = (String path) -> {
            return new File(path);
        };

        Function<String, File> b = (String path) -> new File(path);

        Function<String, File> c = path -> new File(path);

        Function<String, File> d = File::new;
    }
}
