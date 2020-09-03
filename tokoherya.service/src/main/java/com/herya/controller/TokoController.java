package com.herya.controller;

import com.herya.model.TokoDto;
import com.herya.service.TokoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/toko")
@RestController
public class TokoController {
    private final TokoService tokoService;

    public TokoController(TokoService tokoService){
        this.tokoService = tokoService;
    }
    @GetMapping({"/{tokoId}"})
    public ResponseEntity<TokoDto> getToko(@PathVariable("tokoId")UUID tokoId){
        return new ResponseEntity<>(tokoService.getTokoById(tokoId), HttpStatus.OK);
    }

    @PostMapping // Untuk membuat toko baru
    public ResponseEntity handlePost(TokoDto tokoDto){
        TokoDto savedDto = tokoService.saveNewToko(tokoDto);

        HttpHeaders headers = new HttpHeaders();

        headers.add(" location","/api/v1/toko/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{tokoId"})
    public ResponseEntity handleUpdate(@PathVariable("tokoId")UUID tokoId, TokoDto tokoDto){
        tokoService.updateToko(tokoId, tokoDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{tokoId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteToko(@PathVariable("tokoId") UUID tokoId){
        tokoService.deleteToko(tokoId);
    }
}
