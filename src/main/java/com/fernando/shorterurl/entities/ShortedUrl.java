package com.fernando.shorterurl.entities;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SHORTED_URL_TB")
public class ShortedUrl {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private URL originalUrl;
  private String resourceId;
  private LocalDateTime expirDate;
  private LocalDateTime createdAt;
  private Integer clicks;
}
