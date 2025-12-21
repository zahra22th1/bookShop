package org.example.bookshop.dto.resquest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor

public class UserRequest {
    @NotBlank(message = "{username.is.null}")
    private final String username;
    @NotBlank(message = "{password.is.null}")
    private final String password;
}
