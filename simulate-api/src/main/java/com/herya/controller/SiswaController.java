package com.herya.controller;

import com.herya.model.Siswa;
import com.herya.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://smayani.sch.id:2082")
@RestController
@RequestMapping("/api")
public class SiswaController {

    @Autowired
    SiswaRepository siswarepository;

    @GetMapping("/siswa")
    public ResponseEntity<List<Siswa>> getAllSiswa(@RequestParam(required = false) String namasiswa){
        try{
            List<Siswa> siswas = new ArrayList<Siswa>();

            if (namasiswa == null)
                siswarepository.findAll().forEach(siswas::add);
            else
                siswarepository.findBySiswabimbelContaining(namasiswa).forEach(siswas::add);

            if (siswas.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(siswas, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/siswa/{id}")
    public ResponseEntity<Siswa> getSiswaById(@PathVariable("id") Long id){
        Optional<Siswa> siswaData = siswarepository.findById(id);

        if (siswaData.isPresent()){
            return new ResponseEntity<>(siswaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/siswa")
    public ResponseEntity<Siswa> createSiswa(@RequestBody Siswa siswa){
        try{
            Siswa _siswa = siswarepository
                    .save(new Siswa(siswa.getSiswabimbel(), siswa.getEmail(),false));
            return new ResponseEntity<>(_siswa, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PutMapping("/siswa/{id}")
    public ResponseEntity<Siswa> updateSiswa(@PathVariable("id") long id, @RequestBody Siswa siswa){
        Optional<Siswa> siswaData = siswarepository.findById(id);
        if (siswaData.isPresent()){
            Siswa _siswa = siswaData.get();
            _siswa.setSiswabimbel(siswa.getSiswabimbel());
            _siswa.setEmail(siswa.getEmail());
            _siswa.setPublished(siswa.isPublished());
            return new ResponseEntity<>(siswarepository.save(_siswa), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/siswa/{id}")
    public ResponseEntity<HttpStatus> deleteSiswa(@PathVariable("id") long id){
        try{
            siswarepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @DeleteMapping("/siswa")
    public ResponseEntity<HttpStatus> deleteAllSiswa(){
        try{
            siswarepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/siswa/published")
    public ResponseEntity<List<Siswa>> findByPublished(){
        try{
            List<Siswa> siswas = siswarepository.findByPublished(true);

            if (siswas.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(siswas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
