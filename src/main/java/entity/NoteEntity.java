package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "note", schema = "public", catalog = "Evernote")
@Getter
@Setter
@ToString(exclude = {"marks","noteBook"})
@EqualsAndHashCode(exclude = {"marks","noteBook"})
public class NoteEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;

    @Basic
    @Column(name = "description", length = -1)
    private String description;

    @Basic
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @ManyToMany
    @JoinTable(name = "note_mark", catalog = "Evernote", schema = "public", joinColumns = @JoinColumn(name = "id_note", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_mark", referencedColumnName = "id", nullable = false))
    private Set<MarkEntity> marks;

    @ManyToOne
    @JoinColumn(name = "id_note_book", referencedColumnName = "id", nullable = false)
    private NoteBookEntity noteBook;

}
