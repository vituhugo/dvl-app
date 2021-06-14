package com.dvlcube.app.jpa.repo;

import com.dvlcube.app.jpa.BasicRepository;
import com.dvlcube.app.jpa.DvlRepository;
import com.dvlcube.app.manager.data.JobBean;
import com.dvlcube.app.manager.data.SkillBean;
import org.springframework.stereotype.Repository;

/**
 * @since 4 de jun de 2019
 * @author Ulisses Lima
 */
@Repository
public interface JobRepository extends DvlRepository<JobBean, Long>, BasicRepository<JobBean, Long> {
}
