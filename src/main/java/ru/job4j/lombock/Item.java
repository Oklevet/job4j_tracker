package ru.job4j.lombock;

import lombok.*;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {
    @Getter
    @Setter
    private int id;

    @EqualsAndHashCode.Include
    private String name;
}
