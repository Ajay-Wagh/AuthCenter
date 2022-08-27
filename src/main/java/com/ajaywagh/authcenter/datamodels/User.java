package com.ajaywagh.authcenter.datamodels;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(columnNames = {"tenant","userid"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "tenant",nullable = false)
    private Tenant tenant;

    @Column(nullable = false,name = "userid")
    private String userId;

    @Column(nullable = false)
    private String salt;

    @Column(nullable = false)
    private String hash;
    @OneToMany
    @ToString.Exclude
    @Column(nullable = false)
    private Set<UserPermission> userPermissions;
    @OneToMany
    @ToString.Exclude
    @Column(nullable = false)
    private Set<UserChannel> userChannels;
}
