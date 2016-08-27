package com.hengbao.ctl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@RestController
public class ClientController {

	@Autowired
	RestTemplate restTemplate;
//	
//	@Autowired
//	DiscoveryClient discoveryClient;
	
	@Autowired
	EurekaClient eurekaClient;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/hello")
	public Map<String,String>sayHello(HttpServletRequest req,HttpSession session){
//		Cookie[] cookies = req.getCookies();
//		for(Cookie cookie : cookies){
//			System.out.println(cookie.getName());
//		}
		System.out.println(eurekaClient.getNextServerFromEureka("TEST-SERVICE", false).getPort());
		System.out.println("aaaaaaaaaaaaa:"+System.currentTimeMillis());
		Map<String,String> res = new HashMap<String,String>();
		res = restTemplate.getForObject("http://TEST-SERVICE/hello", Map.class);
		return res;
	}

}


//@SuppressWarnings({ "unchecked", "rawtypes" })
//@RequestMapping("/hello")
//public Map<String,String>sayHello(){
//	String jsonParam="{\"username\":\"刘祖刚\",\"password\":\"aaa\"}";
//	HttpHeaders headers = new HttpHeaders();
//	headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//	HttpEntity<String> entity = new HttpEntity<String>(jsonParam,headers);
//	Map param = restTemplate.postForObject("http://OAUTH2-SERVER/uaa/public/service/userRes", entity, Map.class);
//	System.out.println(param);
//	return param;
//}
