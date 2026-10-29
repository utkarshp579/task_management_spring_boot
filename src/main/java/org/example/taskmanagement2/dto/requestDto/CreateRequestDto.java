package org.example.taskmanagement2.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateRequestDto {

    @NotBlank(message = "Description is required")
    @Size(min = 2 , max = 50 , message = "Description must be between 2 and 50 characters")
    private String description;

    @NotBlank(message = "Status could not be blank.")
    private String status;
    asd
    asd
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}