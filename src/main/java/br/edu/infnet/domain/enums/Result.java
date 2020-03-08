package br.edu.infnet.domain.enums;

public enum Result {
    PASSED("Aprovado"),
    FAILED("Reprovado"),
    FINAL_EXAM("Teste Final");

    private String description;

    Result(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
