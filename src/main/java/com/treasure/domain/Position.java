package com.treasure.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Position {

    int horizontalPosition;
    int verticalPosition;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return horizontalPosition == position.horizontalPosition &&
                verticalPosition == position.verticalPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontalPosition, verticalPosition);
    }

    @Override
    public String toString() {
        return "Position{" +
                "horizontal Position=" + horizontalPosition +
                ", vertical Position=" + verticalPosition +
                '}';
    }
}
