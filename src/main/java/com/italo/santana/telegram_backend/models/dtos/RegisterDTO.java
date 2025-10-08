package com.italo.santana.telegram_backend.models.dtos;

import com.italo.santana.telegram_backend.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record  RegisterDTO(@NotNull String fullName, @NotBlank String email, @NotBlank String password, @NotNull UserRole userRole) {
}
