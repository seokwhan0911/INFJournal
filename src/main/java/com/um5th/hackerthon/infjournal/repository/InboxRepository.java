package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.mapping.Inbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboxRepository extends JpaRepository<Inbox, Long> {

}
