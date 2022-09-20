package com.ajaywagh.authcenter.log.audit.model;

import com.ajaywagh.authcenter.log.audit.EntryOutcome;
import com.ajaywagh.authcenter.log.audit.EntryType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "audit_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuditEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long entryId;

    Date date;
    String corrId;
    String headers;
    String body;
    @Enumerated(EnumType.STRING)
    EntryType entryType;
    @Enumerated(EnumType.STRING)
    EntryOutcome entryOutcome;

    public AuditEntry(Date date, String corrId, String headers, String body, EntryType entryType, EntryOutcome entryOutcome) {
        this.date = date;
        this.corrId = corrId;
        this.headers = headers;
        this.body = body;
        this.entryType = entryType;
        this.entryOutcome = entryOutcome;
    }
}
