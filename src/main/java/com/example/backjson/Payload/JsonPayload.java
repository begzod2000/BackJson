package com.example.backjson.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonPayload {
   private Long userID;

    private Long id;

    private String title;

    private String body;
}
