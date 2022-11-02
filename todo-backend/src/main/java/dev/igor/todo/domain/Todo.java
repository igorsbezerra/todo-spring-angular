package dev.igor.todo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateToFinish;
    private Boolean finished = false;

    public Todo() {
    }

    public Todo(Integer id, String title, String description, LocalDate dateToFinish, Boolean finished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateToFinish = dateToFinish;
        this.finished = finished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateToFinish() {
        return dateToFinish;
    }

    public void setDateToFinish(LocalDate dateToFinish) {
        this.dateToFinish = dateToFinish;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id.equals(todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateToFinish=" + dateToFinish +
                ", finished=" + finished +
                '}';
    }
}
