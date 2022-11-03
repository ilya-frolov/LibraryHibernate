package entity;

import lombok.Data;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Magazine extends Printable{

    private LocalDate publishDate;

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + super.getId() +
                ", title=" + super.getTitle() +
//                ", author= " + super.getAuthor().getName() +
//                ", genre= " + super.getGenre().getName() +
//                ", publisher= " + super.getPublisher().getName() +
                "}";
    }
}
