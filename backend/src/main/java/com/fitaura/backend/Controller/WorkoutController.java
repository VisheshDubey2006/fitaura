package com.fitaura.backend.controller;

import com.fitaura.backend.model.Workout;
import com.fitaura.backend.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutService.createWorkout(workout);
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public Workout getWorkoutById(@PathVariable Long id) {
        return workoutService.getWorkoutById(id);
    }

    @PutMapping("/{id}")
    public Workout updateWorkout(@PathVariable Long id, @RequestBody Workout workout) {
        return workoutService.updateWorkout(id, workout);
    }

    @DeleteMapping("/{id}")
    public String deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return "Workout deleted successfully";
    }
}