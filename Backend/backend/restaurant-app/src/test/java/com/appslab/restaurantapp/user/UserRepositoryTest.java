package com.appslab.restaurantapp.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @Test
    void itShouldFindUserByUsername() {
        //given
        String username = "martin";
        User user = new User(username, "password", "martin@martin.com");
        underTest.save(user);
        Optional<User> optionalUser= Optional.of(user);

        //when
        Optional<User> expected = underTest.findByUsername(username);

        //then
        assertThat(expected).isEqualTo(optionalUser);
    }

}