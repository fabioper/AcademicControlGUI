package br.edu.infnet.domain.helpers;

import br.edu.infnet.domain.entities.Entity;

import java.util.Collection;
import java.util.UUID;

public interface Repository<T extends Entity> {
    Collection<T> getAll();

    T getById(UUID id);

    void add(T entity);

    int getSize();
}
