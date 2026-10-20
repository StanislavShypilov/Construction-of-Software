package task5;

public class RedisCacheService implements ICacheService {

    @Override
    public void invalidateCache(String key) {
        System.out.println(
                "[Redis Cache] Видалено кеш за ключем: user:cache:" + key
        );
    }
}
