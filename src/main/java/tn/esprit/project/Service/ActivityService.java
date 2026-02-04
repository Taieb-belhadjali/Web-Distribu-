package tn.esprit.project.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.project.Entity.Activity;
import tn.esprit.project.Repository.ActivityRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    public Activity create(Activity activity) {
        activity.setCreatedAt(LocalDateTime.now());
        activity.setUpdateddAt(LocalDateTime.now());
        return activityRepository.save(activity);
    }

    public Activity getById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    }

    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    public Activity update(Long id, Activity activity) {
        Activity existing = getById(id);

        existing.setTitle(activity.getTitle());
        existing.setDescription(activity.getDescription());
        existing.setStartDate(activity.getStartDate());
        existing.setEndDate(activity.getEndDate());
        existing.setEvoluation(activity.getEvoluation());
        existing.setStatus(activity.getStatus());
        existing.setContext(activity.getContext());
        existing.setType(activity.getType());
        existing.setUpdateddAt(LocalDateTime.now());

        return activityRepository.save(existing);
    }

    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}
