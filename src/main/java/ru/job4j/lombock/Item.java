package ru.job4j.lombock;

import lombok.*;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Item {
    @NonNull
    @Getter
    @Setter
    private int id;

    @EqualsAndHashCode.Include
    private String name;
}
