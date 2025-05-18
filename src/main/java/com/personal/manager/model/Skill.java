package com.personal.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String subject;

    @Column(nullable = false)
    private double value;

    @Column(nullable = false)
    private double fullMark;

    // Constructors
    public Skill() {
    }

    public Skill(String subject, double value, double fullMark) {
        this.subject = subject;
        this.value = value;
        this.fullMark = fullMark;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getFullMark() {
        return fullMark;
    }

    public void setFullMark(double fullMark) {
        this.fullMark = fullMark;
    }

    @Override
    public String toString() {
        return "Skill{"
                + "id=" + id
                + ", subject='" + subject + '\''
                + ", value=" + value
                + ", fullMark=" + fullMark
                + '}';
    }
}
