package com.mywebapp.medicineproject.input_parser;

import com.mywebapp.medicineproject.entities.Job;
import com.mywebapp.medicineproject.inputs.JobInput;

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
