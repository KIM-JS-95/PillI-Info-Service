package com.Streamming.Entity;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends CrudRepository<Video,Long> {
    List<Video> findByTitleContaining(String name);

    List<Video> findAll(Sort like);
}
