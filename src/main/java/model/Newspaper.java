package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
//@Entity
public class Newspaper extends Printable{

    public Newspaper (String title) {
        super.setTitle(title);
    }

    private LocalDate publishDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "newspaper_revieweer", joinColumns = {@JoinColumn(name = "newspaper_id")},
    inverseJoinColumns = {@JoinColumn(name = "reviewer_id")})
    private List<Reviewer> reviewers;

    @Override
    public String toString() {
        return "Newspaper{" +
                "id=" + super.getId() +
                ", title=" + super.getTitle() +
                ", author= " + super.getAuthor().getName() +
                ", genre= " + super.getGenre().getName() +
//                ", publisher= " + super.getPublisher().getName() +
                "}";
    }
}
