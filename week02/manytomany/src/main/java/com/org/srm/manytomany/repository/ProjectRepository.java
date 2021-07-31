package com.org.srm.manytomany.repository;

import java.util.List;

import com.org.srm.manytomany.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByProjectTitleContaining(String projecttitle);

    List<Project> findByProfitLessThan(double profit);
}
