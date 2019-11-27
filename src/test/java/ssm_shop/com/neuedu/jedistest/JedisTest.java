package ssm_shop.com.neuedu.jedistest;

import redis.clients.jedis.Jedis;

public class JedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		System.out.println(jedis.ping());
		jedis.set("conpony", "东软睿道");
		String l = jedis.get("conpony");
		System.out.println(l);
		System.out.println(jedis.get("name"));
		System.out.println("==================");
		System.out.println(jedis.keys("*"));
		System.out.println(jedis.dbSize());
		jedis.close();
	}
}
