package tn.esprit.project.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.project.Entity.Activity;
import tn.esprit.project.Entity.ActivitySkill;
import tn.esprit.project.Repository.ActivityRepository;
import tn.esprit.project.Repository.ActivitySkillRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivitySkillService {

    private final ActivitySkillRepository activitySkillRepository;
    private final ActivityRepository activityRepository;

    public ActivitySkill addSkillToActivity(Long activityId, ActivitySkill skill) {

        Activity activity = activityRepository.findById(activityId).orElseThrow(() -> new RuntimeException("Activity not found"));

        skill.setActivity(activity);
        return activitySkillRepository.save(skill);
    }

    public List<ActivitySkill> getSkillsByActivity(Long activityId) {
        return activitySkillRepository.findByActivityId(activityId);
    }

    public void deleteSkill(Long id) {
        activitySkillRepository.deleteById(id);
    }
}
