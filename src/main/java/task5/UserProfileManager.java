package task5;

import java.util.Objects;

public class UserProfileManager {

    private final ICacheService cacheService;
    private final IUserRepository userRepository;
    private final INotificationClient notificationClient;

    public UserProfileManager(
            ICacheService cacheService,
            IUserRepository userRepository,
            INotificationClient notificationClient) {

        this.cacheService = Objects.requireNonNull(cacheService);
        this.userRepository = Objects.requireNonNull(userRepository);
        this.notificationClient = Objects.requireNonNull(notificationClient);
    }

    public void updateProfile(UserProfile profile) {
        if (profile == null
                || profile.getUserId() == null
                || profile.getUserId().isEmpty()) {

            throw new IllegalArgumentException("Некоректний профіль користувача.");
        }

        userRepository.updateUser(profile);

        cacheService.invalidateCache(profile.getUserId());

        notificationClient.sendSecurityAlert(
                profile.getEmail(),"Дані вашого профілю були успішно оновлені."
        );
    }
}
