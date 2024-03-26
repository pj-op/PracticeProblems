package web.pocs.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.pocs.beans.model.Actor;
import web.pocs.repository.ActorRepo;

import java.util.List;

@Slf4j
@Service
public class ActorService {

    @Autowired
    private ActorRepo actorRepo;

    public int getTotalNumberOfRecords() {
        return actorRepo.totalRec();
    }

    //Custom Pagination
    public void getCustomPaginatedData() {
        int totalRec = getTotalNumberOfRecords();
        int threshold = 20;
        int iteration = totalRec / threshold;
        int rem = totalRec % threshold;
        int start = 0;

        while (iteration != 0) {
            log.info("{}", actorRepo.findActorByOffSet(start, start + threshold));
            start = start + threshold;
            iteration--;
        }

    }

    //Pagination
    public void paginatedActorFromLib() {
        int totalRec = getTotalNumberOfRecords();
        int threshold = 20;
        int iteration = totalRec / threshold;
        int rem = totalRec % threshold;
        Pageable pageable = null;
        int start = 0;


//        while (iteration != 0) {
        pageable = PageRequest.of(start, start + threshold);
        log.info("{}", actorRepo.findAllActors(pageable));
        pageable = PageRequest.of(20, 40);
        log.info("{}", actorRepo.findAllActors(pageable));

//            start = start + threshold;
//            iteration--;
//        }

    }

    public void paginatedActor() throws InterruptedException {

        int totalRec = getTotalNumberOfRecords();

        int threshold = 20;
        int recordsToProcess = totalRec / threshold;
        int rem = totalRec % threshold;
        int start = 1;

        start = processRec(recordsToProcess, start, threshold);
        log.info("START: {}", start);
        if (rem > 0) log.info("{}", actorRepo.findActorByOffSetBetween(start, totalRec));
    }

    private int processRec(int recordsToProcess, int start, int threshold) throws InterruptedException {
        for (int i = 1; i < recordsToProcess; i++) {
            Thread.sleep(3000);
            log.info("Iteration: {} :- {}", i, actorRepo.findActorByOffSetBetween(start, start + threshold));
            start = start + threshold;
        }
        return start;
    }
}
