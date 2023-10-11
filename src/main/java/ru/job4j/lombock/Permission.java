package ru.job4j.lombock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder(builderMethodName = "of")
@AllArgsConstructor
public class Permission {
    private int id;
    private String name;

    @Singular("accessBy")
    private List<String> rules;
}
