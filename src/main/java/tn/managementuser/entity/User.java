package tn.managementuser.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import tn.managementuser.entity.enums.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @JsonProperty("first_name")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @JsonProperty("password")
    @Column(name = "password")
    private String password;

    @JsonProperty("role")
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
