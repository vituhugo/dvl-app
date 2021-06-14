package com.dvlcube.app.rest;

import com.dvlcube.app.interfaces.MenuItem;
import com.dvlcube.app.jpa.repo.JobRepository;
import com.dvlcube.app.manager.data.JobBean;
import com.dvlcube.app.manager.data.vo.MxRestResponse;
import com.dvlcube.utils.interfaces.rest.MxFilterableBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

import static com.dvlcube.app.manager.data.e.Menu.CONFIGURATION;

@RestController
@MenuItem(value = CONFIGURATION)
@RequestMapping("${dvl.rest.prefix}/jobs")
public class JobService implements MxFilterableBeanService<JobBean, Long> {

    @Autowired
    private JobRepository repo;

    @Override
    @GetMapping
    public Iterable<JobBean> get(Map<String, String> params) {
        return repo.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<JobBean> get(@PathVariable Long id) {
        return repo.findById(id);
    }

    @Override
    @PostMapping
    public MxRestResponse post(@Valid @RequestBody JobBean body) {
        JobBean save = repo.save(body);
        return GenericRestResponse.ok(save.getId());
    }

    @DeleteMapping("/{id}")
    public MxRestResponse delete(@PathVariable Long id) {
        Optional<JobBean> deleted = repo.findById(id);
        if (deleted.isEmpty()) return GenericRestResponse.error("Job not found");

        repo.delete(deleted.get());
        return GenericRestResponse.ok();
    }

    @Override
    public Iterable<JobBean> getLike(String id) {
        return null;
    }
}
