package com.example.survey.api.question;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public final class PatchQuestionRequest {

    @NotNull
    private final Boolean active;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PatchQuestionRequest(@JsonProperty("active") Boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatchQuestionRequest that = (PatchQuestionRequest) o;
        return active.equals(that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active);
    }
}
