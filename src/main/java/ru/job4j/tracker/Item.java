package ru.job4j.tracker;


import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Item {
    private int id;
    @NonNull
    private String name;
}