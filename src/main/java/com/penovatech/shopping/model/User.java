package com.penovatech.shopping.model;


import com.penovatech.common.model.AbstractPersistable;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_USER")
@Getter
@Setter
@SequenceGenerator(name = "sequence", sequenceName = "USER_SEQ", allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractPersistable<Long> {
    public User(Long id) {
        super(id);
    }
    private String email;
    private String password;
    private String roles;
}
