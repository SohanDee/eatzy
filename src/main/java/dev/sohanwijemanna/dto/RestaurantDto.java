package dev.sohanwijemanna.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Embeddable
public class RestaurantDto {

    private String name;

    @Column(length = 1080)
    private List<String> images;

    private String description;

    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((RestaurantDto)o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
