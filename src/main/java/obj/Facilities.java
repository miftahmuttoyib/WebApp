package obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.jooq.DSLContext;
import schema.tables.records.FacilitiesProblemRecord;
import schema.tables.records.FacilitiesRecord;
import stdc.IdName;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static schema.Tables.FACILITIES_PROBLEM;
import static stdc.IdName.ColumnName.ID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facilities extends IdName {
    public static final String TABLE_NAME = "facilities";
    public static final String FOREIGN_KEY_NAME = TABLE_NAME + "_" + ID;

    public static final class ColumnName {
        public final static String FACILITIES_TYPE = "facilities_type";

    }
    public Facilities() {

    }

    @Column(name = ColumnName.FACILITIES_TYPE)
    private String facilitiesType = "";

    private List<Problem> problemList = new ArrayList<>();

    public static class FacilitiesProblem {
        @Column(name = FOREIGN_KEY_NAME)
        private int facilitiesId;

        @Column(name = Problem.FOREIGN_KEY_NAME)
        private int problemId;

        public FacilitiesProblem() {
        }
        public int getFacilitiesId() {
            return facilitiesId;
        }

        public void setFacilitiesId(int facilitiesId) {
            this.facilitiesId = facilitiesId;
        }
        public int getProblemId() {
            return problemId;
        }
        public void setProblemId(int problemId) {
            this.problemId = problemId;
        }

    }

    public String getFacilitiesType() {
        return facilitiesType;
    }
    public void setFacilitiesType(String facilitiesType) {
        this.facilitiesType = facilitiesType;
    }

    public List<Problem> getProblemList() {
        return problemList;
    }
    public Problem getProblem(int problemId) {
        return this.problemList.stream().filter(f -> f.getId() == problemId).findAny().orElse(null);
    }
    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }
    public void addProblem(Problem problem) {
        this.problemList.add(problem);
    }
    public void addAllProblem(List<Problem> problems) {
        this.problemList.addAll(problems);
    }

    public void mapToRecord(FacilitiesRecord newRecord) {
        newRecord.setId(this.getId());
        newRecord.setName(this.getName());
        newRecord.setFacilitiesType(this.getFacilitiesType());
    }

    public List<FacilitiesProblemRecord> createChildRecord(DSLContext db) {
        List<FacilitiesProblemRecord> resultList = new ArrayList<>();
        for (Problem problem : this.getProblemList()) {
            FacilitiesProblemRecord childRecord = db.newRecord(FACILITIES_PROBLEM);
            childRecord.setFacilitiesId(this.getId());
            childRecord.setProblemId(problem.getId());
            resultList.add(childRecord);
        }
        return resultList;
    }

    public void childMap(List<FacilitiesProblem> resultChildList, List<Problem> problems) {
        List<Facilities.FacilitiesProblem> childItems = resultChildList.stream().filter(item -> item.getFacilitiesId() == this.getId()).collect(Collectors.toList());
        for (Facilities.FacilitiesProblem item : childItems) {
            List<Problem> problemItems = problems.stream().filter(p -> p.getId() == item.getProblemId()).collect(Collectors.toList());
            this.addAllProblem(problemItems);
        }
    }
}
