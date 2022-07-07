package com.company.informationsystem.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "CLIENT")
@JmixEntity
@Entity
@PrimaryKeyJoinColumn(name = "clientId", referencedColumnName = "ID")
public class Client extends Initiator {
    @NotNull
    @Email
    @Column(name = "EMAIL")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}