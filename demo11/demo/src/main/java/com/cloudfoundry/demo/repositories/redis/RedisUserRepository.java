package com.cloudfoundry.demo.repositories.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;

import com.cloudfoundry.demo.bean.RandomIdGenerator;
import com.cloudfoundry.demo.bean.User;

public class RedisUserRepository implements CrudRepository<User, String> {
	public static final String USERS_KEY = "users";

    private final RandomIdGenerator idGenerator;
    private final HashOperations<String, String, User> hashOps;

    public RedisUserRepository(RedisTemplate<String, User> redisTemplate) {
        this.hashOps = redisTemplate.opsForHash();
        this.idGenerator = new RandomIdGenerator();
    }

    @Override
    public <S extends User> S save(S user) {
        if (user.getId() == null) {
            user.setId(idGenerator.generateId());
        }

        hashOps.put(USERS_KEY, user.getId(), user);

        return user;
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> users) {
        List<S> result = new ArrayList<>();

        for (S entity : users) {
            save(entity);
            result.add(entity);
        }

        return result;
    }

    @Override
    public User findOne(String id) {
        return hashOps.get(USERS_KEY, id);
    }

    @Override
    public boolean exists(String id) {
        return hashOps.hasKey(USERS_KEY, id);
    }

    @Override
    public Iterable<User> findAll() {
        return hashOps.values(USERS_KEY);
    }

    @Override
    public Iterable<User> findAll(Iterable<String> ids) {
        return hashOps.multiGet(USERS_KEY, convertIterableToList(ids));
    }

    @Override
    public long count() {
        return hashOps.keys(USERS_KEY).size();
    }

    @Override
    public void delete(String id) {
        hashOps.delete(USERS_KEY, id);
    }

    @Override
    public void delete(User user) {
        hashOps.delete(USERS_KEY, user.getId());
    }

    @Override
    public void delete(Iterable<? extends User> users) {
        for (User user : users) {
            delete(user);
        }
    }

    @Override
    public void deleteAll() {
        Set<String> ids = hashOps.keys(USERS_KEY);
        for (String id : ids) {
            delete(id);
        }
    }

    private <T> List<T> convertIterableToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        for (T object : iterable) {
            list.add(object);
        }
        return list;
    }

}
