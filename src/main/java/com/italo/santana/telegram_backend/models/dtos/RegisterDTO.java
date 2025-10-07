package com.italo.santana.telegram_backend.models.dtos;

import com.italo.santana.telegram_backend.enums.UserRole;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(@NotBlank String email, @NotBlank String password, @NotBlank UserRole userRole) {
}
