package com.automation.pojos.hw3Pojo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_id",
        "name",
        "mascot",
        "headOfHouse",
        "houseGhost",
        "founder",
        "__v",
        "school",
        "members",
        "values",
        "colors"
})
public class House1 {

        @JsonProperty("_id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("mascot")
        private String mascot;
        @JsonProperty("headOfHouse")
        private String headOfHouse;
        @JsonProperty("houseGhost")
        private String houseGhost;
        @JsonProperty("founder")
        private String founder;
        @JsonProperty("__v")
        private Integer v;
        @JsonProperty("school")
        private String school;
        @JsonProperty("members")
        private String members;
        @JsonProperty("values")
        private List<String> values = null;
        @JsonProperty("colors")
        private List<String> colors = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("_id")
        public String getId() {
            return id;
        }

        @JsonProperty("_id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("mascot")
        public String getMascot() {
            return mascot;
        }

        @JsonProperty("mascot")
        public void setMascot(String mascot) {
            this.mascot = mascot;
        }

        @JsonProperty("headOfHouse")
        public String getHeadOfHouse() {
            return headOfHouse;
        }

        @JsonProperty("headOfHouse")
        public void setHeadOfHouse(String headOfHouse) {
            this.headOfHouse = headOfHouse;
        }

        @JsonProperty("houseGhost")
        public String getHouseGhost() {
            return houseGhost;
        }

        @JsonProperty("houseGhost")
        public void setHouseGhost(String houseGhost) {
            this.houseGhost = houseGhost;
        }

        @JsonProperty("founder")
        public String getFounder() {
            return founder;
        }

        @JsonProperty("founder")
        public void setFounder(String founder) {
            this.founder = founder;
        }

        @JsonProperty("__v")
        public Integer getV() {
            return v;
        }

        @JsonProperty("__v")
        public void setV(Integer v) {
            this.v = v;
        }

        @JsonProperty("school")
        public String getSchool() {
            return school;
        }

        @JsonProperty("school")
        public void setSchool(String school) {
            this.school = school;
        }

        @JsonProperty("members")
        public String getMembers() {
            return members;
        }

        @JsonProperty("members")
        public void setMembers(String members) {
            this.members = members;
        }

        @JsonProperty("values")
        public List<String> getValues() {
            return values;
        }

        @JsonProperty("values")
        public void setValues(List<String> values) {
            this.values = values;
        }

        @JsonProperty("colors")
        public List<String> getColors() {
            return colors;
        }

        @JsonProperty("colors")
        public void setColors(List<String> colors) {
            this.colors = colors;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

