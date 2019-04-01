package com.booker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booker.services.lectures.Lecture;
import com.booker.services.lectures.LecturesService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/lecture")
public class LecturesController {

	@Autowired
	LecturesService lecturesService;

	@GetMapping("/getAll")
	public List<Lecture> getAllLectures() {
		return lecturesService.getAllLectures();
	}

	@PostMapping("/save")
	public void saveLecture(@RequestParam("title") String title, @RequestParam("description") String description,
			@RequestParam("attachmentUrl") String attachmentUrl) {
		Lecture lecture = new Lecture();
		lecture.setTitle(title);
		lecture.setDescription(description);
		lecture.setAttachmentDownloadUrl(attachmentUrl);
		lecturesService.saveOrUpdateLecture(lecture);
	}

	@PostMapping("/update")
	public void updateLecture(@RequestBody Lecture lecture) {
		lecturesService.saveOrUpdateLecture(lecture);
	}

	@PostMapping("/delete")
	public void deleteLecture(@RequestBody Lecture lecture) {
		lecturesService.deleteLecture(lecture);
	}
}
