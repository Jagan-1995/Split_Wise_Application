package dev.jagan.split_wise_application.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "Splitwise_groups")
public class Group extends BaseModel{
    private String name;
    private String description;

    @ManyToMany
    private List<User> members;

    @ManyToOne
    private User createdBy; // Admin

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}


/*

   1         M
 Group ---- User => M : M
   M         1

   1          1
 Group ---- Admin => M : 1
   M          1

   1          M
 Group ---- Expense => 1 : M
   1          1

 */