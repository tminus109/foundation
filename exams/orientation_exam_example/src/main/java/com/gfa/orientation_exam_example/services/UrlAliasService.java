package com.gfa.orientation_exam_example.services;

import com.gfa.orientation_exam_example.models.UrlAlias;
import com.gfa.orientation_exam_example.models.SecretCode;
import com.gfa.orientation_exam_example.repositories.UrlAliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlAliasService {
    private final UrlAliasRepository urlAliasRepository;

    @Autowired
    public UrlAliasService(UrlAliasRepository urlAliasRepository) {
        this.urlAliasRepository = urlAliasRepository;
    }

    public boolean isAliasInUse(String alias) {
        UrlAlias urlAlias = urlAliasRepository.findByAliasIgnoreCase(alias);
        return urlAlias != null;
    }

    public UrlAlias getUrlAliasByAlias(String alias) {
        return urlAliasRepository.findByAliasIgnoreCase(alias);
    }

    public void saveNewUrlAlias(UrlAlias urlAlias, SecretCode secretCode) {
        urlAlias.setSecretCode(secretCode.getSecretCode());
        urlAliasRepository.save(urlAlias);
    }

    public void incrementHitCount(UrlAlias urlAlias) {
        urlAlias.setHitCount(urlAlias.getHitCount() + 1);
        urlAliasRepository.save(urlAlias);
    }

    public List<UrlAlias> getUrlAliasEntries() {
        return (List<UrlAlias>) urlAliasRepository.findAll();
    }

    public Optional<UrlAlias> getUrlAliasById(long id) {
        return urlAliasRepository.findById(id);
    }

    public void deleteUrlAlias(long id) {
        urlAliasRepository.deleteById(id);
    }
}
