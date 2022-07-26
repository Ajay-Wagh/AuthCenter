package com.ajaywagh.authcenter.POJO;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private String id;
    @Column(nullable = false,unique = true)
    private String hash;
    @OneToMany
    @ToString.Exclude
    private Set<UserPermission> userPermissions;
    @OneToMany
    @ToString.Exclude
    private Set<UserChannel> userChannels;
}
