package task5;

public class MockUserRepository implements IUserRepository {
    @Override
    public void updateUser(UserProfile profile) {
        System.out.println(
                "[MOCK DB] Імітація оновлення користувача "
                        + profile.getUserId()
        );
    }
}
