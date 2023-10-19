package com.example.footballers.services;

import com.example.footballers.dto.FormationsDto;
import com.example.footballers.mappers.FormationsMapper;
import com.example.footballers.mappers.PlayersMapper;
import com.example.footballers.repos.interfaces.IFormationsRepos;
import com.example.footballers.services.interfaces.IFormationsService;
import org.springframework.stereotype.Service;

@Service
public class FormationsService implements IFormationsService {

    private final IFormationsRepos _formationsRepos;

    public FormationsService(IFormationsRepos formationsRepos) {
        this._formationsRepos = formationsRepos;
    }

    public Iterable<FormationsDto> getAll() {
        return FormationsMapper.toDtoIterable(_formationsRepos.findAll());
    }
}
