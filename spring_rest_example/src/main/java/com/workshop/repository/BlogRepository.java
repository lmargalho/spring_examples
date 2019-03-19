package com.workshop.repository;

import com.workshop.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Entry, Long> {

    List<Entry> findByTitle(String title);
}
