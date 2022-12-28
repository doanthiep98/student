package com.example.demo.repository;

import com.example.demo.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
//    @Query("SELECT t FROM Transcript t WHERE t.student.classes.classesId=:classId AND t.subject.subjectId=:subjectId ORDER BY t.point DESC ")
//    List<Transcript> selectTranscriptBySubjectAndClass(@Param("classId") long classId, @Param("subjectId") long subjectId);

//    @Query("SELECT t FROM Transcript t WHERE t.transcriptId = ?1")
//    List<Transcript> displayAllTranscript(@Param("transcriptId")int id);

    @Query(nativeQuery = true,value = "")
    List<Transcript> displayPassRate();
}
