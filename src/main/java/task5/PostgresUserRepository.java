package task5;

public class PostgresUserRepository implements IUserRepository {
    @Override
    public void updateUser(UserProfile profile) {
        System.out.println(
                "[PostgreSQL DB] Оновлено профіль користувача "
                        + profile.getUserId()
                        + " (" + profile.getUsername() + ") у БД."
        );
    }
}
