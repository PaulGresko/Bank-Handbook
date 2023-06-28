package com.example.bankSystem.services;


import com.example.bankSystem.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl{

    private final PersonRepository personRepository;

    @Autowired
    public UserServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return personRepository.findById(username).orElseThrow(()->new NoSuchElementException("User not found"));
//    }
}
