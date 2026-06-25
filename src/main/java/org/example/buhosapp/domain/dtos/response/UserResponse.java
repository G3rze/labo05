package org.example.buhosapp.domain.dtos.response;

public class UserResponse {

    private String username;
    private String email;
    private String card;

    public UserResponse() {
    }

    public UserResponse(String username, String email, String card) {
        this.username = username;
        this.email = email;
        this.card = card;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String username;
        private String email;
        private String card;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder card(String card) {
            this.card = card;
            return this;
        }

        public UserResponse build() {
            return new UserResponse(username, email, card);
        }
    }
}
