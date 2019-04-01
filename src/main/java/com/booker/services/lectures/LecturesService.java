package com.booker.services.lectures;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturesService {

	@Autowired
	private LecturesRepository lecturesRepo;

	public List<Lecture> getAllLectures() {
		return lecturesRepo.findAll();
	}

	public Lecture saveOrUpdateLecture(Lecture lecture) {
		return lecturesRepo.save(lecture);
	}

	public void deleteLecture(Lecture lecture) {
		lecturesRepo.delete(lecture);
	}
}
