package com.example.demo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository repo;

    @Test
    void save_and_find() {
        User u = repo.save(new User("amwtke"));
        assertThat(u.getId()).isNotNull();
        assertThat(repo.findByUsername("amwtke")).isPresent();
    }
}
