package com.job.dynamicproviders.model.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long>{
    @Query("select pc from PostComment pc where pc.post.id = :postId")
    List<PostComment> find(@Param("postId") Long postId);

    @Query("from PostComment")
    List<PostComment> findMany();
}
