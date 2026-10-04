package com.fitaura.backend.service;

import com.fitaura.backend.model.Workout;
import com.fitaura.backend.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id).orElse(null);
    }

    public Workout updateWorkout(Long id, Workout workout) {

        Workout existingWorkout = workoutRepository.findById(id).orElse(null);

        if (existingWorkout == null) {
            return null;
        }

        existingWorkout.setType(workout.getType());
        existingWorkout.setDuration(workout.getDuration());
        existingWorkout.setIntensity(workout.getIntensity());
        existingWorkout.setWorkoutDate(workout.getWorkoutDate());

        return workoutRepository.save(existingWorkout);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}