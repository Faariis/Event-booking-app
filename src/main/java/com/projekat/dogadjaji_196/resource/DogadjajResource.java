package com.projekat.dogadjaji_196.resource;
import com.projekat.dogadjaji_196.model.Dogadjaj;
import com.projekat.dogadjaji_196.service.DogadjajService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogadjaj")
public class DogadjajResource {
    private final DogadjajService dogadjajService;

    public DogadjajResource(DogadjajService dogadjajService) {
        this.dogadjajService = dogadjajService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dogadjaj>> getAllDogadjaje() {
        List<Dogadjaj> dogadjaji = dogadjajService.nadjiSveDogadjaje();
        return new ResponseEntity<>(dogadjaji, HttpStatus.OK);
    }
    // GET
    @GetMapping("/find/{id}")
    public ResponseEntity<Dogadjaj> getDogadjajeById(@PathVariable("id") Long id) {
        Dogadjaj dogadjaj = dogadjajService.findDogadjajById(id);
        return new ResponseEntity<>(dogadjaj, HttpStatus.OK);
    }

    // POST
    @PostMapping("/add")
    public ResponseEntity<Dogadjaj> dodajDogadjaj(@RequestBody Dogadjaj dogadjaj) {
        Dogadjaj noviDogadjaj = dogadjajService.dodajDogadjaj(dogadjaj);
        return new ResponseEntity<>(noviDogadjaj, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/update")
    public ResponseEntity<Dogadjaj> updateDogadjaj(@RequestBody Dogadjaj dogadjaj) {
        Dogadjaj izmjeniDogadjaj = dogadjajService.updateDogadjaj(dogadjaj);
        return new ResponseEntity<>(izmjeniDogadjaj, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDogadjaj(@PathVariable("id") Long id) {
        dogadjajService.deleteDogadjaj(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

