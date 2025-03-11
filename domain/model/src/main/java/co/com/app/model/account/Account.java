package co.com.app.model.account;

import lombok.Builder;

@Builder(toBuilder = true)
public record Account(String name, int balance) {
}
