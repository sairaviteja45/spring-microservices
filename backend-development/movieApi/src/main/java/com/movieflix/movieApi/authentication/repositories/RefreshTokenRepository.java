package com.movieflix.movieApi.authentication.repositories;

import com.movieflix.movieApi.authentication.entites.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {
}
