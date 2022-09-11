package com.ajaywagh.authcenter.log.audit;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "audit_table")
public class AuditEntryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long entryId;

    Date date;
    String corrId;
    String headers;
    String body;
}
