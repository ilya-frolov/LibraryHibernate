package entity;

import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class Book extends Printable{

    @Override
    public String toString() {
        return "Book{" +
                "id= " + super.getId() +
                ", title= " + super.getTitle() +
//                ", author= " + super.getAuthor().getName() +
//                ", genre= " + super.getGenre().getName() +
//                ", publisher= " + super.getPublisher().getName() +
                "}";
    }

}
