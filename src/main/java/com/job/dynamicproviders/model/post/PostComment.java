package com.job.dynamicproviders.model.post;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "PostComment")
@Table(name = "post_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue
    private Long id;

    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    public PostComment(String review) {
        this.review = review;
    }


    //Constructors, getters and setters removed for brevity
}