package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

//@SpringBootTest
// ane remove kri ne pan thy mocketest pn change krvu pd thoduk code ma
//je niche krelu j che mockbean ni bdle mock and autowired ni bdle injectmocks like
// aya apde springContext no use krrta ta have e remove kri nkaho che etle a bdha changes che

@Disabled
public class UserDetailsServiceImplTests {

//    @Autowired have apde ani bdle injectMocks use krvu pdse
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

// @MockBean
    /* and aya pan apde uper springboottest remove kri didhu to have apde aya mockbea
       bdle mock j use krvu pdse */

    @Mock
    private UserRepository UserRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest(){
        when(UserRepository.findByUserName(ArgumentMatchers.anyString())).
                thenReturn(User.builder().userName("ram").password("ram").
                        roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}
