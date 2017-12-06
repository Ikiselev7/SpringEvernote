package entity;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "mark", schema = "public", catalog = "Evernote")
@Getter
@Setter
@ToString(exclude = {"notes"})
@EqualsAndHashCode(exclude = {"notes"})
public class MarkEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @ManyToMany(mappedBy = "marks")
    private Set<NoteEntity> notes;

}
