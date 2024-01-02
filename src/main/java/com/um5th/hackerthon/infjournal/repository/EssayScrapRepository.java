package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EssayScrapRepository extends JpaRepository <EssayScrap, Long>{

}
