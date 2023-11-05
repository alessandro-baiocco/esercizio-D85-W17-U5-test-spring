package application.U5D5.interfaces;

import application.U5D5.entities.User;

public interface UserServiceInterface {
    public void save(User user);

    public void findByIdAndUpdate(User user);

    public void findByIdAndDelete(int id);

    public User findById(int id);


    public User getRandomUser();



}

