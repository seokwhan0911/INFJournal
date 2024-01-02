package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsByNickname(String username);

    Optional<Member> findByNickname(String nickname);
}
