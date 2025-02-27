package com.example.model.entity;

import com.example.model.entity.base.IdEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoPark extends IdEntity {
    private String name;
}
