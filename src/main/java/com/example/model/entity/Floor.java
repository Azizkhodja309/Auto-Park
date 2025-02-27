package com.example.model.entity;

import com.example.model.entity.base.IdEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Floor extends IdEntity {
    private String name;
    private Long parkId;
}
