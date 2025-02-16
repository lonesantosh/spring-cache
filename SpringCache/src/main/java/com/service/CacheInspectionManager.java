package com.service;

import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

//@Service("cacheManager")
@Configuration
public class CacheInspectionManager {

	@Autowired
	private CacheManager cacheManager;

	
	public void printCacheContent(String cacheName) {
		
		org.springframework.cache.Cache cache= cacheManager.getCache(cacheName);
		if(cache!=null) {
			System.out.println("Cache content");
			System.out.println(Objects.requireNonNull(cache.getNativeCache().toString()));
		}else
		{
			System.out.println("No such cache"+cache);
		}
	}
}
