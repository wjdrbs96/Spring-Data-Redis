package me.gyun.redis.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * created by jg 2021/04/07
 */
@Setter
@Getter
public class DataDto {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "DataDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
