package com.example.footballers.soap;

import com.example.footballers.dto.SkillsDto;
import com.example.footballers.exceptions.SoapException;
import com.example.footballers.models.Skills;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.NoSuchElementException;

@WebService(name = "addSkill")
public interface SkillsService {


    @WebMethod(operationName = "addSkill")
    String addOrUpdSkills(@WebParam(name="skills", targetNamespace = "") SkillsDto skills) throws SoapException;

    @WebMethod(operationName = "getSkill")
    Skills getSkills(@WebParam(name="playerId", targetNamespace = "") Integer playerId,
                     @WebParam(name="season", targetNamespace = "") Integer season) throws SoapException;

    @WebMethod(operationName = "delSkill")
    String delSkills(@WebParam(name="playerId", targetNamespace = "") Integer playerId,
                     @WebParam(name="season", targetNamespace = "") Integer season) throws SoapException;
}
