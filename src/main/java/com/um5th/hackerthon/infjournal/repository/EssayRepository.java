package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EssayRepository extends JpaRepository<Essay, Long> {

    List<Essay> findAllByMember(Member member);
    //List<Essay> findByAuthor(Member author);
}
