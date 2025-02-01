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
@SequenceGenerator(name = "sequence", sequenceName = "USER_SEQ")
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractPersistable<Long> {
    public User(Long id) {
        super(id);
    }

    private String email;
    private String password;
    private String roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
