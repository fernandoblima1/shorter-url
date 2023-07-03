package com.fernando.shorterurl.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.shorterurl.entities.ShortedUrl;

@Repository
public interface ShortedUrlRepository extends JpaRepository<ShortedUrl, UUID> {

  Optional<ShortedUrl> findByResourceId(String shortedUrlId);

}
