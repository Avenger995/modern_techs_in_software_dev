package com.example.footballers.services.interfaces;

import com.example.footballers.dto.FormationsDto;

public interface IFormationsService {
    Iterable<FormationsDto> getAll();
}
