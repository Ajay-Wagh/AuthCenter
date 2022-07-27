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
@Table(name = "apps")
public class App {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String token;

    @OneToMany
    @ToString.Exclude
    private Set<AppPermission> permissions;
}
