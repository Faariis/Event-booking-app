package com.projekat.dogadjaji_196.service;

import com.projekat.dogadjaji_196.exception.DogadjajNotFoundException;
import com.projekat.dogadjaji_196.model.Dogadjaj;
import com.projekat.dogadjaji_196.repo.DogadjajRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DogadjajService {
    private final DogadjajRepo dogadjajRepo;

    @Autowired
    public DogadjajService(DogadjajRepo dogadjajRepo) {
        this.dogadjajRepo = dogadjajRepo;
    }

    public Dogadjaj dodajDogadjaj(Dogadjaj dogadjaj) {
        dogadjaj.setKodDogadjaja(UUID.randomUUID().toString());
        return dogadjajRepo.save(dogadjaj);
    }

    public List<Dogadjaj> nadjiSveDogadjaje() {
        return dogadjajRepo.findAll();
    }

    public Dogadjaj updateDogadjaj(Dogadjaj dogadjaj) {
        return dogadjajRepo.save(dogadjaj);
    }

    public Dogadjaj findDogadjajById(Long id) {
        return dogadjajRepo.findDogadjajById(id).orElseThrow(() -> new DogadjajNotFoundException("Dogadjaj sa id-om " + id + " ne može se pronaći!"));
    }

    public void deleteDogadjaj(Long id) {
        dogadjajRepo.deleteDogadjajById(id);
    }
}
