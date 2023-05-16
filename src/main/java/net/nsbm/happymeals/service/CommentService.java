package net.nsbm.happymeals.service;

import java.util.List;

import net.nsbm.happymeals.model.Comment;

public interface CommentService
{
    List<Comment> fetchAllComment();

    List<Comment> fetchCommentByFoodID(int foodID);

    List<Comment> fetchCommentByParentID(int foodID, int parentID);

    String loadComments(int foodID);

    void addComment(Comment comment);
}
