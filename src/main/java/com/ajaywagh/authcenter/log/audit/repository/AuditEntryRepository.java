package com.ajaywagh.authcenter.log.audit.repository;

import com.ajaywagh.authcenter.log.audit.model.AuditEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditEntryRepository extends JpaRepository<AuditEntry,Long> {
}
