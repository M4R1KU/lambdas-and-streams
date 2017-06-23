package me.mkweb.techtalk.util.internal;

import me.mkweb.techtalk.util.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Mario Kunz
 */
public abstract class AbstractRepository<T> implements Repository<T> {
    protected Map<Integer, T> entities = new HashMap<>();
    private int currentId = 1;

    /**
     * returns all available entities
     *
     * @return List<T>
     */
    @Override
    public List<T> findAll() {
        return entities.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    /**
     * returns an entity which is associated with the given id
     * if the id is not found an empty optional is returned
     *
     * @param id to search
     * @return either the optional with the person or an empty one
     */
    @Override
    public Optional<T> findOne(int id) {
        return Optional.ofNullable(entities.get(id));
    }

    /**
     * returns an optional of the entity which matches the given person predicate
     *
     * @param predicate to match
     * @return either the optional with the person or an empty one
     */
    @Override
    public Optional<T> findOne(Predicate<T> predicate) {
        return findAll().stream()
                .filter(predicate)
                .findFirst();
    }

    /**
     * adds or updates an entity to/in the Repository
     *
     * @param entity to save
     * @return the saved person e.g. the given one
     */
    @Override
    public T save(T entity) {
        int nextId = entities.entrySet().stream()
                .filter(entry -> entry.getValue().equals(entity))
                .map(Map.Entry::getKey)
                .findFirst().orElse(currentId++);
        entities.put(nextId, entity);
        return entity;
    }

    /**
     * adds or updates multiple entities to/in the Repository
     *
     * @param entities to save
     * @return the saved person e.g. the given one
     */
    @Override
    public List<T> save(List<T> entities) {
        return entities.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }
}
