package com.example.librarymgr.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDTO {
    Long patronId;
    List<Long> bookIdList;
}
