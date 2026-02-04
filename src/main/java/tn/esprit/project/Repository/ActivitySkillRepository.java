package tn.esprit.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.project.Entity.ActivitySkill;

import java.util.List;

@Repository
public interface ActivitySkillRepository extends JpaRepository<ActivitySkill, Long> {
    List<ActivitySkill> findByActivityId(Long activityId);
}
