package com.adams.cursomc.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

  private Integer status;
  private String msg;
  private Long timeStamp;
}
