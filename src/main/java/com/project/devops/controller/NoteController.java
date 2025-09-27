package com.project.devops.controller;

import com.project.devops.model.Note;
import com.project.devops.repository.NoteRepository;
import com.project.devops.service.S3Service;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteRepository repo;
    private final S3Service s3Service;

    public NoteController(NoteRepository repo, S3Service s3Service) {
        this.repo = repo;
        this.s3Service = s3Service;
    }

    @GetMapping
    public List<Note> allNotes() {
        return repo.findAll();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return repo.save(note);
    }

    @PostMapping("/upload")
    public String uploadFile() {
        // Example: Upload a test file to S3
        s3Service.uploadFile("my-app-bucket", "test.txt", Paths.get("/mnt/data/test.txt"));
        return "Uploaded to S3!";
    }
}
