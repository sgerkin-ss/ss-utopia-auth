package com.ss.utopia.auth.bootstrap;

import com.ss.utopia.auth.entity.UserAccount;
import com.ss.utopia.auth.entity.UserRole;
import com.ss.utopia.auth.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("local-h2")
@RequiredArgsConstructor
public class H2DataBootstrap implements CommandLineRunner {

  private final UserAccountRepository userAccountRepository;
  private final BCryptPasswordEncoder passwordEncoder;
  private String encodedPassword;

  @Override
  public void run(String... args) {
    if (userAccountRepository.count() == 0) {
      encodedPassword = passwordEncoder.encode("test");
      loadAllTestAccounts();
    }
  }

  private void loadAllTestAccounts() {
    loadDefaultUser();
    loadCustomerUser();
    loadTravelAgentUser();
    loadEmployeeUser();
    loadServiceUser();
    loadAdminUser();
  }

  private void loadDefaultUser() {
    var user = UserAccount.builder()
        .email("default@test.com")
        .password(encodedPassword)
        .userRole(UserRole.DEFAULT)
        .build();
    userAccountRepository.save(user);
  }

  private void loadCustomerUser() {
    var user = UserAccount.builder()
        .email("customer@test.com")
        .password(encodedPassword)
        .userRole(UserRole.CUSTOMER)
        .confirmed(true)
        .build();
    userAccountRepository.save(user);
  }

  private void loadTravelAgentUser() {
    var user = UserAccount.builder()
        .email("travel_agent@test.com")
        .password(encodedPassword)
        .userRole(UserRole.TRAVEL_AGENT)
        .confirmed(true)
        .build();
    userAccountRepository.save(user);
  }

  private void loadEmployeeUser() {
    var user = UserAccount.builder()
        .email("employee@test.com")
        .password(encodedPassword)
        .userRole(UserRole.EMPLOYEE)
        .confirmed(true)
        .build();
    userAccountRepository.save(user);
  }

  private void loadServiceUser() {
    var user = UserAccount.builder()
        .email("service@test.com")
        .password(encodedPassword)
        .userRole(UserRole.SERVICE)
        .confirmed(true)
        .build();
    userAccountRepository.save(user);
  }

  private void loadAdminUser() {
    var user = UserAccount.builder()
        .email("admin@test.com")
        .password(encodedPassword)
        .userRole(UserRole.ADMIN)
        .confirmed(true)
        .build();
    userAccountRepository.save(user);
  }
}
