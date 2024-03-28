package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookResponseDto<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> BookResponseDto<T> success(T data){
        return BookResponseDto.<T>builder()
                .message("SUCCESS!")
                .data(data)
                .success(true)
                .build();
    }
    public static <T> BookResponseDto<T> error(){
        return BookResponseDto.<T>builder()
                .message("ERROR!")
                .success(false)
                .build();
    }
}
