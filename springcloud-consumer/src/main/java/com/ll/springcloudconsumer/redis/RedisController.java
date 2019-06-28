package com.ll.springcloudconsumer.redis;

import com.ll.springcloudapi.entities.News;
import com.ll.springcloudapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.concurrent.TimeUnit;
@Controller
public class RedisController {

Map<String, User> UserMap = new HashMap<String, User>();
@Autowired
private RedisTemplate redisTemplate;
	@RequestMapping("/insertNews")
	@ResponseBody
	public void insertNews() {
		ListOperations<String, News> operations = redisTemplate.opsForList();
		List<News> list = new ArrayList<>();
//		//再次赋值就可以修改
		for (int i=0;i<10;i++){
			News entity = new News();
			entity.setTitle("第"+i+"条新闻");
			entity.setContent("第"+i+"条内容");
			entity.setLink("第"+i+"条链接");
			// 插入缓存
			list.add(entity);

		}
		operations.leftPushAll("news",list);
	}

	//增删改查String类型 为json类型
    @RequestMapping("/getNews")
	public String insertData(Map<String,Object> map) {
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		ListOperations<String,News> operations1 = redisTemplate.opsForList();
		List<News> list = operations1.getOperations().opsForList().range("news",0,100);
		Collections.reverse(list);
		map.put("list",list);
		System.out.println(list);
		return "main";
	}

//增删改查hash
   @RequestMapping("/insertmap")
	@ResponseBody
	public void insertMap() {
		HashOperations operations = redisTemplate.opsForHash();

		String key = "User_" + 33;
		boolean hasKey = redisTemplate.hasKey(key);// 判断是否有
		if (hasKey) {
			Set<String> keys = redisTemplate.keys("*");

			System.out.println(keys);
			for (String keyss:keys){
				Object object = redisTemplate.opsForValue().get(keyss);
				System.out.println(object);
			}

			// operations.getOperations().delete(key);//删除.
			return;
		}
		// 修改map在插入就可以
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "qqq");
		map.put(2, "www");
		map.put(3, "eee");
		map.put(4, "rrr");
		operations.putAll(key, map);

	}

//增删改查list
    @RequestMapping("/insertlist")
	@ResponseBody
	public void insertList() {
		ListOperations operations = redisTemplate.opsForList();
		String key = "User_" + 33;
		boolean hasKey = redisTemplate.hasKey(key);// 判断是否有
		if (hasKey) {
			Object a = operations.range(key, 0, 3);//查询
			System.out.println(a);
//			operations.getOperations().delete(key);//删除
			return;
		}
		List list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		operations.leftPushAll(key, list);
	}

//增删改查set
    @RequestMapping("/insertset")
	@ResponseBody
	public void insertSet() {
		SetOperations operations = redisTemplate.opsForSet();
		String key = "User_" + 55;
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey) {
			operations.members(key);//查询
			operations.getOperations().delete(key);//删除
			return;
		}
		operations.add(key, "111");
		operations.add(key, "222");
		operations.add(key, "333");
	}	
}
