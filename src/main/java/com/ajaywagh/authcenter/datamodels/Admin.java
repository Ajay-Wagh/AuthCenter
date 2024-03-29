package com.ajaywagh.authcenter.datamodels;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admins")
public class Admin {

    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false)
    private String salt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Admin admin = (Admin) o;
        return userId != null && Objects.equals(userId, admin.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
