package com.company.informationsystem.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JmixEntity
@Entity
public class Employee extends Initiator {
    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @Column(name = "POST")
    private String post;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "SYSTEM_USER_ID", nullable = false)
    @Composition
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User systemUser;

    public User getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(User systemUser) {
        this.systemUser = systemUser;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}