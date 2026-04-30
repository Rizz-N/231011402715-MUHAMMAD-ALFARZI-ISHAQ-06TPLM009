package com.api.pos.Config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class response<T> {
    int status;
 private String message;
 private T data;
 private Integer prev;
 private Integer Next;
 private Integer current;

}

