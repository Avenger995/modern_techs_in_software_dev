package com.example.footballers.soap;

import com.example.footballers.dto.SkillsDto;
import com.example.footballers.exceptions.SoapException;
import com.example.footballers.mappers.SkillsMapper;
import com.example.footballers.models.Players;
import com.example.footballers.models.Skills;
import com.example.footballers.repos.interfaces.IPlayerRepos;
import com.example.footballers.repos.interfaces.ISkillsRepos;

import javax.jws.WebService;
import java.text.MessageFormat;
import java.util.NoSuchElementException;

@WebService(serviceName = "Skills")
public class SkillsServiceImpl implements SkillsService {

    private final IPlayerRepos _playerRepos;
    private final ISkillsRepos _skillsRepos;


    public SkillsServiceImpl(IPlayerRepos playerRepos, ISkillsRepos skillsRepos){
        _playerRepos = playerRepos;
        _skillsRepos = skillsRepos;
    }

    @Override
    public String addOrUpdSkills(SkillsDto skills) throws SoapException {
        String result = "{0} player's skills was updated";
        Players player = _playerRepos.findById(skills.getPlayer()).orElse(null);
        if (player == null) {
            Throwable t = new NoSuchElementException("No such player");
            throw new SoapException("No such player", t);
        }
        Skills existedSkills = _skillsRepos.getSkillsByPlayerAndSeason(skills.getPlayer(), skills.getSeasonStart());
        if (existedSkills == null) {
            Skills skillsToAdd = SkillsMapper.INSTANCE.toModel(skills);
            _skillsRepos.save(skillsToAdd);
        } else {
            if (skills.getDefence() != null)
                existedSkills.setDefence(skills.getDefence());
            if (skills.getPassing() != null)
                existedSkills.setPassing(skills.getPassing());
            if (skills.getDribbling() != null)
                existedSkills.setDribbling(skills.getDribbling());
            if (skills.getPhysic() != null)
                existedSkills.setPhysic(skills.getPhysic());
            if (skills.getShot() != null)
                existedSkills.setShot(skills.getShot());
            if (skills.getSpeed() != null)
                existedSkills.setSpeed(skills.getSpeed());
            _skillsRepos.save(existedSkills);
        }
        return MessageFormat.format(result, player.getName());
    }

    @Override
    public Skills getSkills(Integer playerId, Integer season) throws SoapException {
        Players player = _playerRepos.findById(playerId).orElse(null);
        if (player == null) {
            Throwable t = new NoSuchElementException("No such player");
            throw new SoapException("No such player", t);
        }
        Skills existedSkills = _skillsRepos.getSkillsByPlayerAndSeason(playerId, season);
        if (existedSkills == null) {
            Throwable t = new NoSuchElementException("No such year for player " + player.getName());
            throw new SoapException("No such year for player " + player.getName(), t);
        }
        return existedSkills;
    }

    @Override
    public String delSkills(Integer playerId, Integer season) throws SoapException {
        String result = "%s player's skills for was deleted for year %s";
        Players player = _playerRepos.findById(playerId).orElse(null);
        if (player == null) {
            Throwable t = new NoSuchElementException("No such player");
            throw new SoapException("No such player", t);
        }
        Skills existedSkills = _skillsRepos.getSkillsByPlayerAndSeason(playerId, season);
        if (existedSkills == null) {
            Throwable t = new NoSuchElementException("No such year for player " + player.getName());
            throw new SoapException("No such year for player " + player.getName(), t);
        }
        _skillsRepos.delete(existedSkills);
        return String.format(result, player.getName(), season.toString());
    }
}
