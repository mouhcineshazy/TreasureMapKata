package com.treasure.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Treasure {
    Position position;
    int treasureCount;
}
