package application.U5D5.services;

import application.U5D5.exceptions.ItemNotFoundException;
import application.U5D5.interfaces.UserServiceInterface;
import application.U5D5.repositories.UserRepo;
import application.U5D5.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class UsersService implements UserServiceInterface {
    Random rnd = new Random();

    @Autowired
    private UserRepo userRepo;


    @Override
    public void save(User user) {
        userRepo.save(user);
        log.info(user.getName() + " salvato correttamente!");
    }

    @Override
    public User findById(int id) throws ItemNotFoundException {
       return userRepo.findById(id).orElseThrow(() -> new  ItemNotFoundException(id));
    }

    @Override
    public User getRandomUser() {
     return userRepo.findAllUser().get(rnd.nextInt(0 , userRepo.findAllUser().size() - 1));
    }


    @Override
    public void findByIdAndUpdate(User user) {
        User found = this.findById(user.getId());
        found.setName(user.getName());
        found.setLastName(user.getLastName());
        found.setSurname(user.getSurname());
        found.setEmail(user.getEmail());
        userRepo.save(found);
        log.info("User con id " + user.getId() + " aggiornato con successo!");
    }

    @Override
    public void findByIdAndDelete(int id) throws ItemNotFoundException {
        User found = this.findById(id);
        userRepo.delete(found);
        log.info("User con id " + id + " eliminato con successo!");

    }



}
