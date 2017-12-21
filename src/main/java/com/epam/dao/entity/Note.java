package com.epam.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "note")
@Getter
@Setter
@ToString(exclude = {"marks","noteBook"})
@EqualsAndHashCode(exclude = {"marks","noteBook"})
public class Note {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;

    @Basic
    @Column(name = "description", length = -1)
    private String description;

    @Basic
    @Column(name = "create_date", nullable = false)
    @Convert(converter = TimestampPersistenceConverter.class)
    private ZonedDateTime createDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "note_mark",
            joinColumns = @JoinColumn(name = "id_note",
                    referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_mark",
                    referencedColumnName = "id",
                    nullable = false))
    private Set<Mark> marks = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_note_book", referencedColumnName = "id", nullable = false)
    private NoteBook noteBook;

}
