package com.dsa.entities.dto;

import javax.validation.constraints.NotBlank;

public class CommentInvalid {
    @NotBlank(message = "Comment is required.")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
