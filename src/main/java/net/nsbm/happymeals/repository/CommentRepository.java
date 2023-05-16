package net.nsbm.happymeals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.nsbm.happymeals.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>
{
    @Query("SELECT c FROM Comment c WHERE c.foodID = ?1")
    List<Comment> findByFoodId(int foodID);

    @Query("SELECT c FROM Comment c WHERE c.foodID = ?1 AND c.parentID = ?2")
    List<Comment> findByParentId(int foodID, int parentID);
}
