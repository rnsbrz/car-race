package com.spring.porscheRace.config;

import com.spring.porscheRace.repository.RaceRepository;
import com.spring.porscheRace.repository.UserRepository;
import com.spring.porscheRace.service.RaceService;
import com.spring.porscheRace.service.RaceServiceImpl;
import com.spring.porscheRace.service.UserService;
import com.spring.porscheRace.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final RaceRepository raceRepository;
    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(RaceRepository raceRepository, UserRepository userRepository){
        this.raceRepository = raceRepository;
        this.userRepository = userRepository;
    }

    @Bean
    @Qualifier("RaceService")
    public RaceService getRaceService(){
        return new RaceServiceImpl(raceRepository);
    }
    @Bean
    @Qualifier("UserService")
    public UserService getUserService(){
        return new UserServiceImpl(userRepository);
    }
}
