package com.gfa.orientation_exam_example.controllers;

import com.gfa.orientation_exam_example.models.SecretCode;
import com.gfa.orientation_exam_example.models.UrlAlias;
import com.gfa.orientation_exam_example.services.UrlAliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UrlAliasRestController {
    private final UrlAliasService urlAliasService;

    @Autowired
    public UrlAliasRestController(UrlAliasService urlAliasService) {
        this.urlAliasService = urlAliasService;
    }

    @GetMapping("/a/{alias}")
    public ResponseEntity<Void> redirectToAlias(@PathVariable(required = false) String alias) {
        UrlAlias urlAlias = urlAliasService.getUrlAliasByAlias(alias);
        if (urlAlias != null) {
            urlAliasService.incrementHitCount(urlAlias);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .location(URI.create(urlAlias.getUrl()))
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/api/links")
    public ResponseEntity<List<UrlAlias>> showUrlAliasEntries() {
        return ResponseEntity.status(200).body(urlAliasService.getUrlAliasEntries());
    }

    @DeleteMapping("/api/links/{id}")
    public ResponseEntity<Void> deleteUrlAlias(@PathVariable long id,
                                               @RequestBody(required = false) SecretCode secretCode) {
        Optional<UrlAlias> urlAlias = urlAliasService.getUrlAliasById(id);
        if (urlAlias.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            if (!Objects.equals(urlAlias.get().getSecretCode(), secretCode.getSecretCode())) {
                return ResponseEntity.status(403).build();
            } else {
                urlAliasService.deleteUrlAlias(id);
                return ResponseEntity.status(204).build();
            }
        }
    }
}
