package com.projekat.dogadjaji_196.repo;

import com.projekat.dogadjaji_196.model.Dogadjaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DogadjajRepo extends JpaRepository<Dogadjaj, Long> {
    void deleteDogadjajById(Long id);
    Optional<Dogadjaj> findDogadjajById(Long id);
}
