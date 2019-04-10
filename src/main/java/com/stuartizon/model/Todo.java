package com.stuartizon.model;

import lombok.Data;

@Data
public class Todo {
    private final int userId;
    private final int id;
    private final String title;
    private final boolean completed;
}
