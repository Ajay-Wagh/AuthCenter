package com.ajaywagh.authcenter.log.audit;

import com.ajaywagh.authcenter.log.LoggedClass;
import com.ajaywagh.authcenter.log.audit.model.AuditEntry;
import com.ajaywagh.authcenter.log.audit.repository.AuditEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;


@Slf4j
@Component
@LoggedClass
public class AuditLogger {

    @Autowired
    AuditEntryRepository auditEntryRepository;

    final Calendar calendar=Calendar.getInstance();


    public void log(String corrId,String headers,String body,EntryType entryType,EntryOutcome entryOutcome){
        AuditEntry auditEntry=new AuditEntry(calendar.getTime(),corrId,headers,body,entryType,entryOutcome);
        auditEntryRepository.saveAndFlush(auditEntry);
    }

}
