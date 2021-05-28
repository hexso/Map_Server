package com.jun.springboot.service.map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoMapAPIService {
    
    @Transactional
    public Object getLocationWithKeyword(String keyword){
        String url = "https://dapi.kakao.com/v2/local/search/keyword.json";
        String service_key = "KakaoAK 055b8e263291bce43188971c8d31f0ac";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", service_key);
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
        .queryParam("query", keyword)
        .build(false);
        
        Object response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        return response;
    }
}
