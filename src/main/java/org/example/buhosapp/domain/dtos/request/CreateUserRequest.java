package org.example.buhosapp.domain.dtos.request;

public class CreateUserRequest {

    private String username;
    private String email;
    private String card;
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String username, String email, String card, String password) {
        this.username = username;
        this.email = email;
        this.card = card;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String username;
        private String email;
        private String card;
        private String password;

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

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public CreateUserRequest build() {
            return new CreateUserRequest(username, email, card, password);
        }
    }
}
