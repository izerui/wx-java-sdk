package tests;

import com.qq.weixin.IToken;
import com.qq.weixin.mappings.AccessToken;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class RedisToken implements IToken {

    protected Jedis jedis = new Jedis("localhost");

    private final static String SECRET_PREFIX = "secret:";
    private final static String TOKEN_PREFIX = "token:";

    public RedisToken(Map<String, String> apps) {
        apps.forEach((key, value) -> {
            jedis.set(SECRET_PREFIX + key, value);
        });
    }

    @Override
    public String getSecret(String appId) {
        return jedis.get(SECRET_PREFIX + appId);
    }

    @Override
    public String getToken(String appId) {
        return jedis.get(TOKEN_PREFIX + appId);
    }

    @Override
    public void updateToken(String appId, AccessToken token) {
        jedis.set(TOKEN_PREFIX + appId, token.getAccessToken());
        jedis.expire(TOKEN_PREFIX + appId, 3600);
    }

    @Override
    public void deleteToken(String appId) {
        jedis.del(TOKEN_PREFIX + appId);
    }
}