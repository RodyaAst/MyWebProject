package com.example.java.input_parser;

import com.example.java.entities.Job;
import com.example.java.inputs.JobInput;
public class JobInputParser {

    public static Job fromInput(JobInput jobInput) {
        var job = Job.builder()
                .name(jobInput.getName())
                .salary(jobInput.getSalary())
                .since(jobInput.getSince())
                .build();
        return job;
    }
}
