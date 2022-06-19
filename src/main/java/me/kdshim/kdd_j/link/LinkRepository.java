package me.kdshim.kdd_j.link;

import me.kdshim.kdd_j.link.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findByUrl(String url);
    List<Link> findByUrlContaining(String keyword);
}
