package me.kdshim.kdd_j.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    public List<Member> findAllByName(String name);

    public Optional<Member> findFirstByName(String name);
}
