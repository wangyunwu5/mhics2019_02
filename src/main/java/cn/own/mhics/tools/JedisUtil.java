package cn.own.mhics.tools;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.own.mhics.common.Constant;
import cn.own.mhics.exception.CustomException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisUtil {
	
	/**
	 * jedis连接池
	 * 
	 */
	private static JedisPool jedisPool;
	
	@Autowired
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	/**
	 * 获取Jedis实例
	 * @return
	 */
	public static synchronized Jedis getJedis() {
		try {
			if(jedisPool != null) {
				return jedisPool.getResource();
			}
			else {
				return null;
			}
		}catch(Exception e) {
			throw new CustomException("获取Jedis资源异常:"+e.getMessage());
		}
	}
	
	/**
	 * 释放Jedis资源
	 */
	public static void closePool() {
		try {
			jedisPool.close();
		}catch(Exception e) {
			throw new CustomException("释放Jedis资源异常"+e.getMessage());
		}
	}
	
	/**
	 * 获取redis键值-object
	 * @param key
	 * @return
	 */
	public static Object getObject(String key) {
		try(Jedis jedis = jedisPool.getResource()) {
			//获取指定键的值
			byte[] bytes = jedis.get(key.getBytes());
			if(StringUtil.isNotNull(bytes)) {
				return SerializableUtil.unserializable(bytes);
			}
		}
		catch(Exception e) {
			throw new CustomException("获取redis键值getObject方法异常:"+e.getMessage());
		}
		return null;
	}
	
	/**
	 * 设置redis键值 object
	 * @param key
	 * @param value
	 * @return
	 */
	public static String setObject(String key,Object value) {
		try(Jedis jedis = jedisPool.getResource()){
			return jedis.set(key.getBytes(),SerializableUtil.serializable(value));
		}
		catch(Exception e) {
			throw new CustomException("设置Redis键值setObject方法异常：key="+key+" value="+value+" cause="+e.getMessage());
		}
	}
	
	/**
	 * 设置redis键值 -object-expiretime
	 * @param key
	 * @param value
	 * @param expiretime
	 * @return
	 */
	public static String setObject(String key,Object value,int expiretime) {
		String result;
		try(Jedis jedis = jedisPool.getResource()) {
			//插入数据
			result = jedis.set(key.getBytes(),SerializableUtil.serializable(value));
			if(Constant.OK.equals(result)) {
				//设置一个键生存时间，单位为秒
				jedis.expire(key.getBytes(),expiretime);
			}
			return result;
		}
		catch(Exception e) {
			throw new CustomException("设置Redis键值setObject方法异常key="+key+" value="+value+" cause="+e.getMessage());
		}
	}
	
	/**
	 * 获取redis键值，json
	 * @param key
	 * @return
	 */
	public static String getJson(String key) {
		try(Jedis jedis = jedisPool.getResource()){
			//获取指定键的值
			return jedis.get(key);
		}
		catch(Exception e) {
			throw new CustomException("获取Redis键值getJson方法异常:key=" + key + " cause=" + e.getMessage());
		}
	}
	/**
	 * 删除key
	 * @param key
	 * @return
	 */
	public static Long delKey(String key) {
		try(Jedis jedis = jedisPool.getResource()){
			//删除指定键
			return jedis.del(key.getBytes());
		}
		catch(Exception e) {
			throw new CustomException("删除redis的键delKey方法异常：key="+key+" cause="+e.getMessage());
		}
	}
	
	/**
	 * 查询key是否存在
	 * @param key
	 * @return
	 */
	public static boolean exists(String key) {
		try(Jedis jedis = jedisPool.getResource()) {
			//判断指定键是否存在
			return jedis.exists(key.getBytes());
		}
		catch(Exception e) {
			throw new CustomException("查询Redis的键是否存在exists方法异常;key="+key+" cause="+e.getMessage());
		}
	}
	
	/**
	 * 模糊查询获取key集合，keys的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，生产不推荐使用
	 * @param key
	 * @return
	 */
	public static Set<String> keysS(String key){
		try(Jedis jedis = jedisPool.getResource()){
			return jedis.keys(key);
		}
		catch(Exception e) {
			throw new CustomException("模糊查询jedis键集合keysS方法异常:key="+key+" cause="+e.getMessage());
		}
	}
	
	/**
	 * 模糊查询获取key集合，keys的速度非常快，但在一个大的数据库中使用它仍然可能造成性能问题，生产不推荐使用
	 * @param key
	 * @return
	 */
	public static Set<byte[]> keysB(String key){
		try(Jedis jedis = jedisPool.getResource()){
			return jedis.keys(key.getBytes());
		}
		catch(Exception e) {
			throw new CustomException("模糊查询jedis键集合keysS方法异常:key="+key+" cause="+e.getMessage());
		}
	}
	
	/**
	 * 获取剩余过期时间
	 * @param key
	 * @return
	 */
	public static Long ttl(String key) {
		Long result = -2L;
		try(Jedis jedis = jedisPool.getResource()){
			result = jedis.ttl(key);
			return result;	
		}
		catch(Exception e) {
			throw new CustomException("获取Redis键剩余过期时间ttl方法异常:key="+key+" cause="+e.getMessage());
		}
	}
}
