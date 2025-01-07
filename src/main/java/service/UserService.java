package service;

import domain.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void changePassword(Long userId, String newPassword) {
        User user = findUserById(userId);
        if (user != null) {
            user.changePassword(newPassword);
            userRepository.save(user);
        }
    }

    public void updateProfile(Long userId, String email, String phoneNumber) {
        User user = findUserById(userId);
        if (user != null) {
            user.updateProfile(email, phoneNumber);
            userRepository.save(user);
        }
    }
}
