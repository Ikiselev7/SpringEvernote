package com.epam.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "user", schema = "public", catalog = "Evernote")
@Getter
@Setter
@ToString(exclude = {"noteBooks"})
@EqualsAndHashCode(exclude = {"noteBooks"})
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "first_name", nullable = false, length = -1)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = -1)
    private String lastName;

    @Basic
    @Column(name = "email", nullable = false, length = -1)
    private String email;

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<NoteBookEntity> noteBooks;

}
