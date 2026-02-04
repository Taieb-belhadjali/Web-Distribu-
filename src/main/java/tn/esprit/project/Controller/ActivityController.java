package tn.esprit.project.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project.Entity.Activity;
import tn.esprit.project.Service.ActivityService;

import java.util.List;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public Activity create(@RequestBody Activity activity) {
        return activityService.create(activity);
    }

    @GetMapping("/{id}")
    public Activity getById(@PathVariable Long id) {
        return activityService.getById(id);
    }

    @GetMapping
    public List<Activity> getAll() {
        return activityService.getAll();
    }

    @PutMapping("/{id}")
    public Activity update(@PathVariable Long id, @RequestBody Activity activity) {
        return activityService.update(id, activity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        activityService.delete(id);
    }
}
