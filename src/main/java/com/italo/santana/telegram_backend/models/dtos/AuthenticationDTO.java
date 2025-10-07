package com.italo.santana.telegram_backend.models.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(@NotBlank String email, @NotBlank String password) {
}
