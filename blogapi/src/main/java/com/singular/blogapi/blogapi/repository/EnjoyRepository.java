package com.singular.blogapi.blogapi.repository;

import com.singular.blogapi.blogapi.domain.Enjoy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnjoyRepository extends JpaRepository<Enjoy,Long> {
}
