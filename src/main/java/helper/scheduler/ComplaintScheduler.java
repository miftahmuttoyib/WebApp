package helper.scheduler;

import bo.BOImplement.ComplaintBOImp;
import bo.BOImplement.ProblemBOImp;
import bo.BOImplement.TechnicianBOImp;
import bo.ComplaintBO;
import bo.ProblemBO;
import bo.TechnicianBO;
import obj.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComplaintScheduler implements Runnable {
    private TechnicianBO technicianBO = new TechnicianBOImp();
    private ComplaintBO complaintBO = new ComplaintBOImp();

    @Override
    public void run() {
        List<Complaint> complaintList = complaintBO.selectComplaintByStatus(1);

        if (complaintList.size() == 0) return;
        if (complaintList.size() == 1) {
            Complaint complaint = complaintList.get(0);
            serveComplaint(complaint);
        } else {
            Complaint highestPriorityComplain = sortComplain(complaintList);
            serveComplaint(highestPriorityComplain);
        }
    }

    private void serveComplaint(Complaint complaint) {
        List<Technician> team = orderTeam(complaint.getProblemId());
        if(team.size() == 0) return;
        complaint.setTechnicianList(team);
        complaintBO.updateComplaint(complaint, 2);
    }

    private List<Technician> orderTeam(int problemId) {
        ProblemBO problemBO = new ProblemBOImp();
        Problem problem = problemBO.getProblemById(String.valueOf(problemId));
        int manpower = problem.getManpower();
        if (manpower <= 1) {
            problem.setManpower(2);
            manpower = 2;
        }
        List<Technician> technicianList = technicianBO.getTeam(manpower, problem.getWorkingType());
        technicianBO.updateStatus(technicianList);
        return technicianList;
    }
    private Complaint sortComplain(List<Complaint> complaintList) {
        List<Complaint> highestPriorityComplain = selectComplainByPriority(complaintList);
        if (highestPriorityComplain.size() == 1) {
            return highestPriorityComplain.get(0);
        } else {
            List<Complaint> shortestComplain = selectComplainByShortestJob(highestPriorityComplain);
            if (shortestComplain.size() == 1) {
                return shortestComplain.get(0);
            } else {
                return getFirsQueueComplain(complaintList);
            }
        }
    }
    private List<Complaint> selectComplainByPriority(List<Complaint> complaintList) {
        int highestPriorityNumber = getHighestPriorityNumber(complaintList);
        return complaintList.stream().filter(complain -> complain.getApartment().getRoom(complain.getRoomId()).getFacilities(complain.getFacilitiesId()).getProblem(complain.getProblemId()).getPriority() == highestPriorityNumber).collect(Collectors.toList());
    }
    private List<Complaint> selectComplainByShortestJob(List<Complaint> complaintList) {
        int shortestNumber = getShortestNumber(complaintList);
        return complaintList.stream().filter(complain -> complain.getApartment().getRoom(complain.getRoomId()).getFacilities(complain.getFacilitiesId()).getProblem(complain.getProblemId()).getExecutionTime() == shortestNumber).collect(Collectors.toList());
    }
    private Complaint getFirsQueueComplain(List<Complaint> complaintList) {
        complaintList.sort(Comparator.comparing(Complaint::getCreateDate));
        return complaintList.get(0);
    }
    private int getHighestPriorityNumber(List<Complaint> complaintList) {
        int result = 0;
        for (Complaint complain : complaintList) {
            int priority = complain.getApartment().getRoom(complain.getRoomId()).getFacilities(complain.getFacilitiesId()).getProblem(complain.getProblemId()).getPriority();
            if (result == 0) {
                result = priority;
            }

            if (priority < result) {
                result = priority;
            }
            String a = String.valueOf(result);
        }
        return result;
    }
    private int getShortestNumber(List<Complaint> complaintList) {
        int result = 0;
        for (Complaint complain : complaintList) {
            int priority = complain.getApartment().getRoom(complain.getRoomId()).getFacilities(complain.getFacilitiesId()).getProblem(complain.getProblemId()).getExecutionTime();
            if (result == 0) {
                result = priority;
            }

            if (priority < result) {
                result = priority;
            }
        }
        return result;
    }
}


