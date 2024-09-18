package com.animeclone.project.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "_user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "roles_id")
    private Integer roleId;

}
