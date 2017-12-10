package com.epam.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "note_book")
@Getter
@Setter
@ToString(exclude = {"notes", "user"})
@EqualsAndHashCode(exclude = {"notes", "user"})
public class NoteBookEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @Basic
    @Column(name = "create_date", nullable = false)
    @Convert(converter = TimestampPersistenceConverter.class)
    private ZonedDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "noteBook", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<NoteEntity> notes = new HashSet<>();

}
