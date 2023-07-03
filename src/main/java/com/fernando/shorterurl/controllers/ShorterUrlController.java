package com.fernando.shorterurl.controllers;

import java.net.URL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.shorterurl.services.ShorterUrlService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/link")
public class ShorterUrlController {

  private final ShorterUrlService shorterUrlService;

  @PostMapping
  public ResponseEntity<Object> shortLink(@RequestParam URL url) {

    return shorterUrlService.saveNewShortedUrl(url);

  }

  @GetMapping("/all")
  public ResponseEntity<Object> findAllShortedUrls(@RequestParam Integer page, @RequestParam Integer limit,
      @RequestParam String sortBy, @RequestParam Boolean sortDesc) {
    return shorterUrlService.findAllShortedUrls(page, limit, sortBy, sortDesc);
  }

  @PatchMapping("/{shortedUrlId}")
  public ResponseEntity<Object> findOneShortedUrl(@PathVariable String shortedUrlId) {
    return shorterUrlService.redirect(shortedUrlId);
  }

}
