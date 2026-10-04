package com.fitaura.backend.service;

import com.fitaura.backend.model.Goal;
import com.fitaura.backend.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal getGoalById(Long id) {
        return goalRepository.findById(id).orElse(null);
    }

    public Goal updateGoal(Long id, Goal goal) {

        Goal existingGoal = goalRepository.findById(id).orElse(null);

        if (existingGoal == null) {
            return null;
        }

        existingGoal.setGoalName(goal.getGoalName());
        existingGoal.setDescription(goal.getDescription());
        existingGoal.setTargetDate(goal.getTargetDate());
        existingGoal.setStatus(goal.getStatus());

        return goalRepository.save(existingGoal);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
}