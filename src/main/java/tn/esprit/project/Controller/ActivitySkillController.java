package tn.esprit.project.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project.Entity.ActivitySkill;
import tn.esprit.project.Service.ActivitySkillService;

import java.util.List;

@RestController
@RequestMapping("/activity/{activityId}/skills")
@RequiredArgsConstructor
public class ActivitySkillController {

    private final ActivitySkillService activitySkillService;

    @PostMapping
    public ActivitySkill addSkill(@PathVariable Long activityId, @RequestBody ActivitySkill skill) {

        return activitySkillService.addSkillToActivity(activityId, skill);
    }

    @GetMapping
    public List<ActivitySkill> getSkills(@PathVariable Long activityId) {
        return activitySkillService.getSkillsByActivity(activityId);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        activitySkillService.deleteSkill(id);
    }
}
