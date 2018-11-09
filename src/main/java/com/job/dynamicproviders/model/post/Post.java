package com.job.dynamicproviders.model.post;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Post")
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = )
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;


    public Post(String title) {
        this.title = title;
    }

    //Constructors, getters and setters removed for brevity
}

