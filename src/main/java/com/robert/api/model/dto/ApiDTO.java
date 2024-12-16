package com.robert.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiDTO {

    @JsonProperty("jobs")
    private List<Job> jobs;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Job{

        private Integer position;
        private String title;

        @JsonProperty("company_name")
        private String companyName;

        private String location;

        private String description;

        @JsonProperty("job_highlights")
        private List<JobHighlight> jobHighlights;

        @JsonProperty("apply_link")
        private String applyLink;

        @JsonProperty("apply_links")
        private List<ApplyLink> applyLinks;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class JobHighlight{
            private String title;

            @JsonProperty("items")
            private List<String> items;

        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ApplyLink{
            private String link;
            private String source;
        }

    }
}
