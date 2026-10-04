package com.fitaura.backend.controller;

import com.fitaura.backend.model.Goal;
import com.fitaura.backend.service.GoalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.createGoal(goal);
    }

    @GetMapping
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public Goal getGoalById(@PathVariable Long id) {
        return goalService.getGoalById(id);
    }

    @PutMapping("/{id}")
    public Goal updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        return goalService.updateGoal(id, goal);
    }

    @DeleteMapping("/{id}")
    public String deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
        return "Goal deleted successfully";
    }
}