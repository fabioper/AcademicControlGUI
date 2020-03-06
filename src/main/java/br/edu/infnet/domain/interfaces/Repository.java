package br.edu.infnet.domain.interfaces;

import br.edu.infnet.domain.entities.Entity;
import java.util.Collection;
import java.util.UUID;

public interface Repository<T extends Entity> {
    Collection<T> getAll();

    T getById(UUID id);

    void add(T entity);

    int getSize();
}
