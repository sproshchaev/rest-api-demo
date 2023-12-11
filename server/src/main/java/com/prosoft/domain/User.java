package com.prosoft.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "user")
public class User {
    @Id
    @Column("login")
    private String login;
    @Column("password")
    private String password;
    @Column("role")
    private String role;

}
