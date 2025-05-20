package com.tka.entity;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="faculty_attendance")
@Data
@NoArgsConstructor
public class FacultyAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="faculty_id", nullable = false)
	private Faculty faculty;
	
	@ManyToOne
	@JoinColumn(name="class_schedule_id",nullable = false)
	private ClassSchedule classSchedule;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private String status;
	
}
