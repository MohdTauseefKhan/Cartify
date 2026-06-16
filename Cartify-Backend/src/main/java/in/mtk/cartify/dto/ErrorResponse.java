package in.mtk.cartify.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
public class ErrorResponse {
    private String path;
    private int status;
    private String error;
    private String message;
    private LocalDateTime timeStamp;
}
