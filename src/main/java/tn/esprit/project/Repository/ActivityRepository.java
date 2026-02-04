package tn.esprit.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.project.Entity.Activity;
import tn.esprit.project.Entity.ActivitySkill;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
