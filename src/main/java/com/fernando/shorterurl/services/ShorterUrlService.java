package com.fernando.shorterurl.services;

import java.net.URL;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fernando.shorterurl.entities.ShortedUrl;
import com.fernando.shorterurl.repositories.ShortedUrlRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShorterUrlService {

  private final ShortedUrlRepository shortedUrlRepository;

  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

  public String generateUniqueId() {
    SecureRandom random = new SecureRandom();
    List<Character> allowedCharacters = new ArrayList<>();

    for (char c : CHARACTERS.toCharArray()) {
      allowedCharacters.add(c);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      int randomIndex = random.nextInt(allowedCharacters.size());
      char randomChar = allowedCharacters.get(randomIndex);
      sb.append(randomChar);
    }

    return sb.toString();
  }

  public ResponseEntity<Object> saveNewShortedUrl(URL url) {
    ShortedUrl shortedUrl = new ShortedUrl();
    shortedUrl.setOriginalUrl(url);
    shortedUrl.setCreatedAt(LocalDateTime.now());
    shortedUrl.setExpirDate(LocalDateTime.now().plusDays(7));
    shortedUrl.setResourceId(generateUniqueId());
    shortedUrl.setClicks(0);
    return ResponseEntity.status(HttpStatus.CREATED).body(shortedUrlRepository.save(shortedUrl));
  }

  public ResponseEntity<Page<ShortedUrl>> findAllShortedUrls(Integer page, Integer limit, String sortBy,
      Boolean sortDesc) {
    // RETURN SHORTED URL LIST
    return null;
  }

  public ResponseEntity<Object> redirect(UUID shortedUrlId) {
    // REDIRECT TO ORIGINAL URL
    return null;
  }

}
