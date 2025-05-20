package com.tka.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "class_schedules")
@Getter
@Setter
@NoArgsConstructor
public class ClassSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "subject_id", nullable = false)
	private Long subjectId;

	@Column(name = "classroom_id", nullable = false)
	private Long classroomId;
	
	@Column(name = "day_of_week", nullable = false)
	private String dayOfWeek;
	
	@Column(name = "start_time", nullable = false)
	private Time startTime;
	
	@Column(name = "end_time", nullable = false)
	private Time endTime;

	public ClassSchedule(Long subjectId, Long classroomId, String dayOfWeek, Time startTime, Time endTime) {
		super();
		this.subjectId = subjectId;
		this.classroomId = classroomId;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	
}
