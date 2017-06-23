package me.mkweb.techtalk.util;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author Mario Kunz
 */
public interface Repository<T> {
    List<T> findAll();
    Optional<T> findOne(int id);
    Optional<T> findOne(Predicate<T> predicate);
    T save(T toSave);
}
